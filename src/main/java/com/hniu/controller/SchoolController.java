package com.hniu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hniu.constan.StateCode;
import com.hniu.entity.University;
import com.hniu.service.SchoolService;
import com.hniu.util.State;

/*
 * 学校管理
 * author:邓志勇
 */

@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	
	public Base base=new Base();
	
	public StateCode StateCode;
	
	//模糊查询
	@GetMapping("/getFuzzyquerySchool")
	public State<Object> getFuzzyquerySchool(String name){
		if (name == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",name);
		}
		return schoolService.getFuzzyquery(name);
	}
	
	@PostMapping("/insertSchool")
	public  State<Object> insertSchool(University university) {
		 if(university == null) {
			 return base.packaging(StateCode.FAIL, "参数不能为空",university);
		 }
		return schoolService.insertSchool(university);
	}
	
	@GetMapping("/getSchool/{university_id}")
	public State<Object> getSchool(@PathVariable("university_id") Integer university_id) {
		 if(university_id == null) {
			 return base.packaging(StateCode.FAIL, "参数不能为空",university_id);
		 }
		return schoolService.getSchool(university_id);
	}
	
	@PutMapping("/updateSchool")
	public State<Object> updateSchool(University university) {
		 if(university == null) {
			 return base.packaging(StateCode.FAIL, "参数不能为空",university);
		 }
		return schoolService.updateSchool(university);
	}
	
	@DeleteMapping("/deleteSchool/{university_id}")
	public State<Object> deleteSchool(@PathVariable("university_id") Integer university_id) {
		if(university_id == null) {
	    	return  base.packaging(StateCode.FAIL, "参数不能为空",university_id);
	    }
		return schoolService.deleteSchool(university_id);
	}
	
	@GetMapping("/getSchoolAll")
	public State<Object> getSchoolAll(Integer currentPage, Integer pageSize){
		if (currentPage == null || pageSize == null) {
			return  base.packaging(StateCode.FAIL, "参数不能为空",null);
		}
		return schoolService.getSchoolAll(currentPage,pageSize);
	}

}
