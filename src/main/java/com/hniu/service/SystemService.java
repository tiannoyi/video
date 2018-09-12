package com.hniu.service;

import com.hniu.entity.System;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemService {
    //查询系统信息
    System selectSystem();
    //修改系统信息
    int updateSystem(int system_id,System system);

}
