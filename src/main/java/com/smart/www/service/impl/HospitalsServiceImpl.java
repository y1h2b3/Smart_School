package com.smart.www.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.HospitalsMapper;
import com.smart.www.pojo.Hospitals;
import com.smart.www.pojo.query.PageQuery;
import com.smart.www.service.HospitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【hospitals】的数据库操作Service实现
 * @createDate 2024-03-16 15:14:40
 */
@Service
public class HospitalsServiceImpl extends ServiceImpl<HospitalsMapper, Hospitals>
        implements HospitalsService {

    @Autowired
    private HospitalsService hospitalsService;

    @Autowired
    private HospitalsMapper hospitalsMapper;

    @Override
    public Page<Hospitals> findAllHospitals(PageQuery pageQuery) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Hospitals> HospitalsList = hospitalsMapper.findAllHospitals(size, offset, orders, isAsc);
        Page<Hospitals> HospitalsPage = new Page<>();
        HospitalsPage.setRecords(HospitalsList);
        int total = hospitalsMapper.countAllHospitals();
        HospitalsPage.setTotal(total);
        int pages = (int) Math.ceil((double) total / size);
        HospitalsPage.setPages(pages);
        return HospitalsPage;
    }

    @Override
    public boolean updateHospitals(Hospitals hospitals) {
        return hospitalsMapper.updateHospitals(hospitals) > 0;
    }

    @Override
    public Page<Hospitals> searchHospitals(PageQuery pageQuery, String key, String value) {
        int size = pageQuery.getSize();
        int offset = ((pageQuery.getCurrent() - 1) * size);
        String orders = pageQuery.getOrders();
        Boolean isAsc = pageQuery.getIsAsc();
        List<Hospitals> list = null;
        int total = 0;
        Page<Hospitals> drugsPage = new Page<>();
        if (key.isEmpty() || value.isEmpty()) {
            return hospitalsService.page(new Page<>(pageQuery.getCurrent(), pageQuery.getSize()));
        } else {
            switch (key) {
                case "name":
                    list = hospitalsMapper.searchByName(size, offset, value, orders, isAsc);
                    total = hospitalsMapper.countHospitalsByName(value);
                    break;
                case "grade":
                    list = hospitalsMapper.searchByGrade(size, offset, value, orders, isAsc);
                    total = hospitalsMapper.countHospitalsByGrade(value);
                    break;
                case "type":
                    list = hospitalsMapper.searchByType(size, offset, value, orders, isAsc);
                    total = hospitalsMapper.countHospitalsByType(value);
                    break;
            }
            drugsPage.setRecords(list);
            drugsPage.setTotal(total);
            return drugsPage;
        }
    }


}




