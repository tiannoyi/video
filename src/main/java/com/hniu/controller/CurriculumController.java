package com.hniu.controller;

import com.hniu.constant.StateCode;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.service.CurriculumService;
import com.hniu.util.Page;
import com.hniu.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
            return packaging(StateCode.SUCCESS,"课程信息查询成功",curriculum);

    }

    //添加课程信息
    @PostMapping()
    public State<Object> inputCurriculum(CurriculumWithBLOBs curriculum){
        curriculum.setPicture(null);
        curriculum.setVideo(null);
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
        curriculum.setVideo(null);
        curriculum.setPicture(null);
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

    //修改课程封面图片
    @RequestMapping("/curriculumPicture")
    public State<Object> updateCurriculumPicture(Integer curriculumId, MultipartFile curriculumPicture){
        int i = curriculumService.updateCurriculumPicture(curriculumId, curriculumPicture);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"课程封面修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"课程封面修改失败",null);
        }
    }

    //修改系统封面图片
    @RequestMapping("/curriculumVideoPicture")
    public State<Object> updateCurriculumVideoPicture(Integer curriculumId,MultipartFile curriculumVideoPicture){
        int i = curriculumService.updateCurriculumVideoPicture(curriculumId, curriculumVideoPicture);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"视频封面修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"视频封面修改失败",null);
        }
    }


    //根据学校id查询课程信息
    @GetMapping("/university_id")
    public State<Object> byUniversityId(Integer university_id,Integer currentPage, Integer pageSize){
        if (currentPage==null||pageSize==null||university_id==null){
            return packaging(StateCode.FAIL,"请输入页数、总数、课程名",null);
        }
        Page<CurriculumWithBLOBs> list =curriculumService.bySchoolId(university_id, currentPage, pageSize);
        if(list.getList().size()>=0){
            return packaging(StateCode.SUCCESS,"课程信息查询成功",list);
        }else{
            return packaging(StateCode.FAIL,"课程信息查询失败",null);
        }
    }

    //根据类别id查询课程信息
    @GetMapping("/ct_id")
    public State<Object> byCtId(Integer ct_id,Integer currentPage, Integer pageSize){
        if (currentPage==null||pageSize==null||ct_id==null){
            return packaging(StateCode.FAIL,"请输入页数、总数、类别id",null);
        }
        Page<CurriculumWithBLOBs> list =curriculumService.byCtId(ct_id, currentPage, pageSize);
        if(list.getList().size()>=0){
            return packaging(StateCode.SUCCESS,"课程信息查询成功",list);
        }else{
            return packaging(StateCode.FAIL,"课程信息查询失败",null);
        }
    }


    //根据课程名模糊查询课程信息
    @GetMapping("/name")
    public State<Object> byName(String name,Integer currentPage,Integer pageSize){
        if (currentPage==null||pageSize==null||name==null){
            return packaging(StateCode.FAIL,"请输入页数、总数、课程名",null);
        }
        Page<CurriculumWithBLOBs> list =curriculumService.byName(name, currentPage, pageSize);
        if(list.getList().size()>=0){
            return packaging(StateCode.SUCCESS,"课程信息查询成功",list);
        }else{
            return packaging(StateCode.FAIL,"课程信息查询失败",null);
        }
    }



}
