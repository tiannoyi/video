package com.hniu.dto;

import com.hniu.entity.Give;
import com.hniu.entity.Teacher;

import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/10/12 0:52
 * @Description:
 * @Modified By:
 */
public class GiveDto extends Give {
    private List<Teacher> teacher;

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }
}
