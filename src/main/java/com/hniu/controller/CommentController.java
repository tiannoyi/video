package com.hniu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hniu.constant.StateCode;
import com.hniu.service.CommentService;
import com.hniu.util.State;

/*
 * 发表评论Controller
 * author:邓志勇
 */
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	public Base base;
	
	public StateCode StateCode;
	
	@GetMapping("getComment")
	public State<Object> getComment(Integer id) {
		if(id == null) {
			 return base.packaging(StateCode.FAIL, "参数不能为空",id);
		 }
		return commentService.getComment(id);
	}
	
	
	
	
	
}
