package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hniu.constan.StateCode;
import com.hniu.controller.Base;
import com.hniu.entity.Comment;
import com.hniu.entity.CommentExample;
import com.hniu.mapper.CommentMapper;
import com.hniu.service.CommentService;
import com.hniu.util.ChangliangUtil;
import com.hniu.util.State;

import java.util.List;

/*
 * 查询评论controller
 * 邓志勇
 */

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
    private CommentMapper commentmapper;
	
	public Base base=new Base();
	
	
	public StateCode StateCode;
	
	@Override
	public State<Object> getComment(Integer id) {
		Comment selectByPrimaryKey = commentmapper.selectByPrimaryKey(id);
		if (selectByPrimaryKey != null) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, id);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, id);
		}
	}

	@Override
	public int deleteComment(Integer comment_id) {
		int i = commentmapper.deleteByPrimaryKey(comment_id);
		if(i!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public Page<Comment> commentPage(Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		CommentExample example = new CommentExample();
		example.setOrderByClause("comment_id desc");
		List<Comment> allComment = commentmapper.selectByExample(example);
		int countNums = commentmapper.countByExample(example);
		Page<Comment> pageData = new Page<>(currentPage,pageSize,countNums);
		pageData.setList(allComment);
		return pageData;
	}


}
