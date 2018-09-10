package com.hniu.mapper;

import com.hniu.entity.AddCurriculum;
import com.hniu.entity.AddCurriculumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddCurriculumMapper {
    int countByExample(AddCurriculumExample example);

    int deleteByExample(AddCurriculumExample example);

    int deleteByPrimaryKey(Integer addId);

    int insert(AddCurriculum record);

    int insertSelective(AddCurriculum record);

    List<AddCurriculum> selectByExample(AddCurriculumExample example);

    AddCurriculum selectByPrimaryKey(Integer addId);

    int updateByExampleSelective(@Param("record") AddCurriculum record, @Param("example") AddCurriculumExample example);

    int updateByExample(@Param("record") AddCurriculum record, @Param("example") AddCurriculumExample example);

    int updateByPrimaryKeySelective(AddCurriculum record);

    int updateByPrimaryKey(AddCurriculum record);
}