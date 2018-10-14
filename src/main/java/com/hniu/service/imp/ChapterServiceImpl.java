package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.Chapter;
import com.hniu.entity.ChapterExample;
import com.hniu.entity.Curriculum;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.mapper.ChapterMapper;
import com.hniu.mapper.CurriculumMapper;
import com.hniu.service.ChapterService;
import com.hniu.util.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 章节管理实现层
 * @author 陈威
 */
@Service("chapterService")
public class ChapterServiceImpl implements ChapterService {
    @Resource
    private ChapterMapper chapterMapper;
    @Resource
    CurriculumMapper curriculumMapper;
    @Override
    public int insertChapter(Chapter chapter) {
        CurriculumWithBLOBs curriculum = curriculumMapper.selectByPrimaryKey(chapter.getCurriculumId());
        if (org.springframework.util.StringUtils.isEmpty(curriculum)){
            return 0;
        }
        return chapterMapper.insert(chapter);
    }

    @Override
    public int updateChapter(Chapter chapter) {
        return chapterMapper.updateByPrimaryKeySelective(chapter);
    }

    @Override
    public int deleteChapter(Integer chapterId) {
        return chapterMapper.deleteByPrimaryKey(chapterId);
    }

    @Override
    public Page<Chapter> listChapter(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        ChapterExample example = new ChapterExample();
        example.setOrderByClause("curriculum_id desc");
        List<Chapter> allChapter = chapterMapper.selectByExample(example);
        int countNums = chapterMapper.countByExample(example);
        Page<Chapter> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allChapter);
        return pageData;
    }

    @Override
    public Chapter queryChapter(Integer chapterId) {
        return chapterMapper.selectByPrimaryKey(chapterId);
    }

    @Override
    public List<Chapter> selectClassId(Integer curriculum_id) {
        ChapterExample example = new ChapterExample();
        example.createCriteria().andCurriculumIdEqualTo(curriculum_id);
        return chapterMapper.selectByExample(example);
    }

    @Override
    public Page<Chapter> selectChapterName(String chapterName,Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        ChapterExample example = new ChapterExample();
        chapterName = "%"+chapterName+"%";
        example.createCriteria().andChapterNameLike(chapterName);
        int countNums = chapterMapper.countByExample(example);
        List<Chapter> allChapter = chapterMapper.selectByExample(example);
        Page<Chapter> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allChapter);
        return pageData;
    }
}
