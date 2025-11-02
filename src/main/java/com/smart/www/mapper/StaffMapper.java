package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【staff】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.Staff
 */
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

    List<Staff> searchByName(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from smart_campus.staff where name like concat('%',#{value},'%') ")
    int countStaffByName(String value);

    List<Staff> searchByStaffId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from smart_campus.staff where staff_id like concat('%',#{value},'%') ")
    int countStaffByStaffId(String value);

    List<Staff> searchByIsActive(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from smart_campus.staff where is_active like concat('%',#{value},'%') ")
    int countStaffByIsActive(String value);

    List<Staff> searchByLocation(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from smart_campus.staff where location like concat('%',#{value},'%') ")
    int countStaffByLocation(String value);

    List<Staff> searchBySex(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from smart_campus.staff where sex like concat('%',#{value},'%') ")
    int countStaffBySex(String value);

    List<Staff> searchStaff(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc,
                            @Param("id") String id, @Param("name") String name, @Param("isOnline") String isOnline,@Param("location") String location);

    int countStaff(@Param("id") String id, @Param("name") String name, @Param("isOnline") String isOnline,@Param("location") String location);
}




