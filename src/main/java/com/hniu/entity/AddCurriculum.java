package com.hniu.entity;

public class AddCurriculum {
    private Integer addId;

    private Integer tutionId;

    private Integer userId;

    private Double courseGrade;

    private Boolean isQualified;

    private Double star;

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

    public Boolean getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Boolean isQualified) {
        this.isQualified = isQualified;
    }

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }
}