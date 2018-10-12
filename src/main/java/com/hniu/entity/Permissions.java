package com.hniu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbl_permissions")
public class Permissions {
    /**
     * 权限ID
     */
    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * 权限名
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 权限字符串
     */
    @JsonIgnore
    @Column(name = "permission_str")
    private String permissionStr;

    /**
     * 权限类型
     */
    @Column(name = "permission_type")
    private Byte permissionType;

    /**
     * 地址
     */
    private String path;

    /**
     * 图片
     */
    private String img;

    /**
     * 序号
     */
    @Column(name = "`order`")
    private Byte order;

    /**
     * 父节点id
     */
    @Column(name = "father_node")
    private Integer fatherNode;

    /**
     * 获取权限ID
     *
     * @return permission_id - 权限ID
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限ID
     *
     * @param permissionId 权限ID
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取权限名
     *
     * @return permission_name - 权限名
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 设置权限名
     *
     * @param permissionName 权限名
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * 获取权限字符串
     *
     * @return permission_str - 权限字符串
     */
    public String getPermissionStr() {
        return permissionStr;
    }

    /**
     * 设置权限字符串
     *
     * @param permissionStr 权限字符串
     */
    public void setPermissionStr(String permissionStr) {
        this.permissionStr = permissionStr;
    }

    /**
     * 获取权限类型
     *
     * @return permission_type - 权限类型
     */
    public Byte getPermissionType() {
        return permissionType;
    }

    /**
     * 设置权限类型
     *
     * @param permissionType 权限类型
     */
    public void setPermissionType(Byte permissionType) {
        this.permissionType = permissionType;
    }

    /**
     * 获取地址
     *
     * @return path - 地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置地址
     *
     * @param path 地址
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取图片
     *
     * @return img - 图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置图片
     *
     * @param img 图片
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取序号
     *
     * @return order - 序号
     */
    public Byte getOrder() {
        return order;
    }

    /**
     * 设置序号
     *
     * @param order 序号
     */
    public void setOrder(Byte order) {
        this.order = order;
    }

    /**
     * 获取父节点id
     *
     * @return father_node - 父节点id
     */
    public Integer getFatherNode() {
        return fatherNode;
    }

    /**
     * 设置父节点id
     *
     * @param fatherNode 父节点id
     */
    public void setFatherNode(Integer fatherNode) {
        this.fatherNode = fatherNode;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "permissionId=" + permissionId +
                ", permissionName='" + permissionName + '\'' +
                ", permissionStr='" + permissionStr + '\'' +
                ", permissionType=" + permissionType +
                ", path='" + path + '\'' +
                ", img='" + img + '\'' +
                ", order=" + order +
                ", fatherNode=" + fatherNode +
                '}';
    }
}