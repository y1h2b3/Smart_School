package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.LogsData;
import com.smart.www.pojo.query.PageQuery;

/**
 * @author Administrator
 * @description 针对表【logs_data】的数据库操作Service
 * @createDate 2024-03-25 22:04:58
 */
public interface LogsDataService extends IService<LogsData> {
    boolean addLogsData(String userId, String logsType, String result, String msg, int isSuccess, String ip);

    Page<LogsData> searchLogsData(PageQuery pageQuery, String key, String value, String endTime, String type, String result);

    Page<LogsData> findLogsData(PageQuery pageQuery);
}
