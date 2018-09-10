package com.hniu.mapper;

import com.hniu.entity.Curriculum;
import com.hniu.entity.CurriculumExample;
import com.hniu.entity.CurriculumWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurriculumMapper {
    int countByExample(CurriculumExample example);

    int deleteByExample(CurriculumExample example);

    int deleteByPrimaryKey(Integer curriculumId);

    int insert(CurriculumWithBLOBs record);

    int insertSelective(CurriculumWithBLOBs record);

    List<CurriculumWithBLOBs> selectByExampleWithBLOBs(CurriculumExample example);

    List<Curriculum> selectByExample(CurriculumExample example);

    CurriculumWithBLOBs selectByPrimaryKey(Integer curriculumId);

    int updateByExampleSelective(@Param("record") CurriculumWithBLOBs record, @Param("example") CurriculumExample example);

    int updateByExampleWithBLOBs(@Param("record") CurriculumWithBLOBs record, @Param("example") CurriculumExample example);

    int updateByExample(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    int updateByPrimaryKeySelective(CurriculumWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CurriculumWithBLOBs record);

    int updateByPrimaryKey(Curriculum record);
}