package com.hniu.controller;

import com.hniu.constant.StateCode;
import com.hniu.entity.Task;
import com.hniu.service.TaskService;
import com.hniu.util.State;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 陈威
 */
@RestController
@RequestMapping(value = "/task")
public class TaskController extends Base{
    @Resource
    private TaskService taskService;



    /**
     * 根据id查看作业信息
     * @param taskId
     * @return
     */
    @GetMapping(value = "/{taskId}")
    public State<Object> selectCurriculum(@PathVariable("taskId") int taskId){
        Task Task = taskService.queryTask(taskId);
        if(StringUtils.isEmpty(Task)){
            return packaging(StateCode.FAIL,"作业信息查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"作业信息查询成功",Task);
        }
    }

    /**
     * 添加作业
     * @param task
     * @return base
     */
    @PostMapping()
    public State<Object> inputCurriculum(Task task){
        int i = taskService.insertTask(task);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"作业添加成功",null);
        }else{
            return packaging(StateCode.FAIL,"作业添加失败",null);
        }

    }

    /**t
     *修改作业信息
     * @param task
     * @return
     */
    @PutMapping(value = "")
    public State<Object> updateCurriculum(Task task){
        int i = taskService.updateTask(task);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"作业修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"作业修改失败",null);
        }
    }

    /**
     * 根据作业id删除作业
     * @param taskId
     * @return
     */
    @DeleteMapping(value = "/{taskId}")
    public State<Object> DeleteCurriculum(@PathVariable("taskId") int taskId){
        int i = taskService.deleteTask(taskId);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"作业删除成功",null);
        }else{
            return packaging(StateCode.FAIL,"作业删除失败",null);
        }
    }
}
