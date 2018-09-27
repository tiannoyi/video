package com.hniu.service;

import com.hniu.dto.TeacherDto;
import com.hniu.entity.Teacher;
import com.hniu.util.Page;

import java.util.List;

/**
 * @author 陈威
 */
public interface TeacherService {

    int insertTeacher(TeacherDto teacherDto);

    int updateTeacher(TeacherDto teacherDto);

    int deleteTeacher(int teacherId);

    Teacher selectTeacher(int teacherId);

    List<Teacher> listTeacher();

    //根据教师姓名进行模糊查询
    Page<Teacher> byName(String name, Integer currentPage, Integer pageSize);

}
