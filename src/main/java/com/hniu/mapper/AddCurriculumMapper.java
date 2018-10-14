package com.hniu.mapper;

import com.hniu.entity.AddCurriculum;
import com.hniu.entity.AddCurriculumExample;
import java.util.List;

import com.hniu.entity.vo.AddCurriculumVo;
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

    //查询所有开课信息
    List<AddCurriculumVo> AddCurriculumAll();

    //统计总数
    int count();

    //查询单个开课信息
    AddCurriculumVo selectAddCurriculum(Integer add_id);

    //根据开课id查询开课信息
    List<AddCurriculumVo> tutionId(Integer tution_id);

    //根据用户id查询开课信息
    List<AddCurriculumVo> userId(Integer user_id);

}