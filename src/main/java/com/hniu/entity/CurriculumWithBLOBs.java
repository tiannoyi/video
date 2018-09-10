package com.hniu.entity;

public class CurriculumWithBLOBs extends Curriculum {
    private String introduce;

    private String scoring;

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getScoring() {
        return scoring;
    }

    public void setScoring(String scoring) {
        this.scoring = scoring == null ? null : scoring.trim();
    }
}