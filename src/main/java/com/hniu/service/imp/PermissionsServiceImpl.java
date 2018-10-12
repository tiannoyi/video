package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hniu.entity.Admin;
import com.hniu.entity.Permissions;
import com.hniu.entity.System;
import com.hniu.entity.vo.Menu;
import com.hniu.entity.vo.RolesVo;
import com.hniu.entity.wrap.PageWrap;
import com.hniu.exception.NotLoginException;
import com.hniu.mapper.PermissionsMapper;
import com.hniu.service.PermissionsService;
import com.hniu.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionsServiceImpl implements PermissionsService {

    @Autowired
    private RoleService rs;

    @Autowired
    private PermissionsMapper pm;

    @Resource
    private System system;

    public List<Permissions> selectPermissions(Integer roleid) {
        RolesVo role = rs.selectByPrimaryKeyVo(roleid);
        List<Permissions> permissions = role.getPermissions();
        return permissions;
    }

    public List<Menu> selectMenu() throws NotLoginException {
        Admin admin = (Admin) SecurityUtils.getSubject().getSession().getAttribute("admin");
        if(admin == null){
            throw new NotLoginException();
        }
        List<Permissions> permissions = selectPermissions(admin.getRoleId());
        List<Menu> menus = new ArrayList<Menu>();
        for (Permissions p1 : permissions) {
            if (p1.getFatherNode() == 0) {
                Menu menu = new Menu();
                menu.setPermissions(p1);
                for (Permissions p2 : permissions) {
                    if (p2.getFatherNode() == p1.getPermissionId()) {
                        menu.getList().add(p2);
                    }
                }
                menus.add(menu);
            }
        }
        return menus;
    }

    @Override
    public PageWrap selectAll(Integer pageNum, Integer pageSize) {
        if(pageSize == null)
            pageSize = system.getPageLine().intValue();
        if (pageNum == null)
            pageNum = 1;
        PageHelper.startPage(pageNum, pageSize);
        List<Permissions> list = pm.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return new PageWrap(pageInfo);
    }

    @Override
    public Permissions selectPrimaryKey(Integer permissionId) {
        return pm.selectByPrimaryKey(permissionId);
    }
}
