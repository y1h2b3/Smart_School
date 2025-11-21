package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【orders】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.Orders
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    List<Orders> findAllOrders(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) from orders")
    int countAllOrders();

    List<Orders> searchByName(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(d.drug_name) from orders o join drugs d on d.drug_id = o.drug_id")
    int countordersByName(String value);

    List<Orders> searchByordersId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from orders where orders_id like CONCAT('%',#{value},'%')")
    int countordersByordersId(String value);

    List<Orders> searchBystudentId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from orders where student_id like CONCAT('%',#{value},'%')")
    int countordersBystudentId(String value);

    @Delete("delete from orders where order_id = #{oid}")
    int removeOrdersByOid(@Param("oid") String oid);

    int updateOrders(Orders orders);

    List<Orders> searchOrders(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc,
                              @Param("oid") String oid, @Param("uid") String uid, @Param("type") String type,@Param("startTime")String startTime, @Param("endTime")String endTime);

    int countOrders(@Param("oid") String oid, @Param("uid") String uid, @Param("type") String type,@Param("startTime")String startTime, @Param("endTime")String endTime);

    @Select("select drug_name from drugs where drug_id = #{donaDrugId}")
    String findID(String donaDrugId);

}




