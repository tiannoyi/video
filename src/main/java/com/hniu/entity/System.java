package com.hniu.entity;

public class System {
    private Integer sustemId;

    private String systemName;

    private String systemLogo;

    private String cover;

    private String appsecret;

    private String appid;

    private Byte pageLine;

    public Integer getSustemId() {
        return sustemId;
    }

    public void setSustemId(Integer sustemId) {
        this.sustemId = sustemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getSystemLogo() {
        return systemLogo;
    }

    public void setSystemLogo(String systemLogo) {
        this.systemLogo = systemLogo == null ? null : systemLogo.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret == null ? null : appsecret.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public Byte getPageLine() {
        return pageLine;
    }

    public void setPageLine(Byte pageLine) {
        this.pageLine = pageLine;
    }

    public System(Integer sustemId, String systemName, String systemLogo, String cover, String appsecret, String appid, Byte pageLine) {
        this.sustemId = sustemId;
        this.systemName = systemName;
        this.systemLogo = systemLogo;
        this.cover = cover;
        this.appsecret = appsecret;
        this.appid = appid;
        this.pageLine = pageLine;
    }

    public System(){

    }
}