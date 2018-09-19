package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.CurriculumExample;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.entity.Tution;
import com.hniu.entity.TutionExample;
import com.hniu.mapper.CurriculumMapper;
import com.hniu.mapper.TutionMapper;
import com.hniu.service.TutionService;
import com.hniu.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TutionServiceImp implements TutionService {
    @Resource
    TutionMapper tutionMapper;
    @Resource
    CurriculumMapper curriculumMapper;


    @Override
    public Page<Tution> selectTutionList(Integer currentPage, Integer pageSize) {

        PageHelper.startPage(currentPage,pageSize);
        TutionExample example = new TutionExample();
        example.setOrderByClause("tution_id desc");
        List<Tution> allTution = tutionMapper.selectByExample(example);
        int countNums = tutionMapper.count();
        Page<Tution> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allTution);
        return pageData;
    }

    @Override
    public Tution selectTution(Integer tution_id) {

        return tutionMapper.selectByPrimaryKey(tution_id);
    }

    @Override
    @Transactional
    public int insertTution(Tution tution) throws RuntimeException{
        CurriculumWithBLOBs curriculum = curriculumMapper.selectByPrimaryKey(tution.getCurriculumId());
        if(StringUtils.isEmpty(curriculum)){
            return 0;
        }
        int i = tutionMapper.insert(tution);
        int time = curriculum.getTime();
        CurriculumExample example = new CurriculumExample();
        example.createCriteria().andCurriculumIdEqualTo(tution.getCurriculumId());
        CurriculumWithBLOBs curriculum1 = new CurriculumWithBLOBs();
        curriculum1.setCurriculumId(tution.getCurriculumId());
        curriculum1.setTime(time+1);
        int b = curriculumMapper.updateByPrimaryKeySelective(curriculum1);
        if(i !=0&& b !=0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int updateTution(Integer tution_id, Tution tution) {
        tution.setTutionId(tution_id);
        int i = tutionMapper.updateByPrimaryKeySelective(tution);
        if(i !=0){
            return 1;
        }else{
            return 0;
        }

    }

    @Override
    public int deleteTution(Integer tution_id) {
        int i = tutionMapper.deleteByPrimaryKey(tution_id);
        if(i != 0){
            return 1;
        }else{
            return 0;
        }
    }
}
