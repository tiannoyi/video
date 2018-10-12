package com.hniu.mapper;

import com.hniu.dto.GiveDto;
import com.hniu.entity.Give;
import com.hniu.entity.GiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiveMapper {
    int countByExample(GiveExample example);

    int deleteByExample(GiveExample example);

    int deleteByPrimaryKey(Integer giveId);

    int insert(Give record);

    int insertSelective(Give record);

    List<Give> selectByExample(GiveExample example);

    Give selectByPrimaryKey(Integer giveId);

    int updateByExampleSelective(@Param("record") Give record, @Param("example") GiveExample example);

    int updateByExample(@Param("record") Give record, @Param("example") GiveExample example);

    int updateByPrimaryKeySelective(Give record);

    int updateByPrimaryKey(Give record);

    //根据课程id查询教师信息和授课信息
    List<GiveDto> giveAndTeacher(Integer curriculum_id);
}