package com.hniu.service;

import com.hniu.dto.TeacherDto;
import com.hniu.entity.Teacher;

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
}
