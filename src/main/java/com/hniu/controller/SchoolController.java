package com.hniu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hniu.constant.StateCode;
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
	public  State<Object> insertSchool(@RequestBody University university) {
		 if(university == null) {
			 return base.packaging(StateCode.FAIL, "参数不能为空",university);
		 }
		return schoolService.insertSchool(university);
	}
	
	@GetMapping("/getSchool")
	public State<Object> getSchool(Integer id) {
		 if(id == null) {
			 return base.packaging(StateCode.FAIL, "参数不能为空",id);
		 }
		return schoolService.getSchool(id);
	}
	
	@PutMapping("/updateSchool")
	public State<Object> updateSchool(@RequestBody University university) {
		 if(university == null) {
			 return base.packaging(StateCode.FAIL, "参数不能为空",university);
		 }
		return schoolService.updateSchool(university);
	}
	
	@DeleteMapping("/deleteSchool")
	public State<Object> deleteSchool(Integer id) {
		if(id == null) {
	    	return  base.packaging(StateCode.FAIL, "参数不能为空",id);
	    }
		return schoolService.deleteSchool(id);
	}
	
	@GetMapping("/getSchoolAll")
	public State<Object> getSchoolAll(Integer page,Integer rows){
		if (page == null || rows == null) {
			return  base.packaging(StateCode.FAIL, "参数不能为空",page+rows);
		}
		return schoolService.getSchoolAll(page,rows);
	}

}
