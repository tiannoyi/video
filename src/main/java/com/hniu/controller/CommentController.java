package com.hniu.controller;

import com.hniu.entity.Comment;
import com.hniu.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hniu.constan.StateCode;
import com.hniu.service.CommentService;
import com.hniu.util.State;

/*
 * 发表评论Controller
 * author:邓志勇
 */
@RestController
public class CommentController extends Base{

	@Autowired
	private CommentService commentService;
	
	public Base base=new Base();
	
	public StateCode StateCode;

	@GetMapping("getComment")
	public State<Object> getComment(Integer id) {
		if(id == null) {
			 return base.packaging(StateCode.FAIL, "参数不能为空",id);
		 }
		return commentService.getComment(id);
	}


	//删除课程评论
	@DeleteMapping(value = "/comment/deleteComment/{comment_id}")
	public State<Object> deleteComment(@PathVariable("comment_id")Integer comment_id){
		int i = commentService.deleteComment(comment_id);
		if(i != 0){
			return packaging(StateCode.SUCCESS,"课程评论删除成功",null);
		}else{
			return packaging(StateCode.FAIL,"课程评论删除失败",null);
		}
	}

	//分页查询所有课程评论
	@GetMapping("/comment/commentPage")
	public State<Object> commentPage(Integer currentPage, Integer pageSize){
		if(currentPage==null || pageSize == null){
			return packaging(StateCode.FAIL,"课程评论查询失败",null);
		}
		Page<Comment> list = commentService.commentPage(currentPage, pageSize);
		if(list.getList().size()>0){
			return packaging(com.hniu.constan.StateCode.SUCCESS,"课程评论查询成功",list);
		}else{
			return packaging(com.hniu.constan.StateCode.FAIL,"课程评论查询失败",null);
		}
	}
	
	
	
	
	
}
