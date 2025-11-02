package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.DrugsMapper;
import com.smart.www.pojo.Drugs;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.DrugsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【drugs】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
@AllArgsConstructor
public class DrugsServiceImpl extends ServiceImpl<DrugsMapper, Drugs>
        implements DrugsService {

    private DrugsMapper drugsMapper;

    @Override
    public Page<Drugs> searchDrugs(PageQuery pageQuery, String id, String name, String type, String startTime, String endTime) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Drugs> list = null;
        int total = 0;
        Page<Drugs> drugsPage = new Page<>();
//        if (key.isEmpty() || value.isEmpty()) {
//            list = drugsMapper.findAllDrugs(size, offset, orders, isAsc);
//            total = drugsMapper.countAllDrugs();
//            drugsPage.setRecords(list);
//            drugsPage.setTotal(total);
//            int pages = (int) Math.ceil((double) total / size);
//            drugsPage.setPages(pages);
//            return drugsPage;
//        } else {
//            switch (key) {
//                case "name":
//                    //模糊查询name的value值
//                    list = drugsMapper.searchByName(size, offset, value, orders, isAsc);
//                    total = drugsMapper.countDrugsByName(value);
//                    break;
//                case "type":
//                    list = drugsMapper.searchByType(size, offset, value, orders, isAsc);
//                    total = drugsMapper.countDrugsByType(value);
//                    break;
//            }
//        }
        list = drugsMapper.searchDrugs(size, offset, orders, isAsc, id, name, type, startTime, endTime);
        total = drugsMapper.countDrugs(id, name, type, startTime, endTime);
        drugsPage.setRecords(list);
        drugsPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        drugsPage.setPages(pages);
        return drugsPage;
    }

    @Override
    public boolean removeDrugsByDid(String did) {
        int result = drugsMapper.deleteByDrugId(did);
        return result > 0;
    }

    @Override
    public boolean updateBydrugId(Drugs drugs) {
        int result = drugsMapper.updateByDrugId(drugs);
        return result > 0;
    }

    @Override
    public boolean saveDrugs(Drugs drugs) {
        int result = drugsMapper.insertDrugs(drugs);
        return result > 0;
    }

    @Override
    public Page<Drugs> findAllDrugs(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Drugs> drugsList = drugsMapper.findAllDrugs(size, offset, orders, isAsc);
        Page<Drugs> drugsPage = new Page<>();
        drugsPage.setRecords(drugsList);
        int total = drugsMapper.countAllDrugs();
        drugsPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        drugsPage.setPages(pages);
        return drugsPage;
    }

    @Override
    public List<Drugs> searchIdDrugs(String id) {
        return drugsMapper.searchIdDrugs(id);
    }

    @Override
    public List<Drugs> getTypeID(String name) {
        return drugsMapper.getTypeID(name);
    }
}




