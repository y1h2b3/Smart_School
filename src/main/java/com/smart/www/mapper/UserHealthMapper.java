package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.UserHealth;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【user_health】的数据库操作Mapper
 * @createDate 2024-03-18 08:35:46
 * @Entity generator.domain.UserHealth
 */
@Mapper
public interface UserHealthMapper extends BaseMapper<UserHealth> {
    List<UserHealth> findStudentUserHealth(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    List<UserHealth> findTeacherUserHealth(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    List<UserHealth> findLogisticsUserHealth(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) from user_health left join student on user_health.user_id = student.student_id where student.student_id = user_health.user_id")
    int countStudentUserHealth();

    @Select("select count(*) from user_health left join teacher on user_health.user_id = teacher.teacher_id where teacher.teacher_id = user_health.user_id")
    int countTeacherUserHealth();

    @Select("select count(*) from user_health left join logistics on user_health.user_id = logistics.logistics_id where logistics.logistics_id = user_health.user_id")
    int countLogisticsUserHealth();


    int countStudentUserHealthType(@Param("id") String id, @Param("name") String name);

    List<UserHealth> searchStudentUserHealthType1(@Param("size") int size,
                                                  @Param("offset") int offset,
                                                  @Param("orders") String orders,
                                                  @Param("isAsc") Boolean isAsc,
                                                  @Param("id") String id,
                                                  @Param("name") String name);

    List<UserHealth> searchTeacherUserHealthType1(@Param("size") int size,
                                                  @Param("offset") int offset,
                                                  @Param("orders") String orders,
                                                  @Param("isAsc") Boolean isAsc,
                                                  @Param("id") String id,
                                                  @Param("name") String name);

    int countTeacherUserHealthType(@Param("id") String id, @Param("name") String name);

    List<UserHealth> searchLogisticsUserHealthType1(@Param("size") int size,
                                                    @Param("offset") int offset,
                                                    @Param("orders") String orders,
                                                    @Param("isAsc") Boolean isAsc,
                                                    @Param("id") String id,
                                                    @Param("name") String name);

    int countLogisticsUserHealthType(@Param("id") String id, @Param("name") String name);

    @Delete("delete from user_health where user_id = #{uid}")
    int removeUserHealthByUid(String uid);

    @Select("select * from user_health where user_id = #{uid}")
    List<UserHealth> findId(String uid);

    @Update("update user_health set check_warning = #{s} where user_id = #{userId}")
    void updateCheck(String userId, String s);

    List<UserHealth> searchIdUserHealthType(String uid);

    UserHealth getUserHealthByTime(@Param("userId") String userId, @Param("time") String time);
}




