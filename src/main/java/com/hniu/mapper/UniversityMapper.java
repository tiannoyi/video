package com.hniu.mapper;

import com.hniu.entity.University;
import com.hniu.entity.UniversityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UniversityMapper {
    int countByExample(UniversityExample example);

    int deleteByExample(UniversityExample example);

    int deleteByPrimaryKey(Integer universityId);

    int insert(University record);

    int insertSelective(University record);

    List<University> selectByExample(UniversityExample example);

    University selectByPrimaryKey(Integer universityId);

    int updateByExampleSelective(@Param("record") University record, @Param("example") UniversityExample example);

    int updateByExample(@Param("record") University record, @Param("example") UniversityExample example);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);

    List<University> getFuzzyquery(@Param("name") String name);
}