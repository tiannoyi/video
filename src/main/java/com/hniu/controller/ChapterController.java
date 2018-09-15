package com.hniu.controller;

import com.github.pagehelper.PageInfo;
import com.hniu.entity.Chapter;
import com.hniu.service.ChapterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈威
 */
@RestController
@RequestMapping(value = "/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    /**
     * 添加章节
     * @param chapter Chapter
     * @return map
     */
    @PostMapping(value="/insert")
    public Map<String,Object> insertChapter(Chapter chapter){
        int i = chapterService.insertChapter(chapter);
        Map<String,Object> map = new HashMap(2);
        if(i>0){
            map.put("code","1");
            map.put("msg","添加成功");
            return map;
        }
        else{
            map.put("code","0");
            map.put("msg","添加失败");
            return map;
        }
    }
    /**
     * 修改章节
     * @param chapter Chapter
     * @return map
     */
    @PutMapping(value="/update")
    public Map<String,Object> updateChapter(Chapter chapter){
        int i = chapterService.updateChapter(chapter);
        Map<String,Object> map = new HashMap(2);
        if(i>0){
            map.put("code","1");
            map.put("msg","修改成功");
            return map;
        }
        else{
            map.put("code","0");
            map.put("msg","修改失败");
            return map;
        }
    }

    /**
     * 根据章节id删除章节信息
     * @param chapterId int
     * @return map
     */
    @DeleteMapping(value = "/{chapterId}")
    public Map<String,Object> deleteChapterByChapterId(@PathVariable("chapterId") Integer chapterId){
        int i = chapterService.deleteChapter(chapterId);
        Map<String,Object> map = new HashMap(2);
        if(i>0){
            map.put("code","1");
            map.put("msg","删除成功");
            return map;
        }
        else{
            map.put("code","0");
            map.put("msg","删除失败");
            return map;
        }
    }
    @RequestMapping(value = "/list")
    public PageInfo<Chapter> listChapter(){
        List<Chapter> list = chapterService.listChapter();
        PageInfo<Chapter> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
