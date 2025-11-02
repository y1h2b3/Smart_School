package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.Reservation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【reservation】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.Reservation
 */
@Mapper
public interface ReservationMapper extends BaseMapper<Reservation> {


    List<Reservation> findAllReservation(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) from reservation")
    int countAllDrugs();

    List<Reservation> searchByreservationId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from reservation where reservation_id like CONCAT('%',#{value},'%')")
    int countreservationByreservationId(String value);

    List<Reservation> searchByuserId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from reservation where user_id like CONCAT('%',#{value},'%')")
    int countreservationByuserId(String value);

    List<Reservation> searchBystaffId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from reservation where staff_id like CONCAT('%',#{value},'%')")
    int countstaffId(String value);

    List<Reservation> searchBylocation(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from reservation where location like CONCAT('%',#{value},'%')")
    int countreservationBylocation(String value);

    @Delete("delete from reservation where reservation_id = #{rid}")
    int removeReservationByRid(String rid);

    int updateReservation(Reservation reservation1);
}




