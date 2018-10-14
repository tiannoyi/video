package com.hniu.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 熊俊
 * @Date: 2018/10/13 23:52
 * @Description:
 * @Modified By:
 */
public class UserDto {
    private Integer userId;

    private Integer roleId;

    private String userName;

    private String wechat;

    private String password;

    private String phone;

    private String email;

    private String qq;

    private MultipartFile portrait;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public MultipartFile getPortrait() {
        return portrait;
    }

    public void setPortrait(MultipartFile portrait) {
        this.portrait = portrait;
    }
}
