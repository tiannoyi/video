package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.*;
import com.hniu.mapper.AddCurriculumMapper;
import com.hniu.mapper.AnnouncementMapper;
import com.hniu.mapper.CurriculumMapper;
import com.hniu.mapper.TutionMapper;
import com.hniu.service.TutionService;
import com.hniu.util.Page;
import org.hibernate.validator.constraints.pl.REGON;
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
    @Resource
    AnnouncementMapper announcementMapper;
    @Resource
    AddCurriculumMapper addCurriculumMapper;


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
        TutionExample example1 = new TutionExample();
        example1.createCriteria().andCurriculumIdEqualTo(tution.getCurriculumId());
         List<Tution> tutions = tutionMapper.selectByExample(example1);
         for (int i = 0;i<tutions.size();i++){
             if(tutions.get(i).getStatus()==1){
                 return 0;
             }
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
        if(tution.getCurriculumId()!=null){
            CurriculumWithBLOBs curriculum = curriculumMapper.selectByPrimaryKey(tution.getCurriculumId());
            if(StringUtils.isEmpty(curriculum)){
                return 0;
            }
        }
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
        AnnouncementExample announcementExample = new AnnouncementExample();
        announcementExample.createCriteria().andTutionIdEqualTo(tution_id);
        List<Announcement> list = announcementMapper.selectByExample(announcementExample);

        AddCurriculumExample addCurriculumExample = new AddCurriculumExample();
        addCurriculumExample.createCriteria().andTutionIdEqualTo(tution_id);
        List<AddCurriculum> list1 = addCurriculumMapper.selectByExample(addCurriculumExample);

        if(list.size()>0||list1.size()>0){
            return  0;
        }

        int i = tutionMapper.deleteByPrimaryKey(tution_id);
        if(i != 0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public Page<Tution> byCurriculumId(Integer curriculum_id, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        TutionExample example = new TutionExample();
        example.createCriteria().andCurriculumIdEqualTo(curriculum_id);
        List<Tution> allTution = tutionMapper.selectByExample(example);
        int countNums = tutionMapper.countByExample(example);
        Page<Tution> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allTution);
        return pageData;
    }
}
