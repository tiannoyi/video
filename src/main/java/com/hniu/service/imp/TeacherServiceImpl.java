package com.hniu.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hniu.dto.TeacherDto;
import com.hniu.entity.Teacher;
import com.hniu.entity.TeacherExample;
import com.hniu.mapper.TeacherMapper;
import com.hniu.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 老师管理
 * @author 陈威
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Value("${web.upload-path}")
    private String adVideoSavePath;

    @Value("${web.videoPath}")
    private String videoPath;

    @Override
    public int insertTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDto,teacher);
        if(teacherDto.getFile()!=null&&teacherDto.getFile().getSize()>0){
            String fileName = System.currentTimeMillis()+"_"+teacherDto.getFile().getOriginalFilename();
            File file = new File(adVideoSavePath+fileName);
            File fileFolder = new File(adVideoSavePath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try {
                teacherDto.getFile().transferTo(file);
                teacher.setPicture(videoPath+fileName);
                return teacherMapper.insert(teacher);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        if(teacher.getPicture()==null){
            return teacherMapper.insertSelective(teacher);
        }
        else{
            return 0;
        }

    }

    @Override
    public int updateTeacher(TeacherDto teacherDto) {
        String endString = null;
        Teacher t = teacherMapper.selectByPrimaryKey(teacherDto.getTeacherId());
        if(!StringUtils.isEmpty(t)) {
            String s = t.getPicture();
            if(s.contains(".gif")){
                endString = ".gif";
            }else if(s.contains(".png")){
                endString = ".png";
            }else if(s.contains(".jpg")){
                endString = ".jpg";
            }
            String s1 = s.substring(s.indexOf("video/") + 6, s.indexOf(endString));
            File file = new File(adVideoSavePath+s1+endString);
            file.delete();
        }
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDto,teacher);
        if(teacherDto.getFile()!=null&&teacherDto.getFile().getSize()>0){
            String fileName = System.currentTimeMillis()+"_"+teacherDto.getFile().getOriginalFilename();
            File file = new File(adVideoSavePath+fileName);
            File fileFolder = new File(adVideoSavePath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try {
                teacherDto.getFile().transferTo(file);
                teacher.setPicture(videoPath+fileName);
                return teacherMapper.updateByPrimaryKeySelective(teacher);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        if(teacher.getPicture()==null){
            return teacherMapper.updateByPrimaryKeySelective(teacher);
        }
        else{
            return 0;
        }
    }

    @Override
    public int deleteTeacher(int teacherId) {
        String endString = null;
        Teacher t = teacherMapper.selectByPrimaryKey(teacherId);
        if(!StringUtils.isEmpty(t)) {
            String s = t.getPicture();
            if(s.contains(".gif")){
                endString = ".gif";
            }else if(s.contains(".png")){
                endString = ".png";
            }else if(s.contains(".jpg")){
                endString = ".jpg";
            }
            String s1 = s.substring(s.indexOf("video/") + 6, s.indexOf(endString));
            File file = new File(adVideoSavePath+s1+endString);
            file.delete();
        }
        return teacherMapper.deleteByPrimaryKey(teacherId);
    }

    @Override
    public Teacher selectTeacher(int teacherId) {
        return teacherMapper.selectByPrimaryKey(teacherId);
    }

    @Override
    public List<Teacher> listTeacher() {
        TeacherExample example = new TeacherExample();
        example.setOrderByClause("teacher_id desc");
        return teacherMapper.selectByExample(example);
    }

    @Override
    public com.hniu.util.Page<Teacher> byName(String name, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        TeacherExample example = new TeacherExample();
        name = "%" + name + "%";
        example.createCriteria().andNameLike(name);
        int countNums = teacherMapper.countByExample(example);
        List<Teacher> allTeacher = teacherMapper.selectByExample(example);
        com.hniu.util.Page<Teacher> pageData = new com.hniu.util.Page<>(currentPage,pageSize,countNums);
        pageData.setList(allTeacher);
        return pageData;
    }
}
