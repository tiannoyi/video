package com.hniu.mapper;

import com.hniu.dto.CommentDto;
import com.hniu.entity.Comment;
import com.hniu.entity.CommentExample;
import java.util.List;

import com.hniu.entity.Comment_Extends;
import com.hniu.entity.Curriclum_Extends;
import com.hniu.util.State;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    int countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    Comment_Extends getCommentInformation(@Param("id") Integer id);

    Curriclum_Extends getEvaluateNum(Integer id);

    //查询评论和用户
    List<CommentDto> commentAndUser(Integer curriculum_id);

    //查询当前课程评论数
    int commentNum(Integer curriculum_id);

}