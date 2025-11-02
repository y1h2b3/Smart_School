package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.Staff;
import com.smart.www.pojo.query.PageQuery;

/**
 * @author Administrator
 * @description 针对表【staff】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface StaffService extends IService<Staff> {

    Page<Staff> searchStaffType(PageQuery pageQuery, String id, String name, String isOnline,String location);

}
