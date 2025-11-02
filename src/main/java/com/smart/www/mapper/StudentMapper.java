package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【student】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.Student
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> findAllStudent(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) from student")
    int countAllDrugs();

    List<Student> searchByName(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from student where name like concat('%',#{value},'%')")
    int countStudentByName(String value);

    List<Student> searchByType(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from student where type like concat('%',#{value},'%')")
    int countStudentByType(String value);

    List<Student> searchByStudentId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from student where student_id like concat('%',#{value},'%')")
    int countStudentByStudentId(String value);

    List<Student> searchByClazz(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from student where clazz like concat('%',#{value},'%')")
    int countStudentByClazz(String value);

    int removeStudentBySid(@Param("sid") String sid);

    int updateStudentById(Student student);

    List<Student> searchByStatus(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from student where status like concat('%',#{value},'%')")
    int countStudentByStatus(String value);

    List<Student> searchStudent(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("clazz") String clazz, @Param("id") String id, @Param("name") String name,@Param("phone") String phone);

    int countStudent(@Param("clazz") String clazz, @Param("id") String id, @Param("name") String name,@Param("phone") String phone);

    List<Student> findAllStudent2();

    @Select("select DISTINCT clazz from student")
    List<Student> findClszz();

    @Select("select DISTINCT grade from student")
    List<Student> findGrader();

    @Select("select count(*) from student")
    Long getStudentTotal();
}




