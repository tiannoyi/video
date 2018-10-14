package com.hniu.mapper;

import com.hniu.entity.Performance;
import com.hniu.entity.PerformanceExample;

import java.util.HashMap;
import java.util.List;

import com.hniu.entity.vo.PerformanceVo;
import org.apache.ibatis.annotations.Param;

public interface PerformanceMapper {
    int countByExample(PerformanceExample example);

    int deleteByExample(PerformanceExample example);

    int deleteByPrimaryKey(Integer performanceId);

    int insert(Performance record);

    int insertSelective(Performance record);

    List<Performance> selectByExample(PerformanceExample example);

    Performance selectByPrimaryKey(Integer performanceId);

    int updateByExampleSelective(@Param("record") Performance record, @Param("example") PerformanceExample example);

    int updateByExample(@Param("record") Performance record, @Param("example") PerformanceExample example);

    int updateByPrimaryKeySelective(Performance record);

    int updateByPrimaryKey(Performance record);

    //查询所有成绩
    List<PerformanceVo> PerformanceAll();

    //统计总数
    int count();

    //根据id查询成绩
    PerformanceVo selectPerformance(Integer performance_id);

    //根据用户id查询成绩
    List<PerformanceVo> userId(Integer user_id);

    //
    List<PerformanceVo> userIdAndKnowledgeId (HashMap map);
}