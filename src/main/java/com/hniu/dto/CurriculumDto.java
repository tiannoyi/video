package com.hniu.dto;

import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.entity.Tution;

/**
 * @Author: 熊俊
 * @Date: 2018/10/11 14:34
 * @Description:
 * @Modified By:
 */
public class CurriculumDto  extends CurriculumWithBLOBs {

    private Tution tution;

    public Tution getTution() {
        return tution;
    }

    public void setTution(Tution tution) {
        this.tution = tution;
    }
}
