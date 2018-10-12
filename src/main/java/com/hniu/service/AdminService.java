package com.hniu.service;

import com.hniu.entity.Admin;
import com.hniu.entity.vo.AdminVo;
import com.hniu.entity.wrap.PageWrap;
import com.hniu.exception.NotLoginException;
import com.hniu.exception.PassWordErrorException;
import com.hniu.exception.SystemErrorException;
import com.hniu.exception.UserNameExistException;

import java.util.Map;

public interface AdminService {

	// 查询指定id的用户信息
	AdminVo selectByPrimaryKeyVo(Integer adminId);

	// 查询所有用户信息
	PageWrap selectAllVo(Integer pageNum, Integer pageSize);

	// 修改用户信息
	int update(Admin admin);

	// 修改自己密码
	int changePassword(Map<String, String> map) throws NotLoginException, PassWordErrorException;

	// 新增管理员
	Admin insert(Admin admin) throws SystemErrorException, UserNameExistException;

	//删除管理员
	int delete(Integer id);
}
