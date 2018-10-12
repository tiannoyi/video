package com.hniu.service;


import com.hniu.entity.Permissions;
import com.hniu.entity.vo.Menu;
import com.hniu.entity.wrap.PageWrap;
import com.hniu.exception.NotLoginException;

import java.util.List;

public interface PermissionsService {
    public List<Permissions> selectPermissions(Integer roleid);

    public List<Menu> selectMenu() throws NotLoginException;

    public PageWrap selectAll(Integer pageNum, Integer pageSize);

    public Permissions selectPrimaryKey(Integer permissionId);
}
