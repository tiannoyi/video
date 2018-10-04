package com.hniu.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hniu.constant.StateCode;
import com.hniu.controller.Base;
import com.hniu.entity.CourseType;
import com.hniu.entity.University;
import com.hniu.entity.UniversityExample;
import com.hniu.entity.User;
import com.hniu.mapper.CourseTypeMapper;
import com.hniu.mapper.UniversityMapper;
import com.hniu.service.SchoolService;
import com.hniu.util.ChangliangUtil;

import com.hniu.util.State;

/*
 * 学校管理Service
 * 邓志勇
 */

@Service
public class SchoolServiceImpl implements SchoolService{

	
	@Autowired
	private UniversityMapper universityMapper;
	
	public Base base=new Base();
	
	
	public StateCode StateCode;
	
	@Override
	public State<Object> insertSchool(University university) {
		int insert = universityMapper.insert(university);
		if (insert == 1) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.INSERTSUCCESS, insert);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.INSERTFAIL, insert);
		}
	}
	
	@Override
	public State<Object> getSchool(Integer id) {
		University selectByPrimaryKey = universityMapper.selectByPrimaryKey(id);
		if (selectByPrimaryKey != null) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, selectByPrimaryKey);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, selectByPrimaryKey);
		}
	}

	
	@Override
	public State<Object> updateSchool(University university) {
		int updateByPrimaryKey = universityMapper.updateByPrimaryKey(university);
		if (updateByPrimaryKey == 1) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.UPDATESUCCESS, updateByPrimaryKey);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.UPDATEFAIL, updateByPrimaryKey);
		}
	}

	@Override 
	public  State<Object> deleteSchool(Integer id) {
		int deleteByPrimaryKey = universityMapper.deleteByPrimaryKey(id);
		if (deleteByPrimaryKey == 1) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.DELETESUCCESS, deleteByPrimaryKey);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.DELETEFAIL, deleteByPrimaryKey);
		}
	}

	@Override
	public State<Object> getSchoolAll(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		UniversityExample UniversityExample=new UniversityExample();
		List<University> listUniversity = universityMapper.selectByExample(UniversityExample);
		PageInfo info=new PageInfo<>(listUniversity);
		if (listUniversity != null && listUniversity.size() > 0) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, info);
		}else {
		    return base.packaging(StateCode.FAIL, ChangliangUtil.DELETEFAIL, info);
		}
	}

	@Override
	public State<Object> getFuzzyquery(String name) {
		List<University> listUser = universityMapper.getFuzzyquery(name);
		if (listUser.size() > 0 && listUser != null) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS,listUser);
		}
		return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL,listUser);
	}
		

}
