package com.smart.www.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.DrugsHospitalsRelation;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【drugs_hospitals_relation】的数据库操作Service
 * @createDate 2024-03-24 01:45:28
 */
public interface DrugsHospitalsRelationService extends IService<DrugsHospitalsRelation> {


    List<DrugsHospitalsRelation> findDrugsRelation();


    List<DrugsHospitalsRelation> findHospitalsGradeRelation();

    List<DrugsHospitalsRelation> findHospitalsTypeRelation();

    boolean updateHospitalsDrugsRelation(DrugsHospitalsRelation drugsHospitalsRelation, int Relation);

    boolean removeHospitalsDrugsById(Integer typeId, int i);

    boolean saveDrugsHospitalsRelation(DrugsHospitalsRelation drugsHospitalsRelation, int i);

    List<DrugsHospitalsRelation> findDrugsRelationByValue(String value, int i);
}
