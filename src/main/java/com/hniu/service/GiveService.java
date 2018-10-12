package com.hniu.service;

import com.hniu.dto.GiveDto;
import org.springframework.stereotype.Repository;

import com.hniu.entity.Give;
import com.hniu.util.State;

import java.util.List;

@Repository
public interface GiveService {

	State<Object> getGiveByid(Integer id);

	State<Object> insertGive(Give give);

	State<Object> updateGive(Give give);

	State<Object> deleteByidGive(Integer id);

	State<Object> getAllByid(Integer id);

	//根据教师id查询授课信息和教师信息
	List<GiveDto> giveAndTeacher(Integer curriculum_id);

	
	
}
