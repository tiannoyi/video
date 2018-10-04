package com.hniu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.hniu.constant.StateCode;
import com.hniu.entity.CourseType;
import com.hniu.service.CurriculumStatisticsService;
import com.hniu.util.State;

/*
 * 课程类别管理管理
 * author:邓志勇
 */

@RestController
public class CourseManagementController {

	@Autowired
	private CurriculumStatisticsService curriculumStatisticsService;

	public Base base=new Base();
	
	public StateCode StateCode;
	
	@PostMapping("/insertcurriculum")
	public  State<Object> insertcurriculum(@RequestBody CourseType courseType) {
		if(courseType == null) {
	    	return base.packaging(StateCode.FAIL, "参数不能为空",courseType);
	    }
		return curriculumStatisticsService.insertcurriculum(courseType);
	}
	
	@GetMapping("/getcurriculum")
	public State<Object> getcurriculum(Integer id) {
		if(id == null) {
	    	return base.packaging(StateCode.FAIL, "参数不能为空",id);
	    }
		return curriculumStatisticsService.getcurriculum(id);
	}
	
	@PutMapping("/updatecurriculum")
    public State<Object> updatecurriculum(@RequestBody CourseType courseType) {
		if(courseType == null) {
	    	return base.packaging(StateCode.FAIL, "参数不能为空",courseType);
	    }
		return curriculumStatisticsService.updatecurriculum(courseType);
	}
	
	@DeleteMapping("/deletecurriculum")
    public State<Object> deletecurriculum(Integer id) {
		if (id == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",id);
		}
		return curriculumStatisticsService.deletecurriculum(id);
	}
	
	
	@GetMapping("/getCurriculumAll")
	public State<Object> getCurriculumAll(Integer page, Integer rows){
		if (page == null || rows == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",page+rows);
		}
	    return curriculumStatisticsService.getCurriculumAll(page,rows);
	}
	
	@GetMapping("/getFuzzyqueryCoures")
	public State<Object> getFuzzyqueryCoures(String name){
		if (name == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",name);
		}
		return curriculumStatisticsService.getFuzzyqueryCoures(name);
	}
	
	
}
