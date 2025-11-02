package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.www.pojo.Notifications;
import com.smart.www.pojo.query.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【notifications】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.Notifications
 */
@Mapper
public interface NotificationsMapper extends BaseMapper<Notifications> {

    List<Notifications> searchBytitle(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from notifications where title like CONCAT('%',#{value},'%')")
    int countnotificationsBytitle(String value);

    List<Notifications> searchBypublisher(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from notifications where publisher like CONCAT('%',#{value},'%')")
    int countBypublisher(String value);

    List<Notifications> searchBynotifyGroup(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from notifications where notify_group like CONCAT('%',#{value},'%')")
    int countBynotifyGroup(String value);

    int updateNotifications(Notifications notifications);

    List<Notifications> findAllNotifications(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc,@Param("user")  String user);

    int countAllNotifications(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc,@Param("user") String user);
}




