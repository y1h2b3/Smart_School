package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.UserHealth;
import com.smart.www.pojo.query.PageQuery;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【user_health】的数据库操作Service
 * @createDate 2024-03-18 08:35:47
 */
public interface UserHealthService extends IService<UserHealth> {
    Page<UserHealth> searchStudentUserHealthType(PageQuery pageQuery, String id, String name);

    Page<UserHealth> findStudentUserHealth(PageQuery pageQuery);

    Page<UserHealth> findTeacherUserHealth(PageQuery pageQuery);

    Page<UserHealth> findLogisticsUserHealth(PageQuery pageQuery);

    Page<UserHealth> searchTeacherUserHealthType(PageQuery pageQuery, String id, String name);

    Page<UserHealth> searchLogisticsUserHealthType(PageQuery pageQuery, String id, String name);

    List<UserHealth> findId(String uid);

    void updateCheck(String userId, String s);

    List<UserHealth> searchIdUserHealthType(String uid);

    UserHealth findUserHealthByTime(String userId, String time);
}
