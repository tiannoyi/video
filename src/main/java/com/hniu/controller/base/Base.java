package com.hniu.controller.base;


import com.hniu.constan.StateCode;
import com.hniu.entity.wrap.State;


public class Base {

    /**
     * 状态包装
     */
    public Object packaging(StateCode stateCode, Object data) {
        return new State(stateCode.getState(), stateCode.getMessage(), data);
    }
}
