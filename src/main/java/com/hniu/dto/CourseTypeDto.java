package com.hniu.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 熊俊
 * @Date: 2018/10/13 16:27
 * @Description:
 * @Modified By:
 */
public class CourseTypeDto {
    private Integer ctId;

    private String ctName;

    private MultipartFile picture;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }
}
