package com.hniu.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hniu.constant.StateCode;
import com.hniu.controller.Base;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.entity.Give;
import com.hniu.entity.Teacher;
import com.hniu.mapper.CurriculumMapper;
import com.hniu.mapper.GiveMapper;
import com.hniu.mapper.TeacherMapper;
import com.hniu.service.CurriculumService;
import com.hniu.service.GiveService;
import com.hniu.util.ChangliangUtil;
import com.hniu.util.State;

@Service
public class GiveServiceImpl extends Base implements GiveService {

	@Autowired
	private GiveMapper giveMapper;
	
	@Autowired
    private CurriculumMapper curriculumMapper;
	
	@Autowired
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
		int insert = giveMapper.insert(give);
		if (insert == 1) {
			return this.packaging(StateCode.SUCCESS, ChangliangUtil.INSERTSUCCESS, insert);
		}
		return this.packaging(StateCode.FAIL, ChangliangUtil.INSERTFAIL, insert);
	}


	@Override
	public State<Object> updateGive(Give give) {
		int update = giveMapper.updateByPrimaryKeySelective(give);
		if (update == 1 ) {
			return this.packaging(StateCode.SUCCESS, ChangliangUtil.UPDATESUCCESS, update);
		}
		return  this.packaging(StateCode.SUCCESS, ChangliangUtil.UPDATEFAIL, update);
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
	

}
