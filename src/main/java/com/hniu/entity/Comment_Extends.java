package com.hniu.entity;

import java.io.Serializable;

public class Comment_Extends extends Comment implements Serializable{

	private String name;

	private Integer asterisk_num;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAsterisk_num() {
		return asterisk_num;
	}

	public void setAsterisk_num(Integer asterisk_num) {
		this.asterisk_num = asterisk_num;
	}

	public String getCourseName() {
		return name;
	}

	public void setCourseName(String name) {
		name = name;
	} 
	
}
