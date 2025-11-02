package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.pojo.LogsData;
import com.smart.www.pojo.Vo.LogsDataVo;
import com.smart.www.pojo.query.PageQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【logs_data】的数据库操作Mapper
 * @createDate 2024-03-25 22:04:58
 * @Entity com.smart.www.pojo.LogsData
 */
public interface LogsDataMapper extends BaseMapper<LogsData> {

    int addLogsData(LogsDataVo logsDataVo);

    List<LogsData> searchByUserId(int size, int offset, String orders, Boolean isAsc, String value);

    @Select("select count(*) from logs_data where user_id like CONCAT('%',#{value},'%')")
    int countlogsDataByUserId(String value);

    List<LogsData> searchByLogsType(int size, int offset, String orders, Boolean isAsc, String value);

    @Select("select count(*) from logs_data where logs_type like CONCAT('%',#{value},'%'")
    int countByLogsType(String value);

    List<LogsData> searchByResult(int size, int offset, String orders, Boolean isAsc, String value);

    @Select("select count(*) from logs_data where result like CONCAT('%',#{value},'%')")
    int countByResult(String value);

    List<LogsData> searchByMsg(int size, int offset, String orders, Boolean isAsc, String value);

    @Select("select count(*) from logs_data where msg like CONCAT('%',#{value},'%')")
    int countByMsg(String value);

    List<LogsData> searchLogsData(@Param("size") int size,
                                  @Param("offset") int offset,
                                  @Param("orders") String orders,
                                  @Param("isAsc") Boolean isAsc,
                                  @Param("account") String account,
                                  @Param("startTime") String startTime,
                                  @Param("endTime") String endTime,
                                  @Param("type") String type,
                                  @Param("result") String result);


    List<LogsData> findAllLogsData(@Param("size") int size,
                                   @Param("offset") int offset,
                                   @Param("orders") String orders,
                                   @Param("isAsc") Boolean isAsc);

    int countAllLogsData();

    int countLogsData(@Param("size") int size,
                      @Param("offset") int offset,
                      @Param("orders") String orders,
                      @Param("isAsc") Boolean isAsc,
                      @Param("account") String account,
                      @Param("startTime") String startTime,
                      @Param("endTime") String endTime,
                      @Param("type") String type,
                      @Param("result") String result);
}




