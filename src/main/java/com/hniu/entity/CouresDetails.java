package com.hniu.entity;

import java.io.Serializable;
//DZY
/*这个类主要显示这些东西
 * 2.课程名称，学校名称，教师名，课程介绍、课程寄语、预备知识、。。。
评分标准，已参与人数（开课表中该课程ID对应的参与人数之和）等。*/
public class CouresDetails extends Curriculum implements Serializable{

	//学校名称
	private String school_name;
	//参与人数
	private Integer population;
	//课程id
	private Integer curriculum_id;
	//开课id
	private Integer tution_id;
	//用户id
	private Integer user_id;

	public Integer getCurriculum_id() {
		return curriculum_id;
	}
	public void setCurriculum_id(Integer curriculum_id) {
		this.curriculum_id = curriculum_id;
	}
	public Integer getTution_id() {
		return tution_id;
	}
	public void setTution_id(Integer tution_id) {
		this.tution_id = tution_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	
	
	
}
