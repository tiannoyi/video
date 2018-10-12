package com.hniu.service;

import com.hniu.entity.Roles;
import com.hniu.entity.vo.RolesVo;
import com.hniu.entity.wrap.PageWrap;

public interface RoleService {
	//查询所有角色
	PageWrap selectAll(Integer pageNum, Integer pageSize);

	//查询单个角色
	RolesVo selectByPrimaryKeyVo(Integer roleId);

	//更新角色信息
	int updateByPrimaryKey(Roles role);

	// 新增角色
	int insertRole(Roles role);

	//删除角色
	int deleteRole(Integer id);

}
