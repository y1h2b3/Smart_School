package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.Parent;
import com.smart.www.pojo.query.PageQuery;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【parent】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface ParentService extends IService<Parent> {

    Page<Parent> searchParentType(PageQuery pageQuery, String clazz, String PName, String SName, String Sid, String phone);

    Page<Parent> findAllParent(PageQuery pageQuery);

    boolean removeParentByPid(String pid);

    String searchParentID(String id);

    List<Parent> findAllParent2();

    Long getParentToTal();
}
