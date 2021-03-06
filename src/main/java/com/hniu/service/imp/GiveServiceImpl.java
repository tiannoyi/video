package com.hniu.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.hniu.dto.GiveDto;
import com.hniu.entity.vo.GiveVo;
import com.hniu.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hniu.constan.StateCode;
import com.hniu.controller.Base;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.entity.Give;
import com.hniu.entity.Teacher;
import com.hniu.mapper.CurriculumMapper;
import com.hniu.mapper.GiveMapper;
import com.hniu.mapper.TeacherMapper;
import com.hniu.service.GiveService;
import com.hniu.util.ChangliangUtil;
import com.hniu.util.State;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class GiveServiceImpl extends Base implements GiveService {

	@Resource
	private GiveMapper giveMapper;
	
	@Resource
    private CurriculumMapper curriculumMapper;
	
	@Resource
	private TeacherMapper teacherMapper;
	
	@Override
	public State<Object> getGiveByid(Integer id) {
		Give give = giveMapper.selectByPrimaryKey(id);
		if (give != null) {
			return this.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, give);
		}
		return this.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, give);
	}


	@Override
	public State<Object> insertGive(Give give) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(give.getTeacherId());
		if(StringUtils.isEmpty(teacher)){
			return packaging(StateCode.FAIL,"教师不存在",null);
		}
		CurriculumWithBLOBs curriculum = curriculumMapper.selectByPrimaryKey(give.getCurriculumId());
		if(StringUtils.isEmpty(curriculum)){
			return packaging(StateCode.FAIL,"课程不存在",null);
		}
		int insert = giveMapper.insertSelective(give);
		if (insert > 0) {
			return this.packaging(StateCode.SUCCESS, ChangliangUtil.INSERTSUCCESS, insert);
		}
		return this.packaging(StateCode.FAIL, ChangliangUtil.INSERTFAIL, null);
	}


	@Override
	public State<Object> updateGive(Give give) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(give.getTeacherId());
		if(StringUtils.isEmpty(teacher)){
			return packaging(StateCode.FAIL,"教师不存在",null);
		}
		CurriculumWithBLOBs curriculum = curriculumMapper.selectByPrimaryKey(give.getCurriculumId());
		if(StringUtils.isEmpty(curriculum)){
			return packaging(StateCode.FAIL,"课程不存在",null);
		}
		int update = giveMapper.updateByPrimaryKeySelective(give);
		if (update == 1 ) {
			return this.packaging(StateCode.SUCCESS, ChangliangUtil.UPDATESUCCESS, update);
		}
		return  this.packaging(StateCode.SUCCESS, ChangliangUtil.UPDATEFAIL, null);
	}

	@Override
	public State<Object> deleteByidGive(Integer id) {
		int i = giveMapper.deleteByPrimaryKey(id);
		if (i == 1 ) {
			return this.packaging(StateCode.SUCCESS, ChangliangUtil.DELETESUCCESS, i);
		}
		return this.packaging(StateCode.SUCCESS, ChangliangUtil.DELETEFAIL, i);
	}


	@Override
	public State<Object> getAllByid(Integer id) {
		List<Object> list=new ArrayList<>();
		Give give = giveMapper.selectByPrimaryKey(id);
		CurriculumWithBLOBs selectByPrimaryKey = curriculumMapper.selectByPrimaryKey(give.getCurriculumId());
		Teacher teacher = teacherMapper.selectByPrimaryKey(give.getTeacherId());
		list.add(give);
		list.add(selectByPrimaryKey);
		list.add(teacher);
		if (give != null && selectByPrimaryKey !=null && teacher != null) {
			return this.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, list);
		}
		return this.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYFAIL, null);
	}

	@Override
	public List<GiveDto> giveAndTeacher(Integer curriculum_id) {
		return giveMapper.giveAndTeacher(curriculum_id);
	}

	@Override
	public List<GiveDto> giveAndCurriculum(Integer teacher_id) {
		return giveMapper.giveAndCurriculum(teacher_id);
	}

	@Override
	public Page<GiveVo> giveAll(Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		List<GiveVo> list = giveMapper.selectGiveAll();
		int countNums = giveMapper.count();
		Page<GiveVo> pageData = new Page<>(currentPage,pageSize,countNums);
		pageData.setList(list);
		return pageData;
	}


}
