package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.User;
import com.smart.www.pojo.Vo.UserNameVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2024-03-19 15:23:43
 * @Entity generator.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("        SELECT p.type, p.phone, p.password\n" +
            "        FROM parent p\n" +
            "        WHERE p.phone = #{name}\n" +
            "        UNION\n" +
            "        SELECT l.type, l.phone, l.password\n" +
            "        FROM logistics l\n" +
            "        WHERE l.phone = #{name}\n" +
            "        UNION\n" +
            "        SELECT t.type, t.phone, t.password\n" +
            "        FROM teacher t\n" +
            "        WHERE t.phone = #{name}")
    List<UserNameVo> findUser(@Param("name") String name);
}




