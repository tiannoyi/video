package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.Knowledge;
import com.hniu.entity.KnowledgeExample;
import com.hniu.mapper.KnowledgeMapper;
import com.hniu.service.KnowledgeService;
import com.hniu.util.Page;
import org.springframework.stereotype.Service;

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
