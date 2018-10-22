package com.hniu.controller;

import com.hniu.constan.StateCode;
import com.hniu.controller.base.Base;
import com.hniu.entity.Admin;
import com.hniu.entity.Teacher;
import com.hniu.entity.TeacherExample;
import com.hniu.entity.vo.AdminVo;
import com.hniu.entity.vo.TeacherIdAndRoleName;
import com.hniu.exception.NotLoginException;
import com.hniu.exception.PassWordIsNullException;
import com.hniu.exception.SystemErrorException;
import com.hniu.exception.UserNameIsNullException;
import com.hniu.mapper.AdminMapper;
import com.hniu.mapper.RolesMapper;
import com.hniu.mapper.TeacherMapper;
import com.hniu.service.PermissionsService;
import com.hniu.service.WxLoginService;
import org.apache.catalina.mbeans.RoleMBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class LoginController extends Base {
    @Autowired
    PermissionsService ps;

    @Autowired
    WxLoginService ws;

    @Resource
    AdminMapper adminMapper;

    @Resource
    TeacherMapper teacherMapper;

    @Resource
    RolesMapper rolesMapper;

    //微信登录
    @PostMapping("/wx_login")
    public Object login(String code) throws UserNameIsNullException, PassWordIsNullException {
        String uuid;
        try {
            uuid = ws.wxLogin(code);
        } catch (UserNameIsNullException uine) {
            return packaging(StateCode.USERNAMENOTNULL, code);
        } catch (PassWordIsNullException pine) {
            return packaging(StateCode.PASSWORDNOTNULL, code);
        } catch (UnknownAccountException uae) {
            return packaging(StateCode.USERNAMENOTEXIST, code);
        } catch (IncorrectCredentialsException ice) {
            return packaging(StateCode.PASSWORDMISTAKE, code);
        } catch (LockedAccountException lae) {
            return packaging(StateCode.USERNAMELOCK, code);
        } catch (SystemErrorException e) {
            return packaging(StateCode.FAIL, code);
        } catch (AuthenticationException ae) {
            return packaging(StateCode.FAIL, code);
        }
        return packaging(StateCode.SUCCESS, uuid);
    }

    //管理员登录
    @PostMapping("/login")
    public Object login(@RequestBody Admin admin) throws UserNameIsNullException, PassWordIsNullException {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(SecurityUtils.getSubject().getSession().getId());
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getAdminName(), admin.getPassword());
        try {
            subject.login(token);
        } catch (UserNameIsNullException uine) {
            return packaging(StateCode.USERNAMENOTNULL, token.getUsername());
        } catch (PassWordIsNullException pine) {
            return packaging(StateCode.PASSWORDNOTNULL, token.getUsername());
        } catch (UnknownAccountException uae) {
            return packaging(StateCode.USERNAMENOTEXIST, token.getUsername());
        } catch (IncorrectCredentialsException ice) {
            return packaging(StateCode.PASSWORDMISTAKE, token.getUsername());
        } catch (LockedAccountException lae) {
            return packaging(StateCode.USERNAMELOCK, token.getUsername());
        } catch (AuthenticationException ae) {
            return packaging(StateCode.FAIL, token.getUsername());
        }
        AdminVo a = adminMapper.selectAdminId(token.getUsername());
        String account = a.getAdminId().toString();
        String roleName = a.getRole().getRoleName();
        TeacherExample example = new TeacherExample();
        example.createCriteria().andAccountEqualTo(account);
        List<Teacher> list = teacherMapper.selectByExample(example);
        TeacherIdAndRoleName teacherIdAndRoleName = new TeacherIdAndRoleName();
        if(list.size()>0){
            teacherIdAndRoleName.setTeacherId(list.get(0).getTeacherId());
            teacherIdAndRoleName.setRoleName(roleName);
          return  packaging(StateCode.SUCCESS, teacherIdAndRoleName);
        }if(list.size()<=0) {
            teacherIdAndRoleName.setRoleName(roleName);
        }
        return packaging(StateCode.SUCCESS,teacherIdAndRoleName);
    }

    @GetMapping("/menu")
    public Object menu() {
        System.out.println(SecurityUtils.getSubject().getSession().getId());
        try {
            return packaging(StateCode.SUCCESS, ps.selectMenu());
        } catch (NotLoginException e) {
            return packaging(StateCode.LOGINAGAIN, null);
        }
    }
}
