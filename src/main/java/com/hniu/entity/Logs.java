package com.hniu.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tbl_logs")
public class Logs {
    /**
     * 日志id
     */
    @Id
    private Integer id;

    /**
     * 操作时间
     */
    private Date time;

    /**
     * 管理员id
     */
    @Column(name = "admin_id")
    private Integer adminId;

    /**
     * 操作动作
     */
    @Column(name = "ope_action")
    private String opeAction;

    /**
     * 操作实体
     */
    @Column(name = "ope_entity")
    private String opeEntity;

    /**
     * 操作详细
     */
    @Column(name = "ope_detail")
    private String opeDetail;

    /**
     * 获取日志id
     *
     * @return id - 日志id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置日志id
     *
     * @param id 日志id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取操作时间
     *
     * @return time - 操作时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置操作时间
     *
     * @param time 操作时间
     */
    public void setTime(Date time) {
        this.time = time;
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
     * 获取操作动作
     *
     * @return ope_action - 操作动作
     */
    public String getOpeAction() {
        return opeAction;
    }

    /**
     * 设置操作动作
     *
     * @param opeAction 操作动作
     */
    public void setOpeAction(String opeAction) {
        this.opeAction = opeAction;
    }

    /**
     * 获取操作实体
     *
     * @return ope_entity - 操作实体
     */
    public String getOpeEntity() {
        return opeEntity;
    }

    /**
     * 设置操作实体
     *
     * @param opeEntity 操作实体
     */
    public void setOpeEntity(String opeEntity) {
        this.opeEntity = opeEntity;
    }

    /**
     * 获取操作详细
     *
     * @return ope_detail - 操作详细
     */
    public String getOpeDetail() {
        return opeDetail;
    }

    /**
     * 设置操作详细
     *
     * @param opeDetail 操作详细
     */
    public void setOpeDetail(String opeDetail) {
        this.opeDetail = opeDetail;
    }
}