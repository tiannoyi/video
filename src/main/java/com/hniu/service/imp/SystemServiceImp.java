package com.hniu.service.imp;

import com.hniu.entity.System;
import com.hniu.entity.SystemExample;
import com.hniu.mapper.SystemMapper;
import com.hniu.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImp implements SystemService {
    @Autowired
    SystemMapper systemMapper;


    //查询系统信息
    @Override
    public System selectSystem() {
        SystemExample example = new SystemExample();
        example.setOrderByClause("sustem_id desc");
        System system = systemMapper.selectByExample(example).get(0);
        return system;
    }

    //修改系统信息
    @Override
    public int updateSystem(int system_id,System system) {
        system.setSustemId(system_id);
        int i = systemMapper.updateByPrimaryKeySelective(system);
        if(i != 0){
            return 1;
        }else {
            return 0;
        }
    }
}
