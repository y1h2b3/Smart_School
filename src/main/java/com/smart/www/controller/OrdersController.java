package com.smart.www.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.mapper.OrdersMapper;
import com.smart.www.pojo.Orders;
import com.smart.www.pojo.Vo.OrdersVo;
import com.smart.www.pojo.dto.PageDTO;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import com.smart.www.service.OrdersService;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "订单管理")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private LogsDataService logsDataService;

    /**
     * 查询所有订单
     *
     * @return
     */
    @GetMapping("/orders")
    @Operation(summary = "查询所有订单")
    public Result<PageDTO<OrdersVo>> findAllOrders(PageQuery pageQuery) {
        try {
            Page<Orders> page1 = ordersService.findAllOrders(pageQuery);
            return getPageDTOResult(page1);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 根据关键字查询订单
     *
     * @return
     */
    @GetMapping("/searchOrders")
    @Operation(summary = "根据关键字查询订单")
    public Result<PageDTO<OrdersVo>> searchOrdersType(PageQuery pageQuery, String oid, String uid, String type,String startTime,String endTime) {
        try {
            Page<Orders> page1 = ordersService.searchOrdersType(pageQuery, oid, uid, type,startTime,endTime);
            return getPageDTOResult(page1);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    @NotNull
    private Result<PageDTO<OrdersVo>> getPageDTOResult(Page<Orders> page1) {
        List<OrdersVo> OrdersVos = page1.getRecords().stream().map(this::ConvertToVo).collect(Collectors.toList());
        PageDTO<OrdersVo> OrdersVoPageDTO = new PageDTO<>();
        OrdersVoPageDTO.setRecords(OrdersVos);
        OrdersVoPageDTO.setPages((int) page1.getPages());
        OrdersVoPageDTO.setTotal((int) page1.getTotal());
        return Result.ok(OrdersVoPageDTO);
    }

    /**
     * 根据id删除订单
     *
     * @param oid
     * @return
     */
    @DeleteMapping("/orders/{oid}")
    @Operation(summary = "根据id删除订单")
    public Result removeOrdersByOid(@PathVariable String oid,HttpServletRequest request ) {
        Page<Orders> page1 = ordersService.findAllOrders(new PageQuery());
        boolean b = ordersService.removeOrdersByOid(oid);
        if (b) {
            logsDataService.addLogsData("admin",
                    "删除订单",
                    "删除成功",
                    "删除id:" + page1.getRecords().get(0).getOrderId() + ",购买药品:" + page1.getRecords().get(0).getDrugName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "删除订单",
                    "删除失败",
                    "删除id:" + page1.getRecords().get(0).getOrderId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 更新订单信息
     *
     * @param orders
     * @return
     */
    @PutMapping("/orders")
    @Operation(summary = "更新订单信息")
    public Result updateOrders(@RequestBody Orders orders, HttpServletRequest request) {
        orders.setUpdateTime(new Date());
        boolean b = ordersService.updateOrders(orders);
        if (b) {
            logsDataService.addLogsData("admin",
                    "更新订单",
                    "更新成功",
                    "更新id:" + orders.getOrderId() + ",购买药品:" + orders.getDrugName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "更新订单",
                    "更新失败",
                    "更新id:" + orders.getOrderId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    /**
     * 添加订单
     *
     * @param orders
     * @return
     */
    @PostMapping("/orders")
    @Operation(summary = "添加订单")
    public Result addOrders(@RequestBody Orders orders, HttpServletRequest request) {
        orders.setCreateTime(new Date());
        orders.setUpdateTime(new Date());
        orders.setTime(new Date());
        boolean b = ordersService.save(orders);
        if (b) {
            logsDataService.addLogsData("admin",
                    "添加订单",
                    "添加成功",
                    "添加id:" + orders.getOrderId() + ",购买药品:" + orders.getDrugName(),
                    1,
                    request.getRemoteAddr());
            return Result.ok(null);
        } else {
            logsDataService.addLogsData("admin",
                    "添加订单",
                    "添加失败",
                    "添加id:" + orders.getOrderId() + "不存在",
                    0,
                    request.getRemoteAddr());
            return Result.build(null, ResultCodeEnum.ERROR);
        }
    }

    private OrdersVo ConvertToVo(Orders orders) {
        OrdersVo ordersVo = new OrdersVo();
        ordersVo.setOrderId(orders.getOrderId());
        ordersVo.setUserId(orders.getUserId());
        ordersVo.setDrugName(orders.getDrugName());
        ordersVo.setTime(orders.getTime());
        ordersVo.setPrice(orders.getPrice());
        ordersVo.setQuantity(orders.getQuantity());
        ordersVo.setOrderStatus(orders.getOrderStatus());
        ordersVo.setTotalPrice(orders.getTotalPrice());
        ordersVo.setOrderStatus(orders.getOrderStatus());
        return ordersVo;
    }
}
