package com.hniu.service.imp;

import com.alibaba.druid.sql.visitor.functions.If;
import com.github.pagehelper.PageHelper;
import com.hniu.dto.CommentDto;
import com.hniu.entity.*;
import com.hniu.mapper.CurriculumMapper;
import com.hniu.mapper.UserMapper;
import com.hniu.util.Page;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hniu.constan.StateCode;
import com.hniu.controller.Base;
import com.hniu.mapper.CommentMapper;
import com.hniu.service.CommentService;
import com.hniu.util.ChangliangUtil;
import com.hniu.util.State;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/*
 * 查询评论controller
 * 邓志勇
 */

@Service
public class CommentServiceImpl implements CommentService{

	@Resource
    private CommentMapper commentmapper;
	@Resource
	CurriculumMapper curriculumMapper;
	@Resource
	UserMapper userMapper;
	
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

	@Override
	public Page<CommentDto> commentAndUser(Integer curriculum_id,Integer currentPage, Integer pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		List<CommentDto> list = commentmapper.commentAndUser(curriculum_id);
		int countNums = commentmapper.commentNum(curriculum_id);
		Page<CommentDto> pageData = new Page<>(currentPage,pageSize,countNums);
		pageData.setList(list);
		return pageData;
	}

	@Override
	public int insertComment(Comment comment) {
		CurriculumWithBLOBs curriculum = curriculumMapper.selectByPrimaryKey(comment.getCurriculumId());
		User user = userMapper.selectByPrimaryKey(comment.getUserId());
		if (StringUtils.isEmpty(curriculum)||StringUtils.isEmpty(user)){
			return 0;
		}
		comment.setAsteriskNum(null);
		int i = commentmapper.insertSelective(comment);
		if (i>0){
			return 1;
		}else{
			return 0;
		}

	}

	@Override
	public int updateComment(Comment comment) {
		comment.setAsteriskNum(null);
		int i = commentmapper.updateByPrimaryKeySelective(comment);
		if(i>0){
			return 1;
		}
		return 0;
	}

	@Override
	public int updateAsteriskNum(Integer asteriskNum) {
		Comment comment = new Comment();
		if (asteriskNum>5||asteriskNum<0){
			return 0;
		}
		comment.setAsteriskNum(asteriskNum);
		int i = commentmapper.updateByPrimaryKeySelective(comment);
		if(i>0){
			return 1;
		}
		return 0;
	}

	@Override
	public Integer selectCommentNum(Integer curriculum_id) {
		return commentmapper.commentNum(curriculum_id);
	}


}
