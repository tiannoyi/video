package com.hniu.controller;
import com.hniu.constan.StateCode;
import com.hniu.service.SystemService;
import com.hniu.entity.System;
import com.hniu.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//系统设置
@RestController
@RequestMapping("/system")
public class SystemController extends Base{

    @Autowired
    SystemService systemService;

    //查询系统信息
    @GetMapping()
    public State<Object> selectSystem(){
        System system = systemService.selectSystem();
        if(StringUtils.isEmpty(system)){
            return packaging(StateCode.FAIL,"查询系统信息失败",null);
        }else{
            return packaging(StateCode.SUCCESS,"查询成功",system);
        }
    }

    //修改系统数据
    @PutMapping("/{sustem_id}")
    public State<Object> updateSystem(@PathVariable("sustem_id") int system_id,System system){
        int i = systemService.updateSystem(system_id,system);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"修改系统数据成功",null);
        }else{
            return packaging(StateCode.FAIL,"修改系统数据失败",null);
        }
    }

    //修改系统logo
    @RequestMapping("updateLogo")
    public State<Object> updateSystemLogo(MultipartFile logo){
            int i = systemService.updateSystemLogo(logo);
            if(i != 0) {
                return packaging(StateCode.SUCCESS, "系统logo修改成功", null);
            }else {
                return packaging(StateCode.FAIL,"系统logo修改失败",null);
            }
    }

    //修改封面图片
    @RequestMapping("updateCover")
    public State<Object> updateCover(MultipartFile cover){
        int i = systemService.updateSystemCover(cover);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"封面图片修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"封面图片修改失败",null);
        }

    }
}
