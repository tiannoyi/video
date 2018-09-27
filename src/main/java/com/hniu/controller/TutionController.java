package com.hniu.controller;

import com.hniu.constant.StateCode;
import com.hniu.entity.Tution;
import com.hniu.service.TutionService;
import com.hniu.util.Page;
import com.hniu.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tution")
public class TutionController extends Base{

    @Autowired
    TutionService tutionService;


    //分页查询开课
    @GetMapping("/tutionPage")
    public State<Object> selectTutionList(Integer currentPage,Integer pageSize){
        if(currentPage==null||pageSize==null){
            return packaging(StateCode.FAIL,"请输入页数和总数",null);
        }
        Page<Tution> list = tutionService.selectTutionList(currentPage, pageSize);
        if(list.getList().size()!=0) {
            return packaging(StateCode.SUCCESS, "开课查询成功", list);
        }else{
            return packaging(StateCode.FAIL,"开课查询失败",null);
        }
    }

    //查询单个开课信息
    @GetMapping(value = "/{tution_id}")
    public State<Object> selectTution(@PathVariable("tution_id") Integer tution_id){
        Tution tution = tutionService.selectTution(tution_id);
        if(StringUtils.isEmpty(tution)){
            return packaging(StateCode.FAIL,"开课查询失败",null);
        }else{
            return packaging(StateCode.SUCCESS,"开课查询成功",tution);
        }

    }

    //添加课程信息
    @PostMapping()
    public State<Object> insertTution(Tution tution){
        int i = tutionService.insertTution(tution);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"开课信息添加成功",null);
        }else{
            return packaging(StateCode.FAIL,"开课信息添加失败",null);
        }
    }

    //修改开课信息
    @PutMapping(value = "/{tution_id}")
    public State<Object> updateTution(@PathVariable("tution_id") Integer tution_id,Tution tution){
        int i = tutionService.updateTution(tution_id, tution);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"开课信息修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"开课信息修改失败",null);
        }
    }

    //删除开课信息
    @DeleteMapping(value = "{tution_id}")
    public State<Object> deleteTution(@PathVariable("tution_id") Integer tution_id){
        int i  = tutionService.deleteTution(tution_id);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"开课信息删除成功",null);
        }else{
            return packaging(StateCode.FAIL,"开课信息删除成功",null);
        }
    }

    //根据课程id查询开课信息
    @GetMapping("/curriculum_id")
    public State<Object> byCurriculumId(Integer curriculum_id,Integer currentPage, Integer pageSize){
        if(curriculum_id == null ||currentPage==null||pageSize==null){
            return packaging(StateCode.FAIL,"请输入页数、总数、课程id",null);
        }
        Page<Tution> list = tutionService.byCurriculumId(curriculum_id, currentPage, pageSize);
        if (list.getList().size()>=0){
            return packaging(StateCode.SUCCESS,"开课信息查询成功",list);
        }else{
            return packaging(StateCode.FAIL,"开课信息查询失败",null);
        }
    }

}
