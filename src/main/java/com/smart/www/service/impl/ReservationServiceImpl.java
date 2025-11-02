package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.ReservationMapper;
import com.smart.www.pojo.Reservation;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【reservation】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation>
        implements ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private ReservationService reservationService;

    @Override
    public Page<Reservation> searchReservationType(PageQuery pageQuery, String key, String value) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Reservation> list = null;
        int total = 0;
        Page<Reservation> reservationPage = new Page<>();
        if (key.isEmpty() || value.isEmpty()) {
            return reservationService.page(new Page<>(pageQuery.getCurrent(), pageQuery.getSize()), null);
        } else {
            switch (key) {
                case "reservationId":
                    //模糊查询name的value值
                    list = reservationMapper.searchByreservationId(size, offset, orders, isAsc, value);
                    total = reservationMapper.countreservationByreservationId(value);
                    break;
                case "userId":
                    list = reservationMapper.searchByuserId(size, offset, orders, isAsc, value);
                    total = reservationMapper.countreservationByuserId(value);
                    break;
                case "staffId":
                    list = reservationMapper.searchBystaffId(size, offset, orders, isAsc, value);
                    total = reservationMapper.countstaffId(value);
                    break;
                case "location":
                    list = reservationMapper.searchBylocation(size, offset, orders, isAsc, value);
                    total = reservationMapper.countreservationBylocation(value);
                    break;
            }
        }
        reservationPage.setRecords(list);
        reservationPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        reservationPage.setPages(pages);
        return reservationPage;
    }

    @Override
    public Page<Reservation> findAllReservation(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Reservation> ReservationList = reservationMapper.findAllReservation(size, offset, orders, isAsc);
        Page<Reservation> ReservationPage = new Page<>();
        ReservationPage.setRecords(ReservationList);
        int total = reservationMapper.countAllDrugs();
        ReservationPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        ReservationPage.setPages(pages);
        return ReservationPage;
    }

    @Override
    public boolean removeReservationByRid(String rid) {
        return reservationMapper.removeReservationByRid(rid) > 0;
    }

    @Override
    public boolean updateReservation(Reservation reservation1) {
        return reservationMapper.updateReservation(reservation1) > 0;
    }

}




