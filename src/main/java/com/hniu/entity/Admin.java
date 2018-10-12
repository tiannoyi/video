package com.hniu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "tbl_admins")
public class Admin {
    /**
     * 管理员id
     */
    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    /**
     * 管理员姓名
     */
    @Column(name = "admin_name")
    @NotNull(message="用户名不能为空")
    private String adminName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 登陆密码
     */
    @NotNull(message="密码不能为空")
    private String password;

    /**
     * 盐
     */
    @JsonIgnore
    private String salt;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String phone, String password, String salt, Integer roleId) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.roleId = roleId;
    }

    /**
     * 获取管理员id
     *
     * @return admin_id - 管理员id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 设置管理员id
     *
     * @param adminId 管理员id
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取管理员姓名
     *
     * @return admin_name - 管理员姓名
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置管理员姓名
     *
     * @param adminName 管理员姓名
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取登陆密码
     *
     * @return password - 登陆密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登陆密码
     *
     * @param password 登陆密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}