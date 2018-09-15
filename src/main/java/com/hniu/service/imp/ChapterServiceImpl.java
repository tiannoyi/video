package com.hniu.service.imp;

import com.hniu.entity.Chapter;
import com.hniu.mapper.ChapterMapper;
import com.hniu.service.ChapterService;
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
    @Override
    public int insertChapter(Chapter chapter) {
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
    public List<Chapter> listChapter() {
        return chapterMapper.listChapter();
    }
}
