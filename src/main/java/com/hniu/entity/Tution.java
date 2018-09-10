package com.hniu.entity;

import java.util.Date;

public class Tution {
    private Integer tutionId;

    private Integer curriculumId;

    private Date startTime;

    private Date endtime;

    private String schedules;

    private Integer population;

    private Boolean status;

    public Integer getTutionId() {
        return tutionId;
    }

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
        this.schedules = schedules == null ? null : schedules.trim();
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}