package com.hniu.service;

import org.springframework.stereotype.Repository;

import com.hniu.entity.CourseType;
import com.hniu.entity.University;
import com.hniu.util.State;

@Repository
public interface SchoolService {

	State<Object> insertSchool(University university);

	State<Object> getSchool(Integer id);

	State<Object> updateSchool(University university);

	State<Object> deleteSchool(Integer id);

	State<Object> getSchoolAll(Integer page, Integer rows);

	State<Object> getFuzzyquery(String name);
	
}
