package com.hniu.entity.vo;

import com.hniu.entity.Performance;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: 熊俊
 * @Date: 2018/10/14 18:52
 * @Description:
 * @Modified By:
 */
public class PerformanceVo extends Performance {
    //-------------题目属性
    private String title;

    private String stems;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String answer;

    private Integer knowledgeId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addtime;
    //---------------用户属性
    private String userName;

    private String wechat;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStems() {
        return stems;
    }

    public void setStems(String stems) {
        this.stems = stems;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Integer knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
