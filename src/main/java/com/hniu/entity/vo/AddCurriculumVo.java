package com.hniu.entity.vo;

import com.hniu.entity.AddCurriculum;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 熊俊
 * @Date: 2018/10/14 11:19
 * @Description:
 * @Modified By:
 */
public class AddCurriculumVo extends AddCurriculum {
    //---------------------用户信息
    private Integer userId;

    private String userName;

    private String wechat;

    //---------------------开课信息
    private Integer tutionId;

    private Integer curriculumId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;

    private String schedules;

    private Integer population;

    private Integer status;

    //----------------------------课程信息
    private String name;

    private String picture;

    private String mainTeacher;

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Override
    public Integer getTutionId() {
        return tutionId;
    }

    @Override
    public void setTutionId(Integer tutionId) {
        this.tutionId = tutionId;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getSchedules() {
        return schedules;
    }

    public void setSchedules(String schedules) {
        this.schedules = schedules;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMainTeacher() {
        return mainTeacher;
    }

    public void setMainTeacher(String mainTeacher) {
        this.mainTeacher = mainTeacher;
    }
}
