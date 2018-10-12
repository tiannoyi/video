package com.hniu.controller;

import com.hniu.constan.StateCode;
import com.hniu.controller.base.Base;
import com.hniu.entity.Admin;
import com.hniu.entity.wrap.PageWrap;
import com.hniu.exception.NotLoginException;
import com.hniu.exception.PassWordErrorException;
import com.hniu.exception.SystemErrorException;
import com.hniu.exception.UserNameExistException;
import com.hniu.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class AdminController extends Base {

    @Autowired
    AdminService as;

    @GetMapping("/admins")
    public Object selectAll(Integer pageNum,  Integer pageSize) {
        System.out.println(SecurityUtils.getSubject().getSession().getId());
        PageWrap data = as.selectAllVo(pageNum, pageSize);
        return packaging(StateCode.SUCCESS, data);
    }

    @GetMapping("/admins/{id}")
    public Object selectByPrimaryKey(@PathVariable("id") Integer id) {
        return packaging(StateCode.SUCCESS, as.selectByPrimaryKeyVo(id));
    }

    @PostMapping("/admins")
    public Object insert(@RequestBody Admin admin) {
        try {
            return packaging(StateCode.SUCCESS, as.insert(admin));
        } catch (UserNameExistException e) {
            return packaging(StateCode.USERNAMEEXIST, admin);
        } catch (SystemErrorException e) {
            return packaging(StateCode.FAIL, admin);
        }
    }

    @PutMapping("admins/{id}")
    public Object update(@PathVariable("id") Integer id, @RequestBody Admin admin) {
        admin.setAdminId(id);
        return packaging(StateCode.SUCCESS, as.update(admin));
    }

    @PutMapping("/admins/update_password")
    public Object updatePassword(@RequestBody Map<String,String> map) {
        try {
            return packaging(StateCode.SUCCESS, as.changePassword(map));
        } catch (NotLoginException e) {
            return packaging(StateCode.LOGINAGAIN, null);
        } catch (PassWordErrorException e) {
            return packaging(StateCode.PASSWORDMISTAKE, map.get("oldoldPassword"));
        }

    }

    @DeleteMapping("/admins/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        int i = as.delete(id);
        if (i > 0)
            return packaging(StateCode.SUCCESS, null);
        else
            return packaging(StateCode.FAIL, null);

    }


}
