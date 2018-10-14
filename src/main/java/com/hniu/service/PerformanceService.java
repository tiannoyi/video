package com.hniu.service;

import com.hniu.entity.Performance;
import com.hniu.entity.vo.PerformanceVo;
import com.hniu.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/10/14 18:43
 * @Description:
 * @Modified By:
 */
@Repository
public interface PerformanceService {
    //分页查询所有成绩
    Page<PerformanceVo> performancePage(Integer currentPage, Integer pageSize);

    //根据成绩id查询成绩
    PerformanceVo selectPerformance(Integer performance_id);

    //根据用户id查询成绩
    Page<PerformanceVo> userId(Integer user_id, Integer currentPage, Integer pageSize);

    //
    List<PerformanceVo> userIdAndKnowledgeId(Integer user_id,Integer knowledge_id);
    //添加成绩
    int insertPerformance(Performance performance);

    //修改成绩
    int updatePerformance(Performance performance);

    //删除成绩
    int deletePerformance(Integer performance_id);

}
