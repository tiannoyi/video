package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.Performance;
import com.hniu.entity.PerformanceExample;
import com.hniu.entity.Task;
import com.hniu.entity.User;
import com.hniu.entity.vo.PerformanceVo;
import com.hniu.mapper.PerformanceMapper;
import com.hniu.mapper.TaskMapper;
import com.hniu.mapper.UserMapper;
import com.hniu.service.PerformanceService;
import com.hniu.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/10/14 18:44
 * @Description:
 * @Modified By:
 */
@Service
public class PerformanceServiceImpl implements PerformanceService {
    @Resource
    PerformanceMapper performanceMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    TaskMapper taskMapper;

    @Override
    public Page<PerformanceVo> performancePage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<PerformanceVo> list = performanceMapper.PerformanceAll();
        int countNums = performanceMapper.count();
        Page<PerformanceVo> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(list);
        return pageData;
    }

    @Override
    public PerformanceVo selectPerformance(Integer performance_id) {
        return performanceMapper.selectPerformance(performance_id);
    }

    @Override
    public Page<PerformanceVo> userId(Integer user_id,Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        PerformanceExample example = new PerformanceExample();
        example.createCriteria().andUserIdEqualTo(user_id);
        int countNums = performanceMapper.countByExample(example);
        List<PerformanceVo> list = performanceMapper.userId(user_id);
        Page<PerformanceVo> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(list);
        return pageData;
    }

    @Override
    public List<PerformanceVo> userIdAndKnowledgeId(Integer user_id, Integer knowledge_id) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("user_id",user_id);
        map.put("knowledge_id",knowledge_id);
        return performanceMapper.userIdAndKnowledgeId(map);
    }

    @Override
    public int insertPerformance(Performance performance) {
        User user  = userMapper.selectByPrimaryKey(performance.getUserId());
        Task task = taskMapper.selectByPrimaryKey(performance.getTaskId());
        if (StringUtils.isEmpty(user)||StringUtils.isEmpty(task)){
            return  0;
        }
        int i = performanceMapper.insertSelective(performance);
        if(i>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePerformance(Performance performance) {
        performance.setTaskId(null);
        performance.setUserId(null);
        int i = performanceMapper.updateByPrimaryKeySelective(performance);
        if(i>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int deletePerformance(Integer performance_id) {
        int i = performanceMapper.deleteByPrimaryKey(performance_id);
        if(i>0){
            return 1;
        }
        return 0;
    }
}
