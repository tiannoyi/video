package com.hniu.service.imp;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hniu.entity.Roles;
import com.hniu.entity.System;
import com.hniu.entity.vo.RolesVo;
import com.hniu.entity.wrap.PageWrap;
import com.hniu.mapper.RolesMapper;
import com.hniu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    System system;

    @Autowired
    RolesMapper rm;

    @Override
    public PageWrap selectAll(Integer pageNum, Integer pageSize) {
        if (pageSize == null )
            pageSize = system.getPageLine().intValue();
        if (pageNum == null)
            pageNum = 1;
        PageHelper.startPage(pageNum, pageSize);
        List<RolesVo> list = rm.selectAllVo();
        PageInfo pageInfo = new PageInfo(list);
        return new PageWrap(pageInfo);
    }


    @Override
    public RolesVo selectByPrimaryKeyVo(Integer roleId) {
        return rm.selectByPrimaryKeyVo(roleId);
    }

    @Override
    public int updateByPrimaryKey(Roles role) {
        return rm.updateByPrimaryKeySelective(role);
    }

    @Override
    public int insertRole(Roles role) {
        role.setRoleId(null);
        return rm.insert(role);
    }

    @Override
    public int deleteRole(Integer id) {
        return rm.deleteByPrimaryKey(id);
    }
}
