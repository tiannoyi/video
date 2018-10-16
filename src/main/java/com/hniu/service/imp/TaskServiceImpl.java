package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.*;
import com.hniu.mapper.KnowledgeMapper;
import com.hniu.mapper.PerformanceMapper;
import com.hniu.mapper.TaskMapper;
import com.hniu.service.TaskService;
import com.hniu.util.Page;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.awt.SunHints;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 陈威
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Resource
    PerformanceMapper performanceMapper;

    @Resource
    KnowledgeMapper knowledgeMapper;

    @Override
    public int insertTask(Task task) {
        Knowledge knowledge = knowledgeMapper.selectByPrimaryKey(task.getKnowledgeId());
        if(StringUtils.isEmpty(knowledge)){
            return 0;
        }
        return taskMapper.insertSelective(task);
    }

    @Override
    public int updateTask(Task task) {
        return taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public int deleteTask(int taskId) {
        PerformanceExample example = new PerformanceExample();
        example.createCriteria().andTaskIdEqualTo(taskId);
        List<Performance> list = performanceMapper.selectByExample(example);
        if (list.size()>0){
            return 0;
        }
        return taskMapper.deleteByPrimaryKey(taskId);
    }

    @Override
    public Task queryTask(int taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }

    @Override
    public List<Task> byKnowledgeId(Integer knowledge_id) {
        TaskExample example = new TaskExample();
        example.createCriteria().andKnowledgeIdEqualTo(knowledge_id);
        return taskMapper.selectByExample(example);
    }

    @Override
    public Page<Task> byStems(String stems, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        TaskExample example = new TaskExample();
        stems = "%" + stems+"%";
        example.createCriteria().andStemsLike(stems);
        int countNums = taskMapper.countByExample(example);
        List<Task> allTask = taskMapper.selectByExample(example);
        Page<Task> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allTask);
        return pageData;
    }
}
