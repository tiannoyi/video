package com.hniu.entity;

import java.util.Date;

public class Knowledge {
    private Integer knowledgeId;

    private Integer chapterId;

    private String summaryName;

    private String summaryNum;

    private String redactTeacher;

    private Date redactTime;

    public Integer getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Integer knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getSummaryName() {
        return summaryName;
    }

    public void setSummaryName(String summaryName) {
        this.summaryName = summaryName == null ? null : summaryName.trim();
    }

    public String getSummaryNum() {
        return summaryNum;
    }

    public void setSummaryNum(String summaryNum) {
        this.summaryNum = summaryNum == null ? null : summaryNum.trim();
    }

    public String getRedactTeacher() {
        return redactTeacher;
    }

    public void setRedactTeacher(String redactTeacher) {
        this.redactTeacher = redactTeacher == null ? null : redactTeacher.trim();
    }

    public Date getRedactTime() {
        return redactTime;
    }

    public void setRedactTime(Date redactTime) {
        this.redactTime = redactTime;
    }
}