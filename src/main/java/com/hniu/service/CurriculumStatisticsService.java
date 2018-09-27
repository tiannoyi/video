package com.hniu.service;

import org.springframework.stereotype.Repository;
import com.hniu.entity.Comment;
import com.hniu.entity.CourseType;
import com.hniu.util.State;

@Repository
public interface CurriculumStatisticsService {
         
	State<Object> getCurriculumStudyNum(Integer id);

	//拿到当前学习人数有统计
	State<Object> getCurrentStudyNum(Integer id);

	//拿到课程评价记录条数
	State<Object> getCurriculumEvaluation(Integer id);

	
	/*
	 * 课程统计接口
	 */
	State<Object> insertcurriculum(CourseType courseType);

	State<Object> getcurriculum(Integer id);

	State<Object> updatecurriculum(CourseType courseType);

	State<Object> deletecurriculum(Integer id);
	
	
	
	/*
	 * 2.课程名称，学校名称，教师名，课程介绍、课程寄语、预备知识、。。。
	 * 评分标准，已参与人数（开课表中该课程ID对应的参与人数之和）等。
	 */
	State<Object> getCouresDetails(Integer id);

  	/*显示列出课程名称，评价内容，评价时间，及评价标星*/
	State<Object> getCommentInformation(Integer id);

	/*2.显示课程总的评价数和课程得分*/
	State<Object> getEvaluateNum(Integer id);

	//拿到视频地址
	State<Object> getVideo(Integer id);

	/*1.针对课程发表评价，点赞，标星（5颗星）*/
	State<Object> insertComment(Comment comment);

	/*单击立即加入，用户可以学习课程*/
	State<Object> JoinTheCourseByid(Integer id);

	/*分页*/
	State<Object> getCurriculumAll(Integer page, Integer rows);

	/*3.导航显示详情，目录，教师团队，课程评价（其中目录数据来自该课程对应章节目录和 知识目录（二级数据））*/
	State<Object> getNavigationDetails(Integer id);

	State<Object> getFuzzyqueryCoures(String name);

	
} 
