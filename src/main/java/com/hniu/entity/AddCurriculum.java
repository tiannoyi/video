package com.hniu.entity;

public class AddCurriculum {
    private Integer addId;

    private Integer tutionId;

    private Integer userId;

    private Double courseGrade;

    private String isQualified;

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public Integer getTutionId() {
        return tutionId;
    }

    public void setTutionId(Integer tutionId) {
        this.tutionId = tutionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(Double courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(String isQualified) {
        this.isQualified = isQualified;
    }
}