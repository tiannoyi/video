package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.AddCurriculum;
import com.hniu.entity.AddCurriculumExample;
import com.hniu.entity.Tution;
import com.hniu.entity.User;
import com.hniu.entity.vo.AddCurriculumVo;
import com.hniu.mapper.AddCurriculumMapper;
import com.hniu.mapper.TutionMapper;
import com.hniu.mapper.UserMapper;
import com.hniu.service.AddCurriculumService;
import com.hniu.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/10/14 10:59
 * @Description:
 * @Modified By:
 */
@Service
public class AddCurriculumServiceImpl implements AddCurriculumService {

    @Resource
    AddCurriculumMapper addCurriculumMapper;
    @Resource
    TutionMapper tutionMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public Page<AddCurriculumVo> AddCurriculumPage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<AddCurriculumVo> list = addCurriculumMapper.AddCurriculumAll();
        int countNums =addCurriculumMapper.count();
        Page<AddCurriculumVo> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(list);
        return pageData;
    }

    @Override
    public AddCurriculumVo selectAddCurriculum(Integer add_id) {

        return addCurriculumMapper.selectAddCurriculum(add_id);
    }

    @Override
    public Page<AddCurriculumVo> tutionId(Integer tution_id,Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<AddCurriculumVo> list = addCurriculumMapper.tutionId(tution_id);
        AddCurriculumExample example = new AddCurriculumExample();
        example.createCriteria().andTutionIdEqualTo(tution_id);
        int countNums =addCurriculumMapper.countByExample(example);
        Page<AddCurriculumVo> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(list);
        return pageData;
    }

    @Override
    public Page<AddCurriculumVo> userId(Integer user_id,Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<AddCurriculumVo> list = addCurriculumMapper.userId(user_id);
        AddCurriculumExample example = new AddCurriculumExample();
        example.createCriteria().andUserIdEqualTo(user_id);
        int countNums =addCurriculumMapper.countByExample(example);
        Page<AddCurriculumVo> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(list);
        return pageData;
    }

    @Override
    public int insertAddCurriculum(AddCurriculum addCurriculum) {
        User user = userMapper.selectByPrimaryKey(addCurriculum.getUserId());
        Tution tution = tutionMapper.selectByPrimaryKey(addCurriculum.getTutionId());
        if(StringUtils.isEmpty(user)||StringUtils.isEmpty(tution)){
            return 0;
        }
        addCurriculum.setStar(null);
        int i = addCurriculumMapper.insertSelective(addCurriculum);
        if(i>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int updateAddCurriculum(AddCurriculum addCurriculum) {
        addCurriculum.setUserId(null);
        addCurriculum.setTutionId(null);
        int i = addCurriculumMapper.updateByPrimaryKeySelective(addCurriculum);
        if(i>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteAddCurriculum(Integer add_id) {
        int i = addCurriculumMapper.deleteByPrimaryKey(add_id);
        if (i>0){
            return 1;
        }
        return 0;
    }
}
