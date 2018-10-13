package com.hniu.service;

import com.hniu.dto.CommentDto;
import com.hniu.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hniu.entity.Comment;
import com.hniu.util.State;

import java.util.List;

@Repository
public interface CommentService {

	State<Object> getComment(Integer id);

	//删除课程评论
	int deleteComment(Integer comment_id);
//---------------------------
	//分页查询所有课程评论
	Page<Comment> commentPage(Integer currentPage, Integer pageSize);

	//查询课程评论
	Page<CommentDto> commentAndUser(Integer curriculum_id,Integer currentPage, Integer pageSize);

	//添加课程评论
	int insertComment(Comment comment);

	//修改课程评论
	int updateComment(Comment comment);

	//添加星标数
	int updateAsteriskNum(Integer asteriskNum);

	//查询当前课程的评论数
	Integer selectCommentNum(Integer curriculum_id);
}
