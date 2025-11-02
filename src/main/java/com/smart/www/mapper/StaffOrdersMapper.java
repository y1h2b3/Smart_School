package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.StaffOrders;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【staff_orders】的数据库操作Mapper
 * @createDate 2024-04-07 21:51:43
 * @Entity generator.domain.StaffOrders
 */
public interface StaffOrdersMapper extends BaseMapper<StaffOrders> {

    List<StaffOrders> findAllStaffOrders(int size, int offset, String orders, Boolean isAsc);

    int countStaffOrders();

    List<StaffOrders> searchStaffOrders(int size, int offset, String orders, Boolean isAsc, String id, String name, String type);

    int countSearchStaffOrders(String id, String name, String type);

    @Delete("delete from staff_orders where orders_id = #{sid}")
    int removeStaffOrdersBySid(String sid);

    int updateStaffOrders(StaffOrders staffOrders);

    List<StaffOrders> searchStaffOrdersLocation(String location);
}




