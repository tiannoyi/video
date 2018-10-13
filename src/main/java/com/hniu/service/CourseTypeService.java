package com.hniu.service;

import com.hniu.dto.CourseTypeDto;
import com.hniu.entity.CourseType;
import com.hniu.util.Page;

/**
 * @Author: 熊俊
 * @Date: 2018/10/9 11:31
 * @Description:
 * @Modified By:
 */
public interface CourseTypeService {
    //分页查询所有课程类别信息
    Page<CourseType> selectCourseTypeAll(Integer currentPage, Integer pageSize);

    int insertCourseType(CourseTypeDto courseTypeDto);

    int updateCourseType(CourseTypeDto courseTypeDto);

    int deleceCourseType(Integer ct_id);
}
