package com.hniu.entity.vo;

import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.entity.Give;
import com.hniu.entity.Teacher;

/**
 * @Author: 熊俊
 * @Date: 2018/10/13 21:54
 * @Description:
 * @Modified By:
 */
public class GiveVo extends Give {
    private String teacher_name;

    private String curriculum_name;

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getCurriculum_name() {
        return curriculum_name;
    }

    public void setCurriculum_name(String curriculum_name) {
        this.curriculum_name = curriculum_name;
    }
}
