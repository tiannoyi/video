package com.hniu.service;

import com.hniu.dto.GiveDto;
import com.hniu.entity.vo.GiveVo;
import com.hniu.util.Page;
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

	//根据教师id查询授课信息和课程信息
	List<GiveDto> giveAndCurriculum(Integer teacher_id);

	//分页查询所有授课信息
	Page<GiveVo> giveAll(Integer currentPage,Integer pageSize);
	
	
}
