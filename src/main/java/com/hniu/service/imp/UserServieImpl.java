package com.hniu.service.imp;


import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.List;

import com.hniu.dto.UserDto;
import com.hniu.entity.*;
import com.hniu.mapper.AddCurriculumMapper;
import com.hniu.mapper.CommentMapper;
import com.hniu.mapper.PerformanceMapper;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hniu.constan.StateCode;
import com.hniu.controller.Base;
import com.hniu.entity.UserExample.Criteria;
import com.hniu.mapper.UserMapper;
import com.hniu.service.UserService;
import com.hniu.util.ChangliangUtil;
import com.hniu.util.State;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/*
 * 用户管理Service
 * 邓志勇
 */
@Service
public class UserServieImpl implements UserService{

	@Resource
	private UserMapper userMapper;

	@Resource
	AddCurriculumMapper addCurriculumMapper;
	@Resource
	CommentMapper commentMapper;
	@Resource
	PerformanceMapper performanceMapper;
	
	public Base base=new Base();
	
	public StateCode StateCode;

	@Value("${web.userPortrait}")
	private String userPortrait;

	@Value("${web.videoPath}")
	private String portraitPath;
	
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
	public  int insertUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto,user);
		if(userDto.getPortrait()!=null&&userDto.getPortrait().getSize()>0) {
			String fileName = System.currentTimeMillis() + "_" + userDto.getPortrait().getOriginalFilename();
			File file = new File(userPortrait + fileName);
			File fileFolder = new File(userPortrait);
			if (!fileFolder.exists()) {
				fileFolder.mkdirs();
			}
			try{
				userDto.getPortrait().transferTo(file);
				user.setPortrait(portraitPath+fileName);
				user.setPassword(null);
				user.setWechat(null);
				return userMapper.insertSelective(user);
			}catch(IOException e){
				e.printStackTrace();
				return 0;
			}

		}
		if(userDto.getPortrait()==null){
			user.setWechat(null);
			user.setPassword(null);
			return userMapper.insertSelective(user) ;
		}
		return 0;
}

	@Override
	public int updateUser(UserDto userDto) {
		String endString = null;
		User u = userMapper.selectByPrimaryKey(userDto.getUserId());
		if(!StringUtils.isEmpty(u)) {
			String s = u.getPortrait();
			if(s.contains(".gif")){
				endString = ".gif";
			}else if(s.contains(".png")){
				endString = ".png";
			}else if(s.contains(".jpg")){
				endString = ".jpg";
			}
			String s1 = s.substring(s.indexOf("video/") + 6, s.indexOf(endString));
			File file = new File(userPortrait+s1+endString);
			file.delete();
		}
		User user = new User();
		BeanUtils.copyProperties(userDto,user);
		if(userDto.getPortrait()!=null&&userDto.getPortrait().getSize()>0){
			String fileName = System.currentTimeMillis()+"_"+userDto.getPortrait().getOriginalFilename();
			File file = new File(userPortrait+fileName);
			File fileFolder = new File(userPortrait);
			if(!fileFolder.exists()){
				fileFolder.mkdirs();
			}
			try {
				userDto.getPortrait().transferTo(file);
				user.setPortrait(portraitPath+fileName);
				user.setWechat(null);
				user.setPassword(null);
				return userMapper.updateByPrimaryKeySelective(user);
			} catch (IOException e) {
				e.printStackTrace();
				return 0;
			}
		}
		if(userDto.getPortrait()==null){
			user.setWechat(null);
			user.setPassword(null);
			return userMapper.updateByPrimaryKeySelective(user);
		}
		return 0;
	}

	@Override
	public int deleteUser(Integer user_id) {
		PerformanceExample performanceExample = new PerformanceExample();
		performanceExample.createCriteria().andUserIdEqualTo(user_id);
		List<Performance> list = performanceMapper.selectByExample(performanceExample);


		CommentExample commentExample = new CommentExample();
		commentExample.createCriteria().andUserIdEqualTo(user_id);
		List<Comment> list1 = commentMapper.selectByExample(commentExample);

		AddCurriculumExample addCurriculumExample = new AddCurriculumExample();
		addCurriculumExample.createCriteria().andUserIdEqualTo(user_id);
		List<AddCurriculum> list2 = addCurriculumMapper.selectByExample(addCurriculumExample);

		if(list.size()>0||list1.size()>0||list2.size()>0){
			return 0;
		}

		String endString = null;
		User u = userMapper.selectByPrimaryKey(user_id);
		if(!StringUtils.isEmpty(u)) {
			String s = u.getPortrait();
			if(s.contains(".gif")){
				endString = ".gif";
			}else if(s.contains(".png")){
				endString = ".png";
			}else if(s.contains(".jpg")){
				endString = ".jpg";
			}
			String s1 = s.substring(s.indexOf("video/") + 6, s.indexOf(endString));
			File file = new File(userPortrait+s1+endString);
			file.delete();
		}
		int i = userMapper.deleteByPrimaryKey(user_id);
		if(i>0){
			return 1;
		}
		return 0;
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

	@Override
	public User insertUser(User user) {
		userMapper.insertUser(user);
		return user;
	}


}
