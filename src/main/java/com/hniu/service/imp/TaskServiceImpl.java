package com.hniu.service.imp;

import com.hniu.entity.Task;
import com.hniu.mapper.TaskMapper;
import com.hniu.service.TaskService;
import org.springframework.stereotype.Service;
import sun.awt.SunHints;

import javax.annotation.Resource;

/**
 * @author 陈威
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Resource()
    private TaskMapper taskMapper;

    @Override
    public int insertTask(Task task) {
        return taskMapper.insertSelective(task);
    }

    @Override
    public int updateTask(Task task) {
        return taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public int deleteTask(int taskId) {
        return taskMapper.deleteByPrimaryKey(taskId);
    }

    @Override
    public Task queryTask(int taskId) {
        return taskMapper.selectByPrimaryKey(taskId);
    }
}
