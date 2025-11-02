package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.Logistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【logistics】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.Logistics
 */
@Mapper
public interface LogisticsMapper extends BaseMapper<Logistics> {

    List<Logistics> findAlllogistics(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) from logistics")
    int countAlllogistics();

    List<Logistics> searchByName(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from logistics where name like concat('%',#{value},'%')")
    int countlogisticsByName(String value);

    List<Logistics> searchByType(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from logistics where post like concat('%',#{value},'%')")
    int countlogisticsByType(String value);

    List<Logistics> searchBylogisticsId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from logistics where logistics_id like concat('%',#{value},'%')")
    int countlogisticsByTeacherId(String value);

    List<Logistics> searchBysex(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);


    @Select("select count(*) from logistics where sex like concat('%',#{value},'%')")
    int countlogisticsBysex(String value);

    int removeLogisticsByLid(String lid);

    int updateLogistics(Logistics logistics);

    List<Logistics> searchByStatus(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from logistics where status like concat('%',#{value},'%')")
    int countlogisticsByStatus(String value);

    List<Logistics> searchLogistics(@Param("size") int size,
                                    @Param("offset") int offset,
                                    @Param("orders") String orders,
                                    @Param("isAsc") Boolean isAsc,
                                    @Param("post") String post,
                                    @Param("id") String id,
                                    @Param("name") String name, String phone);

    int countLogistics(@Param("post") String post, @Param("id") String id, @Param("name") String name, String phone);

    List<Logistics> findAlllogistics2();

    @Select("select count(*) from logistics")
    Long getLogisticsToTal();
}




