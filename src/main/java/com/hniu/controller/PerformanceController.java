package com.hniu.controller;

import com.hniu.constan.StateCode;
import com.hniu.entity.Performance;
import com.hniu.entity.vo.PerformanceVo;
import com.hniu.service.PerformanceService;
import com.hniu.util.Page;
import com.hniu.util.RedisUtil;
import com.hniu.util.State;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/10/14 18:42
 * @Description:
 * @Modified By:
 */
@RestController
@RequestMapping("/performance")
public class PerformanceController extends Base{
    @Autowired
    PerformanceService performanceService;
    @Autowired
    RedisUtil redisUtil;

    //分页查询所有题目成绩
    @GetMapping("/performancePage")
    public State<Object> performancePage(Integer currentPage, Integer pageSize){
        if (currentPage==null||pageSize==null){
            return packaging(StateCode.FAIL,"请输入页数和总数",null);
        }
        Page<PerformanceVo> list = performanceService.performancePage(currentPage, pageSize);
        if(list.getList().size()>0){
            return packaging(StateCode.SUCCESS,"查询成功",list);
        }
        return packaging(StateCode.FAIL,"查询失败",null);
    }

    //根据id查询题目成绩
    @GetMapping("/{performance_id}")
    public State<Object> selectPerformance(@PathVariable("performance_id")Integer performance_id){
        PerformanceVo performanceVo = performanceService.selectPerformance(performance_id);
        if (!StringUtils.isEmpty(performanceVo)){
            return packaging(StateCode.SUCCESS,"查询成功",performanceVo);
        }
        return packaging(StateCode.FAIL,"查询失败",null);
    }

    //根据用户id查询成绩信息
    @GetMapping("/userId/{user_id}")
    public State<Object> userId(@PathVariable("user_id")Integer user_id,Integer currentPage, Integer pageSize){
        if (currentPage==null||pageSize==null){
            return packaging(StateCode.FAIL,"请输入页数和总数",null);
        }
        Page<PerformanceVo> list = performanceService.userId(user_id, currentPage, pageSize);
        if(list.getList().size()>0){
            return packaging(StateCode.SUCCESS,"查询成功",list);
        }
        return packaging(StateCode.FAIL,"查询失败",null);
    }

    //微信端根据用户id查询成绩信息
    @GetMapping("/wx_userId/{token}")
    public State<Object> wx_userId(@PathVariable("token")String token,Integer currentPage, Integer pageSize){
        if (currentPage==null||pageSize==null){
            return packaging(StateCode.FAIL,"请输入页数和总数",null);
        }
        String object = (String)redisUtil.getObject(token);
        if(object == null){
            return packaging(StateCode.FAIL,"查询失败",null);
        }
        String[] split = object.split(",");
        Integer user_id = Integer.parseInt(split[2]);
        Page<PerformanceVo> list = performanceService.userId(user_id, currentPage, pageSize);
        if(list.getList().size()>0){
            return packaging(StateCode.SUCCESS,"查询成功",list);
        }
        return packaging(StateCode.FAIL,"查询失败",null);
    }

    //根据知识目录（小结id）和用户id查询成绩信息
    @GetMapping("/userIdAndKnowledgeId")
    public State<Object> userIdAndKnowledgeId(Integer user_id,Integer knowledge_id){

        List<PerformanceVo> list = performanceService.userIdAndKnowledgeId(user_id, knowledge_id);
        if (list.size()>0){
            return packaging(StateCode.SUCCESS,"查询成功",list);
        }
        return packaging(StateCode.FAIL,"查询失败",null);
    }

    //微信端根据知识目录（小结id）和用户id查询成绩信息
    @GetMapping("/wx_userIdAndKnowledgeId/{token}")
    public State<Object> wx_userIdAndKnowledgeId(@PathVariable("token")String token,Integer knowledge_id){
        String object = (String)  redisUtil.getObject(token);
        if(object == null){
            return packaging(StateCode.FAIL,"查询失败",null);
        }
        String[] split = object.split(",");
        Integer user_id = Integer.parseInt(split[2]);
        List<PerformanceVo> list = performanceService.userIdAndKnowledgeId(user_id, knowledge_id);
        if (list.size()>0){
            return packaging(StateCode.SUCCESS,"查询成功",list);
        }
        return packaging(StateCode.FAIL,"查询失败",null);
    }




    //添加成绩
    @PostMapping()
    public State<Object> insertPerformance(Performance performance){
        if(StringUtils.isEmpty(performance)){
            return packaging(StateCode.FAIL,"添加失败",null);
        }
        int i = performanceService.insertPerformance(performance);
        if(i>0){
            return packaging(StateCode.SUCCESS,"添加成功",null);
        }
        return packaging(StateCode.FAIL,"添加失败",null);
    }

    //微信添加成绩
    @PostMapping("/wx_insertPerformance/{token}")
    public State<Object>wx_insertPerformance(@PathVariable("token")String token, Performance performance){
        if(StringUtils.isEmpty(performance)){
            return packaging(StateCode.FAIL,"添加失败",null);
        }
        String object = (String)redisUtil.getObject(token);
        if(object == null){
            return packaging(StateCode.FAIL,"查询失败",null);
        }
        String[] split = object.split(",");
        Integer user_id = Integer.parseInt(split[2]);
        performance.setUserId(user_id);
        int i = performanceService.insertPerformance(performance);
        if(i>0){
            return packaging(StateCode.SUCCESS,"添加成功",null);
        }
        return packaging(StateCode.FAIL,"添加失败",null);
    }


    //修改成绩
    @PutMapping()
    public State<Object> updatePerformance(Performance performance){
        if(StringUtils.isEmpty(performance)){
            return packaging(StateCode.FAIL,"修改失败",null);
        }
        int i = performanceService.updatePerformance(performance);
        if(i>0){
            return packaging(StateCode.SUCCESS,"修改成功",null);
        }
        return packaging(StateCode.FAIL,"修改失败",null);
    }


    //删除成绩
    @DeleteMapping("{performance_id}")
    public State<Object> deletePerformance(@PathVariable("performance_id")Integer performance_id){
        int i = performanceService.deletePerformance(performance_id);
        if(i>0){
            return  packaging(StateCode.SUCCESS,"删除成功",null);
        }
        return packaging(StateCode.FAIL,"删除失败",null);
    }

}
