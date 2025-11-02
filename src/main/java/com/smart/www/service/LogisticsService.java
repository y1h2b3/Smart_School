package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.Logistics;
import com.smart.www.pojo.query.PageQuery;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【logistics】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface LogisticsService extends IService<Logistics> {

    Page<Logistics> searchLogisticsType(PageQuery pageQuery, String post, String id, String name, String phone);

    boolean updateLogistics(Logistics logistics);

    Page<Logistics> findAllLogistics(PageQuery pageQuery);

    boolean removeLogisticsByLid(String lid);

    List<Logistics> findAllLogistics2();

    Long getLogisticsToTal();
}
