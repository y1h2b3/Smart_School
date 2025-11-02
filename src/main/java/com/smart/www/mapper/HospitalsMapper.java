package com.smart.www.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.www.pojo.Hospitals;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【hospitals】的数据库操作Mapper
 * @createDate 2024-03-16 15:14:40
 * @Entity generator.domain.Hospitals
 */
@Mapper
public interface HospitalsMapper extends BaseMapper<Hospitals> {

    List<Hospitals> searchByName(@Param("size") int size, @Param("offset") int offset, @Param("value") String value, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) from hospitals where name like '%${value}%'")
    int countHospitalsByName(String value);

    List<Hospitals> searchByGrade(@Param("size") int size, @Param("offset") int offset, @Param("value") String value, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) from hospitals where grade like '%${value}%'")
    int countHospitalsByGrade(String value);

    List<Hospitals> searchByType(@Param("size") int size, @Param("offset") int offset, @Param("value") String value, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) from hospitals where type like '%${value}%'")
    int countHospitalsByType(String value);

    List<Hospitals> findAllHospitals(@Param("size") int size, @Param("offset") int offset, @Param("orders") String orders, @Param("isAsc") Boolean isAsc);

    @Select("select count(*) from hospitals")
    int countAllHospitals();

    int updateHospitals(Hospitals hospitals);
}




