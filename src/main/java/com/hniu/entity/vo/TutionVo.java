package com.hniu.entity.vo;

import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.entity.Tution;

import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/10/11 14:19
 * @Description:
 * @Modified By:
 */
public class TutionVo extends Tution {
    private List<CurriculumWithBLOBs> curriculum;

    public List<CurriculumWithBLOBs> getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(List<CurriculumWithBLOBs> curriculum) {
        this.curriculum = curriculum;
    }
}
