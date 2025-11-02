package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.ParentMapper;
import com.smart.www.pojo.Parent;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【parent】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
public class ParentServiceImpl extends ServiceImpl<ParentMapper, Parent>
        implements ParentService {

    @Autowired
    private ParentMapper parentMapper;
    @Autowired
    private ParentService parentService;

    @Override
    public Page<Parent> searchParentType(PageQuery pageQuery, String clazz, String PName, String SName, String Sid, String phone) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Parent> list = null;
        int total = 0;
        Page<Parent> parentPage = new Page<>();
        list = parentMapper.searchParentType(size, offset, orders, isAsc, clazz, PName, SName, Sid,phone);
        total = parentMapper.countParentType(clazz, PName, SName, Sid,phone);
        parentPage.setRecords(list);
        parentPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        parentPage.setPages(pages);
        return parentPage;
    }

    @Override
    public Page<Parent> findAllParent(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Parent> parentList = parentMapper.findAllparent(size, offset, orders, isAsc);
        Page<Parent> parentPage = new Page<>();
        parentPage.setRecords(parentList);
        int total = parentMapper.countAllParent();
        parentPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        parentPage.setPages(pages);
        return parentPage;
    }

    @Override
    public boolean removeParentByPid(String pid) {
        return parentMapper.removeParentByPid(pid) > 0;
    }

    @Override
    public String searchParentID(String id) {
        List<String> names = parentMapper.searchParentID(id);
        if (names != null && !names.isEmpty()) {
            return names.get(0); // 如果列表非空，返回第一个名字
        } else {
            // 处理找不到家长的情况，例如返回 null 或抛出异常
            return null;
        }
    }

    @Override
    public List<Parent> findAllParent2() {
        return parentMapper.findAllParent2();
    }

    @Override
    public Long getParentToTal() {
        return parentMapper.getParentToTal();
    }
}




