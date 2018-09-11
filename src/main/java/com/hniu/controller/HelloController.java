package com.hniu.controller;

import com.hniu.entity.User;
import com.hniu.service.HelloService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("login")
    public String s1() {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("123","123"));
        return "login";
    }

    @GetMapping("hello")
    public String s2() {
        return "hello";
    }

    @RequiresPermissions("per")
    @GetMapping("hello2")
    public String s4() {
        return "hello2";
    }

    @GetMapping("error")
    public String s3() {
        return "error";
    }
    @GetMapping("ceshi")
    public String s5(){
        User user = helloService.list().get(0);
        String userName = user.getUserName();
        return userName;
    }

}
