package com.hniu.controller;



import com.hniu.dto.GiveDto;
import com.hniu.entity.vo.GiveVo;
import com.hniu.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hniu.constan.StateCode;
import com.hniu.entity.Give;
import com.hniu.service.GiveService;
import com.hniu.util.State;

import java.util.List;

/*
 * 授课管理 
 * author: DZY
 */
@RestController
public class GiveController extends Base{

	public Base base=new Base();
	
	@Autowired
	private GiveService giveService;
	
	
	@GetMapping("/getGiveByid")
	public State<Object> getGiveByid(Integer id){
		if (id == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",id);
		}
		return giveService.getGiveByid(id);
	}
	
	@PostMapping("/insertGive")
	public State<Object> insertGive(Give give){
		if (give == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",give);
		}
		return giveService.insertGive(give);
	}
	
	@PutMapping("/updateGive")
	public State<Object> updateGive(Give give){
		if (give == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",give);
		}
		return giveService.updateGive(give);
	}
	
	
	@DeleteMapping("/deleteByidGive/{give_id}")
	public State<Object> deleteByidGive(@PathVariable("give_id") Integer give_id){
		if (give_id == null ) {
			return base.packaging(StateCode.FAIL, "参数不能为空",give_id);
		}
	    return giveService.deleteByidGive(give_id);
	}
	
	
	@GetMapping("/getAllByid")
	public State<Object> getAllByid(Integer id){
		if (id == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",id);
		}
		return giveService.getAllByid(id);
	}

	//根据课程id查询授课信息和教师信息   --熊俊
	@GetMapping("/give/giveAndTeacher")
	public State<Object> giveAndTeacher(Integer curriculum_id){
		if(curriculum_id == null){
			return packaging(StateCode.FAIL,"教师id为null",null);
		}
		List<GiveDto> list = giveService.giveAndTeacher(curriculum_id);
		if(list.size()>=0){
			return packaging(StateCode.SUCCESS,"查询成功",list);
		}else{
			return packaging(StateCode.FAIL,"查询失败",null);
		}
	}

	//根据教师id查询授课信息和课程信息
	@GetMapping("/give/giveAndCurriculum")
	public State<Object> giveAndCurriculum(Integer teacher_id){
		if(teacher_id == null){
			return packaging(StateCode.FAIL,"教师id为null",null);
		}
		List<GiveDto> list = giveService.giveAndCurriculum(teacher_id);
		if(list.size()>=0){
			return packaging(StateCode.SUCCESS,"查询成功",list);
		}else{
			return packaging(StateCode.FAIL,"查询失败",null);
		}
	}

	//分页查询所有授课信息
	@GetMapping("/give/giveAll")
	public State<Object> giveAll(Integer currentPage,Integer pageSize){
		if (currentPage==null||pageSize==null) {
			return packaging(StateCode.FAIL, "请输入页数和总数", null);
		}
		Page<GiveVo> list = giveService.giveAll(currentPage, pageSize);
		if(list.getList().size()>0){
			return packaging(StateCode.SUCCESS,"查询成功",list);
		}
			return packaging(StateCode.FAIL,"查询失败",null);
	}
	
	
}
