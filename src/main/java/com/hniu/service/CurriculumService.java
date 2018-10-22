package com.hniu.service;

import com.hniu.dto.CurriculumCurriculumWithBlobsDto;
import com.hniu.dto.CurriculumDto;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.util.Page;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface CurriculumService {

    //分页查询课程信息
    Page<CurriculumWithBLOBs> selectCurriculumList(int currentPage, int pageSize);

    //查询课程信息
    CurriculumWithBLOBs selectCurriculum(int curriculum_id);

    //添加课程信息
    CurriculumWithBLOBs inputCurriculum(CurriculumCurriculumWithBlobsDto curriculum);

    //修改课程信息
    int updateCurriculum(int curriculum_id,CurriculumWithBLOBs curriculum);

    //删除课程信息
    int deleteCurriculum(int curriculum_id);

    //修改课程封面
    int updateCurriculumPicture(Integer curriculumId, MultipartFile curriculumPicture);

    //修改视屏封面
    int updateCurriculumVideoPicture(Integer curriculumId,MultipartFile videoPicture);

    //根据学校id查询课程信息
    Page<CurriculumWithBLOBs> bySchoolId(Integer university_id,int currentPage, int pageSize);

    //根据类别id查询课程信息
    Page<CurriculumWithBLOBs> byCtId(Integer ct_id,int currentPage, int pageSize);

    //根据课程名查询课程信息
    Page<CurriculumWithBLOBs> byName(String name,int currentPage, int pageSize);

    //分页查询课程和开课信息
    Page<CurriculumDto> curriculumAndTutionPage(Integer currentPage, Integer pageSize);

}
