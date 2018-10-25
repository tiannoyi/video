package com.hniu.controller;

import com.hniu.constan.StateCode;
import com.hniu.dto.CourseTypeDto;
import com.hniu.entity.CourseType;
import com.hniu.service.CourseTypeService;
import com.hniu.util.Page;
import com.hniu.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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



    //添加课程类别
    @RequestMapping()
    public State<Object> insertCourseType(CourseTypeDto courseType){
        if (StringUtils.isEmpty(courseType)){
            return packaging(StateCode.FAIL,"课程类别添加失败",null);
        }
        int i = courseTypeService.insertCourseType(courseType);
        if(i>0){
            return packaging(StateCode.SUCCESS,"课程类别添加成功",null);
        }
        return packaging(StateCode.FAIL,"课程类别添加失败",null);
    }


    //修改课程类别
    @RequestMapping(value = "/update/{ct_id}")
    public State<Object> updateCourseType(@PathVariable("ct_id")Integer ct_id,CourseTypeDto courseTypeDto){
        if(StringUtils.isEmpty(courseTypeDto)){
            return packaging(StateCode.FAIL,"课程类别修改失败",null);
        }
        courseTypeDto.setCtId(ct_id);
        int i = courseTypeService.updateCourseType(courseTypeDto);
        if(i>0){
            return packaging(StateCode.SUCCESS,"课程类别修改成功",null);
        }
        return packaging(StateCode.FAIL,"课程类别修改失败",null);
    }

    //删除课程类别
    @DeleteMapping("/{ct_id}")
    public State<Object> deleceCourseType(@PathVariable("ct_id")Integer ct_id){
        int i = courseTypeService.deleceCourseType(ct_id);
        if(i>0){
            return packaging(StateCode.SUCCESS,"课程类别删除成功",null);
        }
        return packaging(StateCode.FAIL,"课程类别删除失败",null);
    }





}
