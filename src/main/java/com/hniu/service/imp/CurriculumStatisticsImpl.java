package com.hniu.service.imp;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hniu.constan.StateCode;
import com.hniu.controller.Base;
import com.hniu.entity.AddCurriculum;
import com.hniu.entity.Comment;
import com.hniu.entity.Comment_Extends;
import com.hniu.entity.CouresDetails;
import com.hniu.entity.CourseType;
import com.hniu.entity.CourseTypeExample;

import com.hniu.entity.Curriclum_Extends;
import com.hniu.entity.NavigationDetails;
import com.hniu.entity.Tution;
import com.hniu.entity.Video;
import com.hniu.mapper.AddCurriculumMapper;
import com.hniu.mapper.CommentMapper;
import com.hniu.mapper.CourseTypeMapper;
import com.hniu.mapper.CurriculumMapper;
import com.hniu.mapper.TutionMapper;
import com.hniu.mapper.VideoMapper;
import com.hniu.service.CurriculumStatisticsService;
import com.hniu.util.ChangliangUtil;
/*
 * 课程统计Service
 */
import com.hniu.util.State;

import javax.annotation.Resource;

/*
 * 邓志勇
 */
@Service
public  class CurriculumStatisticsImpl implements CurriculumStatisticsService {

	@Resource
	private CurriculumMapper curriculumMapper;
	
	@Resource
	private TutionMapper tutionMapper;
	
	@Resource
	private CourseTypeMapper courseTypeMapper;
	
	@Resource
	private CommentMapper CommentMapper;
	
	@Resource
	private VideoMapper videoMapper;
	
	@Resource
	private CommentMapper commentMapper;
	
	@Resource
	private AddCurriculumMapper addCurriculumMapper;
	
	public Base base=new Base();
	
	public StateCode StateCode;
	
