package com.hniu.service;

import com.hniu.entity.Task;
import com.hniu.util.Page;

import java.util.List;

/**
 * 作业管理
 * @author 陈威
 */
public interface TaskService {
    int insertTask(Task task);

    int updateTask(Task task);

    int deleteTask(int taskId);

    Task queryTask(int taskId);

    //根据知识目录id查询作业信息
    List<Task> byKnowledgeId(Integer knowledge_id);

    //根据题干进行目录查询
    Page<Task> byStems(String stems,Integer currentPage, Integer pageSize);
}
