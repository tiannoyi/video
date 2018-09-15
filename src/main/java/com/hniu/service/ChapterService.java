package com.hniu.service;

import com.hniu.entity.Chapter;

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
    List<Chapter> listChapter();
}
