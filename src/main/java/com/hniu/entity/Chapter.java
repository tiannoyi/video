package com.hniu.entity;

import java.util.Date;

public class Chapter {
    private Integer chapterId;

    private String chapterName;

    private String chapterNum;

    private String redactTeacher;

    private Date redactTime;

    private Integer curriculumId;

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public String getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(String chapterNum) {
        this.chapterNum = chapterNum == null ? null : chapterNum.trim();
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

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }
}