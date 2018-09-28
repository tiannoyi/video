package com.hniu.service.imp;

import com.hniu.entity.System;
import com.hniu.entity.SystemExample;
import com.hniu.mapper.SystemMapper;
import com.hniu.service.SystemService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Service()
public class SystemServiceImp implements SystemService {
    @Resource
    SystemMapper systemMapper;

    @Value("${web.logoPath}")
    private String adSystemLogoPath;

    @Value("${web.coverPath}")
    private String adSystemCoverPath;

    @Value("${web.videoPath}")
    private String coverPath;

    @Value("${web.videoPath}")
    private String logoPath;



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
        system.setSystemLogo(null);
        system.setCover(null);
        int i = systemMapper.updateByPrimaryKeySelective(system);
        if(i != 0){
            return 1;
        }else {
            return 0;
        }
    }


    private String getString(String endString, String s) {
        if(s.contains(".gif")){
            endString = ".gif";
        }else if(s.contains(".png")){
            endString = ".png";
        }else if(s.contains(".jpg")){
            endString = ".jpg";
        }
        return endString;
    }

    //修改系统logo
    @Override
    public int updateSystemLogo(MultipartFile logo) {

        String endString = null;
        System system = systemMapper.selectByPrimaryKey(1);
        if(!StringUtils.isEmpty(system)) {
            String s = system.getSystemLogo();
            endString = getString(endString, s);
            String s1 = s.substring(s.indexOf("video/") + 6, s.indexOf(endString));
            File file = new File(adSystemLogoPath+s1+endString);
            file.delete();
        }
        if(logo!=null&&logo.getSize()>0){
            String fileName = java.lang.System.currentTimeMillis()+"_"+logo.getOriginalFilename();
            File file = new File(adSystemLogoPath+fileName);
            File fileFolder = new File(adSystemLogoPath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try{
                logo.transferTo(file);
                String logo1 = logoPath+fileName;
                System s = new System();
                s.setSustemId(1);
                s.setSystemLogo(logo1);
                return systemMapper.updateByPrimaryKeySelective(s);
            }catch (IOException e){
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    //修改封面图片
    @Override
    public int updateSystemCover(MultipartFile cover) {
        String endString = null;
        System system = systemMapper.selectByPrimaryKey(1);
        if(!StringUtils.isEmpty(system)) {
            String s = system.getCover();
            endString = getString(endString, s);
            String s1 = s.substring(s.indexOf("video/") + 6, s.indexOf(endString));
            File file = new File(adSystemCoverPath+s1+endString);
            file.delete();
        }
        if(cover != null&&cover.getSize()>0){
            String fileName = java.lang.System.currentTimeMillis()+"_"+cover.getOriginalFilename();
            File file = new File(adSystemCoverPath+fileName);
            File fileFolder = new File(adSystemCoverPath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try{
                cover.transferTo(file);
                String cover1 = coverPath+fileName;
                System s = new System();
                s.setSustemId(1);
                s.setCover(cover1);
                return systemMapper.updateByPrimaryKeySelective(s);
            }catch (IOException e){
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }


}
