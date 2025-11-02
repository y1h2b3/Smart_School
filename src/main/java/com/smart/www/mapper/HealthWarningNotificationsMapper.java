package com.smart.www.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.HealthWarningNotifications;
import com.smart.www.pojo.Vo.LogisticsHealthWarningNotificationsVo;
import com.smart.www.pojo.Vo.StudentHealthWarningNotificationsVo;
import com.smart.www.pojo.Vo.TeacherHealthWarningNotificationsVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【health_warning_notifications】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.HealthWarningNotifications
 */
@Mapper
public interface HealthWarningNotificationsMapper extends BaseMapper<HealthWarningNotifications> {

    List<StudentHealthWarningNotificationsVo> findAllHealthWarningNotifications();

    @Select("select count(*) FROM health_warning_notifications h LEFT JOIN student st ON h.user_id = st.student_id where h.user_id = st.student_id ")
    int countAllhealthWarningNotifications();

    List<StudentHealthWarningNotificationsVo> findAllHealthWarningNotifications(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    List<StudentHealthWarningNotificationsVo> searchByUserName(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN student st ON h.user_id = st.student_id where st.name like concat('%',#{value},'%') and h.user_id = st.student_id")
    int countDrugsByName(String value);

    List<StudentHealthWarningNotificationsVo> searchByUserType(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN student st ON h.user_id = st.student_id where h.type like concat('%',#{value},'%') and h.user_id = st.student_id")
    int countDrugsByType(String value);


    List<StudentHealthWarningNotificationsVo> searchBylevel(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN student st ON h.user_id = st.student_id where h.level like concat('%',#{value},'%') and h.user_id = st.student_id")
    int countDrugsBylevel(String value);

    List<StudentHealthWarningNotificationsVo> findAllStudentHealthWarningNotifications(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    List<TeacherHealthWarningNotificationsVo> findAllTeacherHealthWarningNotifications(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    List<TeacherHealthWarningNotificationsVo> searchTeacherByUserName(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN teacher t ON h.user_id = t.teacher_id where t.name like concat('%',#{value},'%') and h.user_id = t.teacher_id")
    int countTeachByName(String value);

    List<TeacherHealthWarningNotificationsVo> searchTeachByUserType(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN teacher t ON h.user_id = t.teacher_id where h.type like concat('%',#{value},'%') and h.user_id = t.teacher_id")
    int countTeachByType(String value);

    List<TeacherHealthWarningNotificationsVo> searchTeachBylevel(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN teacher t ON h.user_id = t.teacher_id where h.level like concat('%',#{value},'%') and h.user_id = t.teacher_id")
    int countTeachBylevel(String value);

    List<TeacherHealthWarningNotificationsVo> searchTeachByPost(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN teacher t ON h.user_id = t.teacher_id where t.post like concat('%',#{value},'%') and h.user_id = t.teacher_id")
    int countTeachByPost(String value);

    @Select("select count(*) FROM health_warning_notifications h LEFT JOIN teacher t ON h.user_id = t.teacher_id where h.user_id = t.teacher_id ")
    int countAllTeacherhealthWarningNotifications();

    List<LogisticsHealthWarningNotificationsVo> findAllLogisticsHealthWarningNotifications(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) FROM health_warning_notifications h LEFT JOIN logistics l ON h.user_id = l.logistics_id where h.user_id = l.logistics_id ")
    int countAllLogisticshealthWarningNotifications();

    List<LogisticsHealthWarningNotificationsVo> searchLogisticsByUserName(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN logistics l ON h.user_id = l.logistics_id where l.name like concat('%',#{value},'%') and h.user_id = l.logistics_id")
    int countLogisticsByName(String value);

    List<LogisticsHealthWarningNotificationsVo> searchLogisticsByUserType(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN logistics l ON h.user_id = l.logistics_id where h.type like concat('%',#{value},'%') and h.user_id = l.logistics_id")
    int countLogisticsByType(String value);

    List<LogisticsHealthWarningNotificationsVo> searchLogisticsBylevel(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN logistics l ON h.user_id = l.logistics_id where h.level like concat('%',#{value},'%') and h.user_id = l.logistics_id")
    int countLogisticsBylevel(String value);

    List<LogisticsHealthWarningNotificationsVo> searchLogisticsByPost(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc, @Param("value") String value);

    @Select("select count(*) from health_warning_notifications h LEFT JOIN logistics l ON h.user_id = l.logistics_id where l.post like concat('%',#{value},'%') and h.user_id = l.logistics_id")
    int countLogisticsByPost(String value);

    List<StudentHealthWarningNotificationsVo> findAllStudentHealthWarningNotifications2();

    List<TeacherHealthWarningNotificationsVo> findAllTeacherHealthWarningNotifications2();

    List<LogisticsHealthWarningNotificationsVo> findAllLogisticsHealthWarningNotifications2();

    List<StudentHealthWarningNotificationsVo> searchStudentHealthWarningNotifications(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc,
                                                                                      @Param("id") String id, @Param("type") String type, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<TeacherHealthWarningNotificationsVo> searchTeacherHealthWarningNotifications(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc,
                                                                                      @Param("id") String id, @Param("type") String type, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<LogisticsHealthWarningNotificationsVo> searchLogisticsHealthWarningNotifications(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc,
                                                                                          @Param("id") String id, @Param("type") String type, @Param("startTime") String startTime, @Param("endTime") String endTime);

    int countStudentHealthWarningNotifications(@Param("id") String id, @Param("type") String type, @Param("startTime") String startTime, @Param("endTime") String endTime);

    int countTeacherHealthWarningNotifications(@Param("id") String id, @Param("type") String type, @Param("startTime") String startTime, @Param("endTime") String endTime);

    int countLogisticsHealthWarningNotifications(@Param("id") String id, @Param("type") String type, @Param("startTime") String startTime, @Param("endTime") String endTime);

    int countTeacherAllhealthWarningNotifications();

    @Delete("delete from health_warning_notifications where user_id = #{hid}")
    boolean removeHealthWarningNotificationsByHid(String hid);

    List<HealthWarningNotifications> findAllStudentHealthWarningNotificationsById(String hid);
}




