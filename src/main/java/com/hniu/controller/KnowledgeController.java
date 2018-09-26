package com.hniu.controller;

import com.hniu.constant.StateCode;
import com.hniu.entity.Knowledge;
import com.hniu.service.KnowledgeService;
import com.hniu.util.Page;
import com.hniu.util.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 熊俊
 * @Date: 2018/9/19 19:51
 * @Description:
 * @Modified By:
 */
@RestController
@RequestMapping("/Knowledge")
public class KnowledgeController extends Base {
    @Autowired
    KnowledgeService knowledgeService;


    //分页查询知识目录
    @GetMapping("/knowledgePage")
    public State<Object> selectKnowledgeList(Integer currentPage,Integer pageSize){
        if(currentPage==null||pageSize==null){
            return packaging(StateCode.FAIL,"请输入页数和总数",null);
        }
        Page<Knowledge> list = knowledgeService.selectKnowledgeList(currentPage, pageSize);
        if(list.getList().size()!=0){
            return packaging(StateCode.SUCCESS,"知识目录查询成功",list);
        }else{
            return packaging(StateCode.FAIL,"知识目录查询失败",null);
        }
    }

    //查询单个知识目录
    @GetMapping("/{knowledge_id}")
    public State<Object> selectKnowledge(@PathVariable("knowledge_id") Integer knowledge_id){
        Knowledge knowledge = knowledgeService.selectKnowledge(knowledge_id);
        return packaging(StateCode.SUCCESS,"知识目录查询成功",knowledge);
    }

    //添加知识目录
    @PostMapping()
    public State<Object> insertKnowledge(Knowledge knowledge){
        int i = knowledgeService.insertKnowledge(knowledge);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"知识目录添加成功",null);
        }else{
            return packaging(StateCode.FAIL,"知识目录添加失败",null);
        }
    }

    //修改知识目录
    @PutMapping("/{knowledge_id}")
    public State<Object> updateKnowledge(@PathVariable("knowledge_id") Integer knowledge_id,Knowledge knowledge){
        int i = knowledgeService.updateKnowledge(knowledge_id,knowledge);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"知识目录修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"知识目录修改失败",null);
        }
    }

    //删除知识目录
    @DeleteMapping("/{knowledge_id}")
    public State<Object> deleteKnowledge(@PathVariable("knowledge_id") int knowledge_id){
        int i = knowledgeService.deleteKnowledge(knowledge_id);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"知识目录删除成功",null);
        }else{
            return packaging(StateCode.FAIL,"知识目录删除失败",null);
        }
    }

}
