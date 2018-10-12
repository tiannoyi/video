package com.hniu.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hniu.constan.StateCode;
import com.hniu.controller.Base;
import com.hniu.entity.User;
import com.hniu.entity.UserExample;
import com.hniu.entity.UserExample.Criteria;
import com.hniu.mapper.UserMapper;
import com.hniu.service.UserService;
import com.hniu.util.ChangliangUtil;
import com.hniu.util.State;

import javax.annotation.Resource;

/*
 * 用户管理Service
 * 邓志勇
 */
@Service
public class UserServieImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	
	public Base base=new Base();
	
	public StateCode StateCode;
	
	@Override
	public State<Object> getUser(Integer id) {
		User user = userMapper.selectByPrimaryKey(id);
		if (user !=null ) {
			System.out.println("user的信息是"+user.getUserName());
			System.out.println(user.toString());
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, user);
		}
		return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, user);
	}

	@Override
	public  State<Object> insertUser(User user) {
		int i=userMapper.insert(user);
		if (i == 1) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.INSERTSUCCESS, i);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.INSERTFAIL, i);
		}
	}

	@Override
	public State<Object> updateUser(User user) {
		int i = userMapper.updateByPrimaryKeySelective(user);
		if (i == 1) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.UPDATESUCCESS,i);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.UPDATEFAIL,i);
		}
	}

	@Override
	public State<Object> deleteUser(Integer id) {
		int i = userMapper.deleteByPrimaryKey(id);
		if (i == 1) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.DELETESUCCESS,i);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.DELETEFAIL,i);
		}
	}

	@Override
	public State<Object> getUserAll(Integer page,Integer rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		UserExample userExample=new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		List<User> selectByExample = userMapper.selectByExample(userExample);
		PageInfo info=new PageInfo(selectByExample);
		if (selectByExample != null && selectByExample.size() > 0) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS,info);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL,info);
		}
	}

	@Override
	public State<Object> getFuzzyquery(String name) {
		List<User> listUser = userMapper.getFuzzyquery(name);
		if (listUser.size() > 0 && listUser != null) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS,listUser);
		}
		return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL,listUser);
	}
	

}
