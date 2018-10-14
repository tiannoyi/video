package com.hniu.service;

import com.hniu.entity.AddCurriculum;
import com.hniu.entity.vo.AddCurriculumVo;
import com.hniu.util.Page;
import org.apache.commons.math3.analysis.function.Add;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/10/14 10:59
 * @Description:
 * @Modified By:
 */
@Repository
public interface AddCurriculumService {
    //分页查询开课信息
    Page<AddCurriculumVo> AddCurriculumPage(Integer currentPage, Integer pageSize);

    //查询单个开课信息
    AddCurriculumVo selectAddCurriculum(Integer add_id);

    //根据开课id查询开课信息
    Page<AddCurriculumVo> tutionId(Integer tution_id,Integer currentPage, Integer pageSize);

    //根据用户id查询开课信息
    Page<AddCurriculumVo> userId(Integer user_id,Integer currentPage, Integer pageSize);

    //加入课程
    int insertAddCurriculum(AddCurriculum addCurriculum);


    //修改加入课程
    int updateAddCurriculum(AddCurriculum addCurriculum);

    //删除加入课程
    int deleteAddCurriculum(Integer add_id);

}
