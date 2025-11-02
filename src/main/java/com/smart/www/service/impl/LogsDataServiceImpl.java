package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.LogsDataMapper;
import com.smart.www.pojo.LogsData;
import com.smart.www.pojo.Student;
import com.smart.www.pojo.Vo.LogsDataVo;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.LogsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Administrator
 * @description 针对表【logs_data】的数据库操作Service实现
 * @createDate 2024-03-25 22:04:58
 */
@Service
public class LogsDataServiceImpl extends ServiceImpl<LogsDataMapper, LogsData>
        implements LogsDataService {

    @Autowired
    private LogsDataMapper logsDataMapper;
    @Autowired
    private LogsDataService logsDataService;

    @Override
    public boolean addLogsData(String userId, String logsType, String result, String msg, int isSuccess, String ip) {
        LogsDataVo logsDataVo = new LogsDataVo();
        logsDataVo.setDataId(UUID.randomUUID().toString());
        logsDataVo.setUserId(userId);
        logsDataVo.setLogsType(logsType);
        logsDataVo.setResult(result);
        logsDataVo.setMsg(msg);
        logsDataVo.setIsSuccess(isSuccess);
        logsDataVo.setIp(ip);
        logsDataVo.setCreateTime(new Date());
        return logsDataMapper.addLogsData(logsDataVo) > 0;
    }

    @Override
    public Page<LogsData> searchLogsData(PageQuery pageQuery, String key, String value, String endTime, String type, String result) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<LogsData> list = null;
        int total = 0;
        Page<LogsData> logsDataPage = new Page<>();
//            switch (key) {
//                case "userId":
//                    //模糊查询name的value值
//                    list = logsDataMapper.searchByUserId(size, offset, orders, isAsc, value);
//                    total = logsDataMapper.countlogsDataByUserId(value);
//                    break;
//                case "logsType":
//                    list = logsDataMapper.searchByLogsType(size, offset, orders, isAsc, value);
//                    total = logsDataMapper.countByLogsType(value);
//                    break;
//                case "result":
//                    list = logsDataMapper.searchByResult(size, offset, orders, isAsc, value);
//                    total = logsDataMapper.countByResult(value);
//                    break;
//                case "msg":
//                    list = logsDataMapper.searchByMsg(size, offset, orders, isAsc, value);
//                    total = logsDataMapper.countByMsg(value);
//                    break;
//            }
        list = logsDataMapper.searchLogsData(size, offset, orders, isAsc,key, value, endTime, type, result);
        total = logsDataMapper.countLogsData(size, offset, orders, isAsc,key, value, endTime, type, result);
        int pages = (int) Math.ceil((double) total / size);
        logsDataPage.setRecords(list);
        logsDataPage.setTotal(total);
        logsDataPage.setPages(pages);
        return logsDataPage;
    }

    @Override
    public Page<LogsData> findLogsData(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<LogsData> LogsDataList = logsDataMapper.findAllLogsData(size, offset, orders, isAsc);
        Page<LogsData> LogsDataPage = new Page<>();
        LogsDataPage.setRecords(LogsDataList);
        int total = logsDataMapper.countAllLogsData();
        LogsDataPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        LogsDataPage.setPages(pages);
        return LogsDataPage;
    }
}




