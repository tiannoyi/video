package com.hniu.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: 熊俊
 * @Date: 2018/10/25 9:05
 * @Description:
 * @Modified By:
 */
@RestController()
@RequestMapping("ifLogin")
public class IfLoginController {
    @GetMapping()
    public Boolean ifLogin(HttpSession session){
        String s = (String) session.getAttribute("admin");
        if (StringUtils.isEmpty(s)) {
            return false;
        }
        if (s.equals("true")){
            return true;
        }
        return false;
    }
}
