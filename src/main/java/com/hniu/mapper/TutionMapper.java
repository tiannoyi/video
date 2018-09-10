package com.hniu.mapper;

import com.hniu.entity.Tution;
import com.hniu.entity.TutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TutionMapper {
    int countByExample(TutionExample example);

    int deleteByExample(TutionExample example);

    int deleteByPrimaryKey(Integer tutionId);

    int insert(Tution record);

    int insertSelective(Tution record);

    List<Tution> selectByExample(TutionExample example);

    Tution selectByPrimaryKey(Integer tutionId);

    int updateByExampleSelective(@Param("record") Tution record, @Param("example") TutionExample example);

    int updateByExample(@Param("record") Tution record, @Param("example") TutionExample example);

    int updateByPrimaryKeySelective(Tution record);

    int updateByPrimaryKey(Tution record);
}