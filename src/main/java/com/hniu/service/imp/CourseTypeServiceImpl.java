package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.CourseType;
import com.hniu.entity.CourseTypeExample;
import com.hniu.mapper.CourseTypeMapper;
import com.hniu.service.CourseTypeService;
import com.hniu.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/10/9 11:31
 * @Description:
 * @Modified By:
 */
@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    @Resource
    CourseTypeMapper courseTypeMapper;


    @Override
    public Page<CourseType> selectCourseTypeAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        CourseTypeExample example = new CourseTypeExample();
        example.setOrderByClause("ct_id desc");
        List<CourseType> allCourseType = courseTypeMapper.selectByExample(example);
        int countNums = courseTypeMapper.countByExample(example);
        Page<CourseType> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCourseType);
        return pageData;
    }
}
