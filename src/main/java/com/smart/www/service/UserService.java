package com.smart.www.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.www.pojo.User;
import com.smart.www.pojo.Vo.UserNameVo;
import com.smart.www.util.Result;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【user】的数据库操作Service
 * @createDate 2024-03-19 15:23:43
 */
public interface UserService extends IService<User> {

    List<UserNameVo> findUser(String name);
}
