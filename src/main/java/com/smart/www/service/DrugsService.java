package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.Drugs;
import com.smart.www.pojo.query.PageQuery;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【drugs】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface DrugsService extends IService<Drugs> {

    Page<Drugs> searchDrugs(PageQuery pageQuery, String id, String name, String type, String startTime, String endTime);

    boolean removeDrugsByDid(String did);

    boolean updateBydrugId(Drugs drugs);

    boolean saveDrugs(Drugs drugs);


    Page<Drugs> findAllDrugs(PageQuery pageQuery);

    List<Drugs> searchIdDrugs(String id);

    List<Drugs> getTypeID(String name);
}
