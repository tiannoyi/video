package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.*;
import com.hniu.mapper.*;
import com.hniu.service.KnowledgeService;
import com.hniu.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/9/19 19:52
 * @Description:
 * @Modified By:
 */

@Service
public class KnowledgeServiceImp implements KnowledgeService {
    @Resource
    KnowledgeMapper knowledgeMapper;
    @Resource
    ChapterMapper chapterMapper;
    @Resource
    TaskMapper taskMapper;
    @Resource
    ArticleMapper articleMapper;
    @Resource
    VideoMapper videoMapper;

    @Override
    public Page<Knowledge> selectKnowledgeList(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        KnowledgeExample example = new KnowledgeExample();
        example.setOrderByClause("knowledge_id");
        List<Knowledge> allKnowledge = knowledgeMapper.selectByExample(example);
        int countNums = knowledgeMapper.count();
        Page<Knowledge> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allKnowledge);
        return pageData;
    }

    @Override
    public Knowledge selectKnowledge(Integer knowledge_id) {
        return knowledgeMapper.selectByPrimaryKey(knowledge_id);
    }

    @Override
    public int insertKnowledge(Knowledge knowledge) {
        Chapter chapter = chapterMapper.selectByPrimaryKey(knowledge.getChapterId());
        if (StringUtils.isEmpty(chapter)){
            return 0;
        }
        int i = knowledgeMapper.insert(knowledge);
        if(i!=0){
            return 1;
        }else{
            return 0;
        }

    }

    @Override
    public int updateKnowledge(Integer knowledge_id, Knowledge knowledge) {
        knowledge.setKnowledgeId(knowledge_id);
        int i = knowledgeMapper.updateByPrimaryKeySelective(knowledge);
        if(i != 0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int deleteKnowledge(Integer knowledge_Id) {
        VideoExample videoexample = new VideoExample();
        videoexample.createCriteria().andKnowledgeIdEqualTo(knowledge_Id);
        List<Video> list = videoMapper.selectByExample(videoexample);

        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andKnowledgeIdEqualTo(knowledge_Id);
        List<Article> list1 = articleMapper.selectByExample(articleExample);

        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andKnowledgeIdEqualTo(knowledge_Id);
        List<Task> list2 =taskMapper.selectByExample(taskExample);

        if (list.size()>0||list1.size()>0||list2.size()>0){
            return 0;
        }

        int i = knowledgeMapper.deleteByPrimaryKey(knowledge_Id);
        if(i != 0){
            return  1;
        }{
            return 0;
        }

    }

    @Override
    public List<Knowledge> byChapterId(Integer chapterId) {
        KnowledgeExample example = new KnowledgeExample();
        example.createCriteria().andChapterIdEqualTo(chapterId);
        List<Knowledge> list = knowledgeMapper.selectByExample(example);
        return list;
    }

    @Override
    public Page<Knowledge> bySummaryName(String summaryName, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        KnowledgeExample example = new KnowledgeExample();
        summaryName = "%" + summaryName + "%";
        example.createCriteria().andSummaryNameLike(summaryName);
        int countNums = knowledgeMapper.countByExample(example);
        List<Knowledge> allKnowLege = knowledgeMapper.selectByExample(example);
        Page<Knowledge>  pageData  = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allKnowLege);
        return pageData;
    }
}
