package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.Parent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【parent】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.Parent
 */
@Mapper
public interface ParentMapper extends BaseMapper<Parent> {


    List<Parent> findAllparent(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);


    int countAllParent();

    List<Parent> searchByName(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from parent where name like CONCAT('%',#{value},'%')")
    int countparentByName(String value);

    List<Parent> searchByparentId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from parent where parent_id like CONCAT('%',#{value},'%')")
    int countparentByparentId(String value);

    List<Parent> searchBystudentId(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from parent where student_id like CONCAT('%',#{value},'%')")
    int countparentBystudentId(String value);

    List<Parent> searchBySex(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from parent where sex like CONCAT('%',#{value},'%')")
    int countparentBySex(String value);

    int removeParentByPid(String pid);

    @Select("select name from parent where parent_id = #{id}")
    List<String> searchParentID(@Param("id") String id);

    List<Parent> findAllParent2();

    List<Parent> searchParentType(
            @Param("size") int size,
            @Param("offset") int offset,
            @Param("orders") String orders,
            @Param("isAsc") Boolean isAsc,
            @Param("clazz") String clazz,
            @Param("PName") String PName,
            @Param("SName") String SName,
            @Param("Sid") String Sid,
            String phone
    );

    int countParentType(@Param("clazz") String clazz, @Param("PName") String PName, @Param("SName") String SName, @Param("Sid") String Sid, String phone);

    @Select("select count(*) from parent")
    Long getParentToTal();
}




