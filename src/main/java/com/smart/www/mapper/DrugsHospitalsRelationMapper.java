package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.DrugsHospitalsRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【drugs_hospitals_relation】的数据库操作Mapper
 * @createDate 2024-03-24 01:45:28
 * @Entity com.smart.www.pojo.DrugsHospitalsRelation
 */
@Mapper
public interface DrugsHospitalsRelationMapper extends BaseMapper<DrugsHospitalsRelation> {

    int updateHospitalsDrugsRelation(@Param("typeId") int typeId, @Param("typeName") String typeName, @Param("relation") int relation);

    int removeHospitalsDrugsById(@Param("typeId") Integer typeId, @Param("relation") int relation);

    int saveDrugsHospitalsRelation(@Param("typeId") int typeId, @Param("typeName") String typeName, @Param("relation") int relation);

    List<DrugsHospitalsRelation> findDrugsRelationByValue(@Param("value") String value, @Param("relation") int relation);
}




