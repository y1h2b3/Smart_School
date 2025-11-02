package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【teacher】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.Teacher
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    List<Teacher> findAllTeacher(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) from teacher")
    int countAllTeacher();

    List<Teacher> searchByName(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    List<Teacher> searchByType(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from teacher where post like concat('%',#{value},'%')")
    int countTeacherByType(String value);

    @Select("select count(*) from teacher where name like concat('%',#{value},'%')")
    int countTeacherByName(String value);

    List<Teacher> searchByTeacherId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from teacher where teacher_id like concat('%',#{value},'%')")
    int countTeacherByTeacherId(String value);

    List<Teacher> searchBysex(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from teacher where sex like concat('%',#{value},'%')")
    int countTeacherBysex(String value);

    int removeTeacherByTid(String tid);

    int updateTeacher(Teacher teacher);


    List<Teacher> searchByStatus(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from teacher where status like concat('%',#{value},'%')")
    int countTeacherByStatus(String value);

    List<Teacher> searchTeacher(@Param("size") int size,
                                @Param("offset") int offset,
                                @Param("orders") String orders,
                                @Param("isAsc") Boolean isAsc,
                                @Param("post") String post,
                                @Param("id") String id,
                                @Param("name") String name, String phone);

    int countTeacher(@Param("post") String post, @Param("id") String id, @Param("name") String name, String phone);

    List<Teacher> findAllTeacher2();

    @Select("select count(*) from teacher")
    Long getTeacherToTal();
}




