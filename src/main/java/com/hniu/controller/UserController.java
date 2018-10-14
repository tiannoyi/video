package com.hniu.controller;
/*
 * 用户管理
 */


import com.hniu.dto.UserDto;
import com.hniu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.hniu.constan.StateCode;
import com.hniu.entity.User;
import com.hniu.service.UserService;
import com.hniu.util.State;

@RestController
public class UserController extends Base{

	@Autowired
	private UserService userService;
	
	public StateCode StateCode;
	
	//模糊查询
	@GetMapping("/getFuzzyqueryUser")
	public State<Object> getFuzzyqueryUser(String name){
		if (name == null) {
			return packaging(StateCode.FAIL, "参数不能为空",name);
		}
		return userService.getFuzzyquery(name);
	}
	
	
	//分页
	@GetMapping("/getUserAll")
	public State<Object> getUserAll(Integer page,Integer rows){
		if (page == null || rows == null) {
			return packaging(StateCode.FAIL, "参数不能为空",page+rows);
		}
		return userService.getUserAll(page,rows);
	}
	
	@GetMapping("/getUserId")
    public State<Object> getUser(Integer id){
		if(id == null){
			return packaging(StateCode.FAIL, "参数不能为空",id);
		}
        return  userService.getUser(id);
    }

    //微信查询用户信息
	@GetMapping("/user/wx_selectUser/{token}")
	public State<Object> wx_getUser(@PathVariable("token")String token){
		RedisUtil redisUtil = new RedisUtil();
		String object = (String) redisUtil.getObject(token);
		if(object==null){
			return packaging(com.hniu.constan.StateCode.FAIL,"查询失败",null);
		}
		String[] split = object.split(",");
		Integer user_id = Integer.parseInt(split[2]);
		if(user_id == null){
			return packaging(StateCode.FAIL, "参数不能为空",user_id);
		}
		return  userService.getUser(user_id);
	}

	//修改用户信息
    @RequestMapping("/user/updateUser")
	public State<Object> updateUser(UserDto userDto) {
		if(StringUtils.isEmpty(userDto)){
			return packaging(StateCode.FAIL,"修改失败",null);
		}
		int i = userService.updateUser(userDto);
		if(i>0){
			return packaging(com.hniu.constan.StateCode.SUCCESS,"修改成功",null);
		}
		return packaging(StateCode.FAIL,"修改失败",null);
	}

	//微信修改用户信息
	@RequestMapping("/user/wx_updateUser/{token}")
	public State<Object> updateUser(@PathVariable("token")String token , UserDto userDto) {
		if(StringUtils.isEmpty(userDto)){
			return packaging(StateCode.FAIL,"修改失败",null);
		}
		RedisUtil redisUtil = new RedisUtil();
		String object = (String) redisUtil.getObject(token);
		if(object==null){
			return packaging(com.hniu.constan.StateCode.FAIL,"查询失败",null);
		}
		String[] split = object.split(",");
		Integer user_id = Integer.parseInt(split[2]);
		userDto.setUserId(user_id);
		int i = userService.updateUser(userDto);
		if(i>0){
			return packaging(com.hniu.constan.StateCode.SUCCESS,"修改成功",null);
		}
		return packaging(StateCode.FAIL,"修改失败",null);
	}


    
    @DeleteMapping("/user/deleteUser/{user_id}")
    public State<Object> deleteUser(@PathVariable("user_id") Integer user_id) {
		int i = userService.deleteUser(user_id);
		if(i>0){
			return packaging(com.hniu.constan.StateCode.SUCCESS,"删除成功",null);
		}
		return packaging(StateCode.FAIL,"删除失败",null);
    }
	
    
    
	
}
