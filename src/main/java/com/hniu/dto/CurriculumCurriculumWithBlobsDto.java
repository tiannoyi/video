package com.hniu.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 熊俊
 * @Date: 2018/10/20 13:33
 * @Description:
 * @Modified By:
 */
public class CurriculumCurriculumWithBlobsDto {
    private Integer curriculumId;

    private Integer universityId;

    private Integer ctId;

    private String name;

    private String message;

    private String propaedeutics;

    private String meferences;

    private String require;

    private MultipartFile picture;

    private Integer time;

    private Double score;

    private MultipartFile video;

    private Boolean isMainpic;

    private String mainTeacher;

    private String introduce;

    private String scoring;

    public Integer getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Integer curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPropaedeutics() {
        return propaedeutics;
    }

    public void setPropaedeutics(String propaedeutics) {
        this.propaedeutics = propaedeutics;
    }

    public String getMeferences() {
        return meferences;
    }

    public void setMeferences(String meferences) {
        this.meferences = meferences;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public MultipartFile getVideo() {
        return video;
    }

    public void setVideo(MultipartFile video) {
        this.video = video;
    }

    public Boolean getMainpic() {
        return isMainpic;
    }

    public void setMainpic(Boolean mainpic) {
        isMainpic = mainpic;
    }

    public String getMainTeacher() {
        return mainTeacher;
    }

    public void setMainTeacher(String mainTeacher) {
        this.mainTeacher = mainTeacher;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getScoring() {
        return scoring;
    }

    public void setScoring(String scoring) {
        this.scoring = scoring;
    }
}
