package com.hniu.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hniu.constant.StateCode;
import com.hniu.entity.Give;
import com.hniu.service.GiveService;
import com.hniu.util.State;

/*
 * 授课管理 
 * author: DZY
 */
@RestController
public class GiveController {

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
	public State<Object> insertGive(@RequestBody Give give){
		if (give == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",give);
		}
		return giveService.insertGive(give);
	}
	
	@PutMapping("/updateGive")
	public State<Object> updateGive(@RequestBody Give give){
		if (give == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",give);
		}
		return giveService.updateGive(give);
	}
	
	
	@DeleteMapping("/deleteByidGive")
	public State<Object> deleteByidGive(Integer id){
		if (id == null ) {
			return base.packaging(StateCode.FAIL, "参数不能为空",id);
		}
	    return giveService.deleteByidGive(id);
	}
	
	
	@GetMapping("/getAllByid")
	public State<Object> getAllByid(Integer id){
		if (id == null) {
			return base.packaging(StateCode.FAIL, "参数不能为空",id);
		}
		return giveService.getAllByid(id);
	}
	
	
}
