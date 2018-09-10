package com.hniu.entity;

public class Curriculum {
    private Integer curriculumId;

    private Integer universityId;

    private Integer ctId;

    private String name;

    private String message;

    private String propaedeutics;

    private String meferences;

    private String require;

    private String picture;

    private Integer time;

    private Double score;

    private String video;

    private Boolean isMainpic;

    private String mainTeacher;

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
        this.name = name == null ? null : name.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getPropaedeutics() {
        return propaedeutics;
    }

    public void setPropaedeutics(String propaedeutics) {
        this.propaedeutics = propaedeutics == null ? null : propaedeutics.trim();
    }

    public String getMeferences() {
        return meferences;
    }

    public void setMeferences(String meferences) {
        this.meferences = meferences == null ? null : meferences.trim();
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require == null ? null : require.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public Boolean getIsMainpic() {
        return isMainpic;
    }

    public void setIsMainpic(Boolean isMainpic) {
        this.isMainpic = isMainpic;
    }

    public String getMainTeacher() {
        return mainTeacher;
    }

    public void setMainTeacher(String mainTeacher) {
        this.mainTeacher = mainTeacher == null ? null : mainTeacher.trim();
    }
}