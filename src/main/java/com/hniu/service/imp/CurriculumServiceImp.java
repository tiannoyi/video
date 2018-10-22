package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.dto.CurriculumCurriculumWithBlobsDto;
import com.hniu.dto.CurriculumDto;
import com.hniu.entity.*;
import com.hniu.mapper.*;
import com.hniu.service.CurriculumService;
import com.hniu.util.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.List;

@Service
public class CurriculumServiceImp implements CurriculumService {
    @Resource
    CurriculumMapper curriculumMapper;
    @Resource
    UniversityMapper universityMapper;
    @Resource
    CourseTypeMapper courseTypeMapper;
    @Resource
    ChapterMapper chapterMapper;
    @Resource
    GiveMapper giveMapper;
    @Resource
    TutionMapper tutionMapper;
    @Resource
    CommentMapper commentMapper;

    @Value("${web.picturePath}")
    private String adCurriculumPicturePath;
    @Value("${web.videoPicturePath}")
    private String adCurriculumVideoPicturePath;
    @Value("${web.videoPath}")
    private String picturePath;
    @Value("${web.videoPath}")
    private String videoPicturePath;

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
    public CurriculumWithBLOBs inputCurriculum(CurriculumCurriculumWithBlobsDto curriculumDto) {
        University university = universityMapper.selectByPrimaryKey(curriculumDto.getUniversityId());
        CourseType courseType = courseTypeMapper.selectByPrimaryKey(curriculumDto.getCtId());
        if(StringUtils.isEmpty(university)||StringUtils.isEmpty(courseType)){
            return null;
        }
        CurriculumWithBLOBs curriculum = new CurriculumWithBLOBs();
        BeanUtils.copyProperties(curriculumDto,curriculum);
        File file1 = null;
        File file2 = null;
        String fileName1 = null;
        String fileName2 = null;
        if (curriculumDto.getPicture()!=null&&curriculumDto.getPicture().getSize()>0){
            fileName1 = System.currentTimeMillis()+"_"+curriculumDto.getPicture().getOriginalFilename();
            file1 = new File(adCurriculumPicturePath+fileName1);
            File fileFoleder = new File(adCurriculumPicturePath);
            if(!fileFoleder.exists()){
                fileFoleder.mkdirs();
            }
        }
        if (curriculumDto.getVideo()!=null&&curriculumDto.getVideo().getSize()>0){
            fileName2 = System.currentTimeMillis()+"_"+curriculumDto.getVideo().getOriginalFilename();
            file2 = new File(adCurriculumVideoPicturePath+fileName2);
            File fileFoleder = new File(adCurriculumVideoPicturePath);
            if ((!fileFoleder.exists())){
                fileFoleder.mkdirs();
            }
        }
        if (file1!=null&&fileName1!=null) {
            try {
                curriculumDto.getPicture().transferTo(file1);
                curriculum.setPicture(picturePath+fileName1);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        if(file2!=null&&fileName2!=null){
            try {
                curriculumDto.getVideo().transferTo(file2);
                curriculum.setVideo(picturePath+fileName2);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        int i = curriculumMapper.insertSelective(curriculum);
        if(i != 0){
            return curriculum;
        }else{
            return null;
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
        ChapterExample chapterExample = new ChapterExample();
        chapterExample.createCriteria().andCurriculumIdEqualTo(curriculum_id);
        List<Chapter> list = chapterMapper.selectByExample(chapterExample);

        GiveExample giveExample = new GiveExample();
        giveExample.createCriteria().andCurriculumIdEqualTo(curriculum_id);
        List<Give> list1 = giveMapper.selectByExample(giveExample);


        TutionExample tutionExample = new TutionExample();
        tutionExample.createCriteria().andCurriculumIdEqualTo(curriculum_id);
        List<Tution> list2 = tutionMapper.selectByExample(tutionExample);

        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andCurriculumIdEqualTo(curriculum_id);
        List<Comment> list3 = commentMapper.selectByExample(commentExample);

        if (list.size()>0||list1.size()>0||list2.size()>0||list3.size()>0){
            return  0;
        }

        int i = curriculumMapper.deleteByPrimaryKey(curriculum_id);
        if(i != 0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int updateCurriculumPicture(Integer curriculumId, MultipartFile curriculumPicture) {
        String endString = null;
        Curriculum c = curriculumMapper.selectByPrimaryKey(curriculumId);
        if(!StringUtils.isEmpty(c)) {
            String s = c.getPicture();
            endString = getString(endString, s);
            String s1 = s.substring(s.indexOf("video/") + 6, s.indexOf(endString));
            File file = new File(adCurriculumPicturePath+s1+endString);
            boolean b = file.delete();
            System.out.println(b);
        }
        if(curriculumPicture != null && curriculumPicture.getSize()>0){
            String fileName = System.currentTimeMillis()+"_"+curriculumPicture.getOriginalFilename();
            File file = new File(adCurriculumPicturePath+fileName);
            File fileFolder = new File(adCurriculumPicturePath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try{
                curriculumPicture.transferTo(file);
                String curriculumPicture1 = picturePath+fileName;
                CurriculumWithBLOBs curriculum = new CurriculumWithBLOBs();
                curriculum.setCurriculumId(curriculumId);
                curriculum.setPicture(curriculumPicture1);
                return curriculumMapper.updateByPrimaryKeySelective(curriculum);
            }catch (IOException e){
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }


    private String getString(String endString, String s) {
        if(s.contains(".gif")){
            endString = ".gif";
        }else if(s.contains(".png")){
            endString = ".png";
        }else if(s.contains(".jpg")){
            endString = ".jpg";
        }
        return endString;
    }


    @Override
    public int updateCurriculumVideoPicture(Integer curriculumId, MultipartFile videoPicture) {

        String endString = null;
        Curriculum c = curriculumMapper.selectByPrimaryKey(curriculumId);
        if(!StringUtils.isEmpty(c)) {
            String s = c.getVideo();
            endString = getString(endString, s);
            String s1 = s.substring(s.indexOf("video/") + 6, s.indexOf(endString));
            File file = new File(adCurriculumVideoPicturePath+s1+endString);
            file.delete();
        }
        if(videoPicture != null && videoPicture.getSize()>0){
            String fileName = System.currentTimeMillis()+"_"+videoPicture.getOriginalFilename();
            File file = new File(adCurriculumVideoPicturePath+fileName);
            File fileFolder = new File(adCurriculumVideoPicturePath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try{
                videoPicture.transferTo(file);
                String videoPicture1 = videoPicturePath+fileName;
                CurriculumWithBLOBs curriculum = new CurriculumWithBLOBs();
                curriculum.setCurriculumId(curriculumId);
                curriculum.setVideo(videoPicture1);
                return curriculumMapper.updateByPrimaryKeySelective(curriculum);
            }catch (IOException e){
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    @Override
    public Page<CurriculumWithBLOBs> bySchoolId(Integer university_id, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        CurriculumExample example = new CurriculumExample();
        example.createCriteria().andUniversityIdEqualTo(university_id);
        int countNums = curriculumMapper.countByExample(example);
        List<CurriculumWithBLOBs> allCurr = curriculumMapper.selectByExampleWithBLOBs(example);
        Page<CurriculumWithBLOBs> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCurr);
        return pageData;
    }

    @Override
    public Page<CurriculumWithBLOBs> byCtId(Integer ct_id, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        CurriculumExample example = new CurriculumExample();
        example.createCriteria().andCtIdEqualTo(ct_id);
        int countNums = curriculumMapper.countByExample(example);
        List<CurriculumWithBLOBs> allCurr = curriculumMapper.selectByExampleWithBLOBs(example);
        Page<CurriculumWithBLOBs> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCurr);
        return pageData;
    }

    @Override
    public Page<CurriculumWithBLOBs> byName(String name, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        CurriculumExample example = new CurriculumExample();
        name = "%" + name+"%";
        example.createCriteria().andNameLike(name);
        int countNums = curriculumMapper.countByExample(example);
        List<CurriculumWithBLOBs> allCurr = curriculumMapper.selectByExampleWithBLOBs(example);
        Page<CurriculumWithBLOBs> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCurr);
        return pageData;
    }

    @Override
    public Page<CurriculumDto> curriculumAndTutionPage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<CurriculumDto> allCurriculumDto = curriculumMapper.curriculumAndTution();
        int countNums = allCurriculumDto.size();
        Page<CurriculumDto> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCurriculumDto);
        return pageData;
    }

}
