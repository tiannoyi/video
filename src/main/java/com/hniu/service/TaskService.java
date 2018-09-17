package com.hniu.service;

import com.hniu.entity.Task;

/**
 * 作业管理
 * @author 陈威
 */
public interface TaskService {
    int insertTask(Task task);

    int updateTask(Task task);

    int deleteTask(int taskId);

    Task queryTask(int taskId);
}
