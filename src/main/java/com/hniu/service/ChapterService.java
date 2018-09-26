package com.hniu.service;

import com.hniu.entity.Chapter;
import com.hniu.util.Page;

import java.util.List;

/**
 * 课程章节
 * @author 陈威
 */
public interface ChapterService {

    /**
     * 插入课程章节
     * @param chapter Chapter
     * @return row
     */
    int insertChapter(Chapter chapter);

    /**
     * 修改课程章节
     * @param chapter Chapter
     * @return row
     */
    int updateChapter(Chapter chapter);

    /**
     * 根据章节id来删除章节
     * @param chapterId int
     * @return row
     */
    int deleteChapter(Integer chapterId);

    /**
     * 查询所有章节信息
     * @return list
     */
    Page<Chapter> listChapter(Integer currentPage, Integer pageSize);

    Chapter queryChapter(Integer chapterId);

    //根据课程id查询章节信息
    List<Chapter> selectClassId(Integer curriculum_id);

    //根据章节名模糊查询
    Page<Chapter> selectChapterName(String chapterName,Integer currentPage, Integer pageSize);

}
