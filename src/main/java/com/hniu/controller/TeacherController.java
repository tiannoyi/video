package com.hniu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hniu.constant.StateCode;
import com.hniu.dto.TeacherDto;
import com.hniu.entity.Teacher;
import com.hniu.service.TeacherService;
import com.hniu.util.Page;
import com.hniu.util.State;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教师管理
 * @author 陈威
 */
@RestController
@RequestMapping(value="/teacher")
public class TeacherController extends Base {
    @Resource()
    private TeacherService teacherService;

    /**
     * 分页查询教师信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/page")
    public State<Object> selectTeacherList(Integer pageNum,Integer pageSize){

        PageHelper.startPage(pageNum,pageSize);
        List<Teacher> teachers = teacherService.listTeacher();
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        if(teachers.size()!=0){
            return packaging(StateCode.SUCCESS,"教师信息查询成功",pageInfo);
        }else{
            return packaging(StateCode.FAIL,"教师信息查询失败",null);
        }

    }

    /**
     * 根据id查看教师信息
     * @param teacherId
     * @return
     */
    @GetMapping(value = "/{teacherId}")
    public State<Object> selectTeacher(@PathVariable("teacherId") int teacherId){
        Teacher teacher = teacherService.selectTeacher(teacherId);
        if(StringUtils.isEmpty(teacher)){
            return packaging(StateCode.FAIL,"教师信息查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"教师信息查询成功",teacher);
        }
    }

    /**
     * 添加教师
     * @param teacherDto
     * @return base
     */
    @PostMapping(value = "")
    public State<Object> insertTeacher(TeacherDto teacherDto){
        int i = teacherService.insertTeacher(teacherDto);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"教师添加成功",null);
        }else{
            return packaging(StateCode.FAIL,"教师添加失败",null);
        }

    }

    /**
     *修改教师信息
     * @param teacher
     * @return
     */
    @PostMapping(value = "/update")
    public State<Object> updateTeacher(TeacherDto teacher){
        int i = teacherService.updateTeacher(teacher);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"教师修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"教师修改失败",null);
        }
    }

    /**
     * 根据教师id删除教师
     * @param teacherId
     * @return
     */
    @DeleteMapping(value = "/{teacherId}")
    public State<Object> deleteTeacher(@PathVariable("teacherId") int teacherId){
        int i = teacherService.deleteTeacher(teacherId);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"教师删除成功",null);
        }else{
            return packaging(StateCode.FAIL,"教师删除失败",null);
        }
    }

    //根据教师姓名进行模糊查询
    @GetMapping("/name")
    public State<Object> byName(String name, Integer currentPage, Integer pageSize){
        Page<Teacher> list = teacherService.byName(name, currentPage, pageSize);
        if(list.getList().size()>=0){
            return packaging(StateCode.SUCCESS,"教师查询成功",list);
        }else{
            return packaging(StateCode.FAIL,"教师查询失败",null);
        }
    }

}
