package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.Hospitals;
import com.smart.www.pojo.query.PageQuery;

/**
 * @author Administrator
 * @description 针对表【hospitals】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface HospitalsService extends IService<Hospitals> {

    Page<Hospitals> searchHospitals(PageQuery pageQuery, String key, String value);

    Page<Hospitals> findAllHospitals(PageQuery pageQuery);

    boolean updateHospitals(Hospitals hospitals);
}
