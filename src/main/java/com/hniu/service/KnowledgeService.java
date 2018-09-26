package com.hniu.service;

import com.hniu.entity.Knowledge;
import com.hniu.util.Page;

import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/9/19 19:52
 * @Description:
 * @Modified By:
 */
public interface KnowledgeService {
    //分页查询知识目录
    Page<Knowledge> selectKnowledgeList(Integer currentPage,Integer pageSize);

    //查询单个知识目录
    Knowledge selectKnowledge(Integer knowledge_id);

    //添加知识目录
    int insertKnowledge(Knowledge knowledge);

    //修改知识目录
    int updateKnowledge(Integer knowledge_id,Knowledge knowledge);

    //删除知识目录
    int deleteKnowledge(Integer knowledge_Id);

    //根据章节id查询知识目录
    List<Knowledge> byChapterId(Integer chapterId);

    //根据小结名称模糊查询知识目录
    Page<Knowledge> bySummaryName(String summaryName,Integer currentPage,Integer pageSize);
}