	@Override
	public State<Object> getCurriculumStudyNum(Integer id) {
		Tution selectByPrimaryKey = tutionMapper.selectByPrimaryKey(id);
		if (selectByPrimaryKey != null) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.QUERYSUCCESS, selectByPrimaryKey);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, selectByPrimaryKey);
		}
	}

	@Override
	public State<Object> getCurrentStudyNum(Integer id) {
		Integer currentStudyNum = curriculumMapper.getCurrentStudyNum(id);
		if (currentStudyNum != null) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.QUERYSUCCESS, currentStudyNum);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, currentStudyNum);
		}
	}

	@Override
	public State<Object>  getCurriculumEvaluation(Integer id) {
		Integer curriculumEvaluation = curriculumMapper.getCurriculumEvaluation(id);
		if (curriculumEvaluation != null) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.QUERYSUCCESS, curriculumEvaluation);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, curriculumEvaluation);
		}
	}

	@Override
	public State<Object> insertcurriculum(CourseType courseType) {
		int insert = courseTypeMapper.insert(courseType);
		if (insert == 1) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.INSERTSUCCESS, insert);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.INSERTFAIL, insert);
		}
	}

	@Override
	public State<Object> getcurriculum(Integer id) {
		CourseType selectByPrimaryKey = courseTypeMapper.selectByPrimaryKey(id);
		if (selectByPrimaryKey != null) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.QUERYSUCCESS, selectByPrimaryKey);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, selectByPrimaryKey);
		}
	}

	@Override
	public State<Object> updatecurriculum(CourseType courseType) {
		int updateByPrimaryKey = courseTypeMapper.updateByPrimaryKey(courseType);
		if (updateByPrimaryKey == 1) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.UPDATESUCCESS, updateByPrimaryKey);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.UPDATEFAIL, updateByPrimaryKey);
		}
	}

	@Override
	public State<Object> deletecurriculum(Integer id) {
		int deleteByPrimaryKey = courseTypeMapper.deleteByPrimaryKey(id);
		if (deleteByPrimaryKey == 1) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.DELETESUCCESS, deleteByPrimaryKey);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.DELETEFAIL, deleteByPrimaryKey);
		}
	}

	
	/*
	 * (non-Javadoc)
	 * (auonth)DZY
	 * @see com.hniu.service.CurriculumStatisticsService#getCouresDetails()
	 * 2.课程名称，学校名称，教师名，课程介绍、课程寄语、预备知识、。。。
	 * 评分标准，已参与人数（开课表中该课程ID对应的参与人数之和）等。
	 */
	@Override
	public State<Object> getCouresDetails(Integer id) {
		CouresDetails couresDetails = curriculumMapper.getCouresDetails(id);
		if (couresDetails != null) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.QUERYSUCCESS, couresDetails);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, couresDetails);
		}
	}

	
	/*显示列出课程名称，评价内容，评价时间，及评价标星*/
	@Override
	public State<Object> getCommentInformation(Integer id) {
		Comment_Extends commentInformation = CommentMapper.getCommentInformation(id);
		if (commentInformation != null) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.QUERYSUCCESS, commentInformation);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, commentInformation);
		}
	}
    
	
	/*2.显示课程总的评价数和课程得分*/
	@Override
	public State<Object> getEvaluateNum(Integer id) {
		 Curriclum_Extends evaluateNum = CommentMapper.getEvaluateNum(id);
		if (evaluateNum != null) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.QUERYSUCCESS, evaluateNum);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL , evaluateNum);
		}
	}

	/*1.课程封面视频*/
	@Override
	public State<Object> getVideo(Integer id) {
		Video selectByPrimaryKey = videoMapper.selectByPrimaryKey(id);
		if (selectByPrimaryKey != null) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.QUERYSUCCESS, selectByPrimaryKey);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL , selectByPrimaryKey);
		}
	}

	
	/*1.针对课程发表评价，点赞，标星（5颗星）*/
	@Override
	public State<Object> insertComment(@RequestBody Comment comment) {
		comment.setCtime(new Date());
		int insert = commentMapper.insert(comment);
		if (insert == 1) {
			return base.packaging(StateCode.SUCCESS,ChangliangUtil.INSERTSUCCESS, insert);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.INSERTFAIL , insert);
		}
	}

	
	/*单击立即加入，用户可以学习课程*/
	@Override
	public State<Object> JoinTheCourseByid(Integer id) {
		System.out.println("课程的id是"+id);
		//根据课程di查询需要加入课程的信息
		CouresDetails couresDetails = curriculumMapper.JoinTheCourseByid(id);
		if (couresDetails.getTution_id() == null ||  couresDetails.getUser_id() == null || couresDetails.getScore() == null||
				couresDetails.getRequire()  == null) {
			 return base.packaging(StateCode.FAIL,"加入课程失败", null);
		}
		//创建一个需要添加课程的对象 将根据课程id查询出来的信息添加到开课表中
		AddCurriculum addCurriculum=new AddCurriculum();
		addCurriculum.setTutionId(couresDetails.getTution_id());
		addCurriculum.setUserId(couresDetails.getUser_id());
		addCurriculum.setCourseGrade(couresDetails.getScore());
		//addCurriculum.setIsQualified(couresDetails.getRequire());
		int i=addCurriculumMapper.insert(addCurriculum);
		if (i == 1) {
			return base.packaging(StateCode.SUCCESS,"加入课程成功", i);
		}else {
			return base.packaging(StateCode.FAIL, "加入课程失败" , i);
		}
	}
	
	
	/*
	 * (non-Javadoc) 将课程类别分页
	 * @see com.hniu.service.CurriculumStatisticsService#getCurriculumAll(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public State<Object> getCurriculumAll(Integer page, Integer rows){
		PageHelper.startPage(page,rows);
		List<Object> list=new ArrayList<>();
		CourseTypeExample example=new CourseTypeExample();	
		List<CourseType> listExample = courseTypeMapper.selectByExample(example);
		PageInfo info=new PageInfo<>(listExample);
		if (listExample != null && listExample.size() > 0) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, info);
		}else { 
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, info);
		}
	}

	/*3.导航显示详情，目录，教师团队，课程评价（其中目录数据来自该课程对应章节目录和 知识目录（二级数据））*/
	@Override
	public State<Object> getNavigationDetails(Integer id) {
		NavigationDetails at=curriculumMapper.getNavigationDetails(id);
		if (at != null) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, at);
		}return  base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, at);
		
	}

	@Override
	public State<Object> getFuzzyqueryCoures(String name) {
		List<CourseType> selectByExample = courseTypeMapper.getFuzzyqueryCoures(name);
		if (selectByExample.size() > 0 && selectByExample != null) {
			return base.packaging(StateCode.SUCCESS, ChangliangUtil.QUERYSUCCESS, selectByExample);
		}return  base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, selectByExample);
	}

	
	
}
