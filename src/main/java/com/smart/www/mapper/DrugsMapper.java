package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.Drugs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【drugs】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.Drugs
 */
@Mapper
public interface DrugsMapper extends BaseMapper<Drugs> {

    int deleteByDrugId(String did);

    int updateByDrugId(Drugs drugs);

    int insertDrugs(Drugs drugs);

    @Select("select count(*) from drugs")
    int countAllDrugs();

    @Select("select count(*) from drugs where drug_name like concat('%',#{name},'%')")
    int countDrugsByName(@Param("name") String name);

    @Select("select count(*) from drugs join drugs_type on drugs.type = drugs_type.id and drugs_type.drugs_name like concat('%',#{type},'%')")
    int countDrugsByType(@Param("type") String type);

    List<Drugs> findAllDrugs(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    List<Drugs> searchByName(@Param("size") int size, @Param("offset") int offset, @Param("name") String name, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    List<Drugs> searchByType(@Param("size") int size, @Param("offset") int offset, @Param("type") String type, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    List<Drugs> searchDrugs(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc,
                            @Param("id") String id, @Param("name") String name, @Param("type") String type, @Param("startTime") String startTime, @Param("endTime") String endTime);

    int countDrugs(@Param("id") String id, @Param("name") String name, @Param("type") String type, @Param("startTime") String startTime, @Param("endTime") String endTime);

    @Select("select drug_name as name from drugs where drug_id = #{id}")
    List<Drugs> searchIdDrugs(String id);

    @Select("select type_id from drugs_relation where type_name = #{name}")
    List<Drugs> getTypeID(String name);
}




