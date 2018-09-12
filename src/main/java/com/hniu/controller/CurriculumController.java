package com.hniu.controller;

import com.hniu.constant.StateCode;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.service.CurriculumService;
import com.hniu.util.Page;
import com.hniu.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//课程基本设置管理
@RestController
@RequestMapping("/curriculum")
public class CurriculumController extends Base{
    @Autowired
    CurriculumService curriculumService;

    //分页查询所有课程信息

    @GetMapping("/curriculumPage")
    public State<Object> selectCurriculumList(Integer currentPage,Integer pageSize){
        if (currentPage==null||pageSize==null){
            return packaging(StateCode.FAIL,"请输入页数和总数",null);
        }
        Page<CurriculumWithBLOBs> list = curriculumService.selectCurriculumList(currentPage,pageSize);
        if(list.getList().size()!=0){
            return packaging(StateCode.SUCCESS,"课程信息查询成功",list);
        }else{
            return packaging(StateCode.FAIL,"课程信息查询失败",null);
        }

    }

    //查询单个课程信息
    @GetMapping(value = "/{curriculum_id}")
    public State<Object> selectCurriculum(@PathVariable("curriculum_id") int curriculum_id){
        CurriculumWithBLOBs curriculum = curriculumService.selectCurriculum(curriculum_id);
        if(StringUtils.isEmpty(curriculum)){
            return packaging(StateCode.FAIL,"课程信息查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"课程信息查询成功",curriculum);
        }
    }

    //添加课程信息
    @PostMapping()
    public State<Object> inputCurriculum(CurriculumWithBLOBs curriculum){
        int i = curriculumService.inputCurriculum(curriculum);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"课程添加成功",null);
        }else{
            return packaging(StateCode.FAIL,"课程添加失败",null);
        }

    }

    //修改课程信息
    @PutMapping(value = "/{curriculum_id}")
    public State<Object> updateCurriculum(@PathVariable("curriculum_id") int curriculum_id,CurriculumWithBLOBs curriculum){
        int i = curriculumService.updateCurriculum(curriculum_id,curriculum);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"课程修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"课程修改失败",null);
        }
    }

    //删除课程信息
    @DeleteMapping(value = "/{curriculum_id}")
    public State<Object> DeleteCurriculum(@PathVariable("curriculum_id") int curriculum_id){
        int i = curriculumService.deleteCurriculum(curriculum_id);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"课程删除成功",null);
        }else{
            return packaging(StateCode.FAIL,"课程删除失败",null);
        }
    }


}
