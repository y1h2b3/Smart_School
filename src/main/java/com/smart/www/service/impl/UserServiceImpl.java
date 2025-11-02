package com.smart.www.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.www.mapper.UserMapper;
import com.smart.www.pojo.User;
import com.smart.www.pojo.Vo.UserNameVo;
import com.smart.www.service.UserService;
import com.smart.www.util.JwtHelper;
import com.smart.www.util.Result;
import com.smart.www.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-03-19 15:23:43
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public List<UserNameVo> findUser(String name) {
        return userMapper.findUser(name);
    }

}




