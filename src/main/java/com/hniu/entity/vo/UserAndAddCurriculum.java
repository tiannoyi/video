package com.hniu.entity.vo;

import com.hniu.entity.AddCurriculum;

/**
 * @Author: 熊俊
 * @Date: 2018/10/22 10:09
 * @Description:
 * @Modified By:
 */
public class UserAndAddCurriculum extends AddCurriculum {
    private Integer userId;
    private String userName;
    private String portrait;

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}
