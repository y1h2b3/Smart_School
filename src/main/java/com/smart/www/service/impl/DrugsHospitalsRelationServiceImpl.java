package com.smart.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.DrugsHospitalsRelationMapper;
import com.smart.www.pojo.DrugsHospitalsRelation;
import com.smart.www.service.DrugsHospitalsRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【drugs_hospitals_relation】的数据库操作Service实现
 * @createDate 2024-03-24 01:45:28
 */
@Service
public class DrugsHospitalsRelationServiceImpl extends ServiceImpl<DrugsHospitalsRelationMapper, DrugsHospitalsRelation>
        implements DrugsHospitalsRelationService {

    @Autowired
    private DrugsHospitalsRelationMapper drugsHospitalsRelationMapper;


    @Override
    public List<DrugsHospitalsRelation> findDrugsRelation() {
        LambdaQueryWrapper<DrugsHospitalsRelation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DrugsHospitalsRelation::getRelationType, 1);
        return drugsHospitalsRelationMapper.selectList(wrapper);
    }

    @Override
    public List<DrugsHospitalsRelation> findHospitalsGradeRelation() {
        LambdaQueryWrapper<DrugsHospitalsRelation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DrugsHospitalsRelation::getRelationType, 2);
        return drugsHospitalsRelationMapper.selectList(wrapper);
    }

    @Override
    public List<DrugsHospitalsRelation> findHospitalsTypeRelation() {
        LambdaQueryWrapper<DrugsHospitalsRelation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DrugsHospitalsRelation::getRelationType, 3);
        return drugsHospitalsRelationMapper.selectList(wrapper);
    }

    @Override
    public boolean updateHospitalsDrugsRelation(DrugsHospitalsRelation drugsHospitalsRelation, int Relation) {
        return drugsHospitalsRelationMapper.updateHospitalsDrugsRelation(drugsHospitalsRelation.getTypeId(), drugsHospitalsRelation.getTypeName(), Relation) > 0;
    }

    @Override
    public boolean removeHospitalsDrugsById(Integer typeId, int i) {
        return drugsHospitalsRelationMapper.removeHospitalsDrugsById(typeId, i) > 0;
    }

    @Override
    public boolean saveDrugsHospitalsRelation(DrugsHospitalsRelation drugsHospitalsRelation, int i) {
        return drugsHospitalsRelationMapper.saveDrugsHospitalsRelation(drugsHospitalsRelation.getTypeId(), drugsHospitalsRelation.getTypeName(), i) > 0;
    }

    @Override
    public List<DrugsHospitalsRelation> findDrugsRelationByValue(String value, int i) {
        return drugsHospitalsRelationMapper.findDrugsRelationByValue(value, i);
    }
}




