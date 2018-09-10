package com.hniu.entity;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private String content;

    private Date ctime;

    private Integer curriculumId;

    private Integer userId;

    private Integer asteriskNum;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAsteriskNum() {
        return asteriskNum;
    }

    public void setAsteriskNum(Integer asteriskNum) {
        this.asteriskNum = asteriskNum;
    }
}