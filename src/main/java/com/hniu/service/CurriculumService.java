package com.hniu.service;

import com.hniu.entity.Curriculum;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.util.Page;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public interface CurriculumService {

    //分页查询课程信息
    Page<CurriculumWithBLOBs> selectCurriculumList(int currentPage, int pageSize);

    //查询课程信息
    CurriculumWithBLOBs selectCurriculum(int curriculum_id);

    //添加课程信息
    int inputCurriculum(CurriculumWithBLOBs curriculum);

    //修改课程信息
    int updateCurriculum(int curriculum_id,CurriculumWithBLOBs curriculum);

    //删除课程信息
    int deleteCurriculum(int curriculum_id);

    //修改课程封面
    int updateCurriculumPicture(Integer curriculumId, MultipartFile curriculumPicture);

    //修改视屏封面
    int updateCurriculumVideoPicture(Integer curriculumId,MultipartFile videoPicture);

}
