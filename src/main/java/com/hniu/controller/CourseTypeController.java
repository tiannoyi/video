package com.hniu.controller;

import com.hniu.constant.StateCode;
import com.hniu.entity.CourseType;
import com.hniu.service.CourseTypeService;
import com.hniu.util.Page;
import com.hniu.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 熊俊
 * @Date: 2018/10/9 11:29
 * @Description:
 * @Modified By:
 */
@RestController
@RequestMapping("/courseType")
public class CourseTypeController extends Base{
    @Autowired
    CourseTypeService courseTypeService;

    //查询所有课程类别
    @GetMapping("/CourseTypePage")
    public State<Object> selectCourseTypeAll(Integer currentPage, Integer pageSize){
        if(currentPage==null || pageSize == null){
            return packaging(StateCode.FAIL,"请输入页数和大小",null);
        }
        Page<CourseType> list = courseTypeService.selectCourseTypeAll(currentPage,pageSize);
        if(list.getList().size()>0){
            return packaging(StateCode.SUCCESS,"课程类别查询成功",list);
        }else{
            return packaging(StateCode.FAIL,"课程类别查询失败",null);
        }

    }

}
