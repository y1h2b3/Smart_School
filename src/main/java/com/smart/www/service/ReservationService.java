package com.smart.www.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.Reservation;
import com.smart.www.pojo.query.PageQuery;

/**
 * @author Administrator
 * @description 针对表【reservation】的数据库操作Service
 * @createDate 2024-03-16 15:14:40
 */
public interface ReservationService extends IService<Reservation> {

    Page<Reservation> searchReservationType(PageQuery pageQuery, String key, String value);

    Page<Reservation> findAllReservation(PageQuery pageQuery);

    boolean removeReservationByRid(String rid);

    boolean updateReservation(Reservation reservation1);
}
