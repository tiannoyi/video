package com.hniu.service;

import com.hniu.entity.System;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface SystemService {
    //查询系统信息
    System selectSystem();
    //修改系统信息
    int updateSystem(int system_id,System system);
    //修改系统logo
    int updateSystemLogo(MultipartFile logo);
    //修改封面图片
    int updateSystemCover(MultipartFile cover);

}
