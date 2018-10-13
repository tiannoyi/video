package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.dto.CourseTypeDto;
import com.hniu.entity.CourseType;
import com.hniu.entity.CourseTypeExample;
import com.hniu.mapper.CourseTypeMapper;
import com.hniu.service.CourseTypeService;
import com.hniu.util.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: 熊俊
 * @Date: 2018/10/9 11:31
 * @Description:
 * @Modified By:
 */
@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    @Resource
    CourseTypeMapper courseTypeMapper;

    @Value("${web.courseTypePath}")
    private String courseTypePicture;

    @Value("${web.videoPath}")
    private String picturePath;


    @Override
    public Page<CourseType> selectCourseTypeAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        CourseTypeExample example = new CourseTypeExample();
        example.setOrderByClause("ct_id desc");
        List<CourseType> allCourseType = courseTypeMapper.selectByExample(example);
        int countNums = courseTypeMapper.countByExample(example);
        Page<CourseType> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allCourseType);
        return pageData;
    }

    @Override
    public int insertCourseType(CourseTypeDto courseTypeDto) {
        CourseType courseType = new CourseType();
        BeanUtils.copyProperties(courseTypeDto,courseType);
        if(courseTypeDto.getPicture()!=null&&courseTypeDto.getPicture().getSize()>0){
            String fileName = System.currentTimeMillis()+"_"+courseTypeDto.getPicture().getOriginalFilename();
            File file = new File(courseTypePicture+fileName);
            File fileFolder = new File(courseTypePicture);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try{
                courseTypeDto.getPicture().transferTo(file);
                courseType.setPicture(picturePath+fileName);
                return courseTypeMapper.insertSelective(courseType);
            }catch(IOException e){
                e.printStackTrace();
                return 0;
            }
        }
        if(courseTypeDto.getPicture()==null){
            return courseTypeMapper.insertSelective(courseType);
        }
        return 0;
    }

    @Override
    public int updateCourseType(CourseTypeDto courseTypeDto) {
        String endString = null;
        CourseType c = courseTypeMapper.selectByPrimaryKey(courseTypeDto.getCtId());
        if(!StringUtils.isEmpty(c)) {
            String s = c.getPicture();
            if(s.contains(".gif")){
                endString = ".gif";
            }else if(s.contains(".png")){
                endString = ".png";
            }else if(s.contains(".jpg")){
                endString = ".jpg";
            }
            String s1 = s.substring(s.indexOf("video/") + 6, s.indexOf(endString));
            File file = new File(courseTypePicture+s1+endString);
            file.delete();
        }
        CourseType courseType = new CourseType();
        BeanUtils.copyProperties(courseTypeDto,courseType);
        if(courseTypeDto.getPicture()!=null&&courseTypeDto.getPicture().getSize()>0){
            String fileName = System.currentTimeMillis()+"_"+courseTypeDto.getPicture().getOriginalFilename();
            File file = new File(courseTypePicture+fileName);
            File fileFolder = new File(courseTypePicture);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try {
                courseTypeDto.getPicture().transferTo(file);
                courseType.setPicture(picturePath+fileName);
                return courseTypeMapper.updateByPrimaryKeySelective(courseType);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        if (courseType.getPicture()==null){
            return courseTypeMapper.updateByPrimaryKeySelective(courseType);
        }
        return 0;
    }

    @Override
    public int deleceCourseType(Integer ct_id) {
        String endString = null;
        CourseType c = courseTypeMapper.selectByPrimaryKey(ct_id);
        if(!StringUtils.isEmpty(c)) {
            String s = c.getPicture();
            if(s.contains(".gif")){
                endString = ".gif";
            }else if(s.contains(".png")){
                endString = ".png";
            }else if(s.contains(".jpg")){
                endString = ".jpg";
            }
            String s1 = s.substring(s.indexOf("video/") + 6, s.indexOf(endString));
            File file = new File(courseTypePicture+s1+endString);
            file.delete();
        }
        int i = courseTypeMapper.deleteByPrimaryKey(ct_id);
        if(i>0){
            return 1;
        }
        return 0;
    }
}
