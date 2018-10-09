package com.hniu.service;

import com.hniu.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hniu.entity.Comment;
import com.hniu.util.State;

@Repository
public interface CommentService {

	State<Object> getComment(Integer id);

	//删除课程评论
	int deleteComment(Integer comment_id);

	//分页查询所有课程评论
	Page<Comment> commentPage(Integer currentPage, Integer pageSize);

}
