package com.smart.www.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.UserHealth;

public interface HealthCheckService extends IService<UserHealth> {
    void healthCheck();

    boolean UpdatehealthCheck();
}
