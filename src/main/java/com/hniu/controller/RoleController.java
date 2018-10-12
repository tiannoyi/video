package com.hniu.controller;

import com.hniu.constan.StateCode;
import com.hniu.controller.base.Base;
import com.hniu.entity.Roles;
import com.hniu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class RoleController extends Base {

    @Autowired
    RoleService rs;

    // 查询所有角色
    @GetMapping("/roles")
    public Object selectAll(Integer pageNum,Integer pageSize) {
        return packaging(StateCode.SUCCESS, rs.selectAll(pageNum, pageSize));
    }

    // 查询指定id的角色
    @GetMapping("/roles/{roleId}")
    public Object selectRole(@PathVariable Integer roleId) {
        return packaging(StateCode.SUCCESS, rs.selectByPrimaryKeyVo(roleId));
    }

    // 修改角色信息
    @PutMapping("/roles/{roleId}")
    public Object updateRole(@PathVariable Integer roleId, @RequestBody @Valid Roles role) {
        role.setRoleId(roleId);
        return packaging(StateCode.SUCCESS, rs.updateByPrimaryKey(role));
    }

    // 新增角色
    @PostMapping("/roles")
    public Object insertRole(@Valid @RequestBody Roles role) {
        return packaging(StateCode.SUCCESS, rs.insertRole(role));
    }

    // 删除角色
    @DeleteMapping("/roles/{roleId}")
    public Object deleteRole(@PathVariable Integer roleId) {
        return packaging(StateCode.SUCCESS, rs.deleteRole(roleId));
    }
}
