package com.hniu.controller;

import com.hniu.dto.CommentDto;
import com.hniu.entity.Comment;
import com.hniu.util.Page;
import com.hniu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.hniu.constan.StateCode;
import com.hniu.service.CommentService;
import com.hniu.util.State;

import java.util.List;

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

	//------------------------------ 熊俊
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


	//查询课程评论
	@GetMapping("/comment/userComment/{curriculum_id}")
	public State<Object> selectComment(@PathVariable("curriculum_id")Integer curriculum_id){
		List<CommentDto> list = commentService.commentAndUser(curriculum_id);
		if (list.size()>=0){
			return packaging(com.hniu.constan.StateCode.SUCCESS,"评论查询成功",list);

		}else{
			return packaging(com.hniu.constan.StateCode.FAIL,"评论查询失败",null);
		}
	}

	//添加课程评论
	@PostMapping("/comment/wx_comment/{token}")
	public State<Object> wx_insertComment(@PathVariable("token")String token, Comment comment){
		if (StringUtils.isEmpty(comment)){
			return packaging(com.hniu.constan.StateCode.FAIL,"评论添加失败",null);
		}
		RedisUtil ru = new RedisUtil();
		String object = (String)ru.getObject(token);
		if(object==null){
			return packaging(com.hniu.constan.StateCode.FAIL,"此用户不存在",null);
		}
		String[] split = object.split(",");
		comment.setUserId(Integer.parseInt(split[2]));
		int i = commentService.insertComment(comment);
		if(i>0){
			return packaging(com.hniu.constan.StateCode.SUCCESS,"评论添加成功",null);
		}else{
			return packaging(com.hniu.constan.StateCode.FAIL,"评论添加失败",null);
		}
	}

	//修改课程评论
	@PutMapping("/comment/updatecomment/{comment_id}")
	public State<Object> updateComment(@PathVariable("comment_id")Integer comment_id, Comment comment){
		if(StringUtils.isEmpty(comment)){
			return packaging(com.hniu.constan.StateCode.FAIL,"课程修改失败",null);
		}
		comment.setCommentId(comment_id);
		int i = commentService.updateComment(comment);
		if(i>0){
			return packaging(com.hniu.constan.StateCode.SUCCESS,"课程修改成功",null);
		}
		return null;
	}

	//查询当前课程的评论数
	@GetMapping("/comment/selectCommentNum/{curriculum_id}")
	public State<Object> selectCommentNum(@PathVariable("curriculum_id")Integer curriculum_id){
		int i = commentService.selectCommentNum(curriculum_id);
		if(i>0){
			return packaging(com.hniu.constan.StateCode.SUCCESS,"评论数查询成功",i);
		}
		return null;
	}

	
}
