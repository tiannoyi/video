package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.Curriculum;
import com.hniu.entity.CurriculumExample;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.mapper.CurriculumMapper;
import com.hniu.service.CurriculumService;
import com.hniu.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumServiceImp implements CurriculumService {
    @Autowired
    CurriculumMapper curriculumMapper;

    @Override
    public Page<CurriculumWithBLOBs> selectCurriculumList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        CurriculumExample example = new CurriculumExample();
        example.setOrderByClause("curriculum_id desc");
        List<CurriculumWithBLOBs> allCurriculum = curriculumMapper.selectByExampleWithBLOBs(example);
        int countNums = curriculumMapper.count();
        Page<CurriculumWithBLOBs> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCurriculum);
        return pageData;
    }

    @Override
    public CurriculumWithBLOBs selectCurriculum(int curriculum_id) {
        CurriculumWithBLOBs curriculum = curriculumMapper.selectByPrimaryKey(curriculum_id);
        return curriculum;
    }

    @Override
    public int inputCurriculum(CurriculumWithBLOBs curriculum) {
        int i = curriculumMapper.insert(curriculum);
        if(i != 0){
            return 1;
        }else{
            return 0;
        }

    }

    @Override
    public int updateCurriculum(int curriculum_id, CurriculumWithBLOBs curriculum) {
        curriculum.setCurriculumId(curriculum_id);
        int i = curriculumMapper.updateByPrimaryKeySelective(curriculum);
        if(i != 0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int deleteCurriculum(int curriculum_id) {
        int i = curriculumMapper.deleteByPrimaryKey(curriculum_id);
        if(i != 0){
            return 1;
        }else{
            return 0;
        }
    }
}
