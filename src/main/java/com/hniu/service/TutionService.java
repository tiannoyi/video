package com.hniu.service;

import com.hniu.entity.Tution;
import com.hniu.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutionService {
    //分页查询开课
    Page<Tution> selectTutionList(Integer currentPage, Integer pageSize);

    //查询单个开课
    Tution selectTution(Integer tution_id);

    //添加开课
    int insertTution(Tution tution);

    //修改开课
    int updateTution(Integer tution_id,Tution tution);

    //删除开课
    int deleteTution(Integer tution_id);


}
