package com.hniu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hniu.constant.StateCode;
import com.hniu.entity.Announcement;
import com.hniu.service.AnnouncementService;
import com.hniu.util.State;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 陈威
 */
@RestController
@RequestMapping(value = "/announcement")
public class AnnouncementController extends Base{
    @Resource
    private AnnouncementService announcementService;

    /**
     * 分页查询公告信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/page")
    public State<Object> selectCurriculumList(Integer pageNum, Integer pageSize){

        PageHelper.startPage(pageNum,pageSize);
        List<Announcement> announcements = announcementService.listAnnouncement();
        PageInfo<Announcement> pageInfo = new PageInfo<>(announcements);
        if(announcements.size()!=0){
            return packaging(StateCode.SUCCESS,"公告信息查询成功",pageInfo);
        }else{
            return packaging(StateCode.FAIL,"公告信息查询失败",null);
        }

    }

    /**
     * 根据id查看公告信息
     * @param announcementId
     * @return
     */
    @GetMapping(value = "/{announcementId}")
    public State<Object> selectCurriculum(@PathVariable("announcementId") int announcementId){
        Announcement announcement = announcementService.queryAnnouncement(announcementId);
        if(StringUtils.isEmpty(announcement)){
            return packaging(StateCode.FAIL,"公告信息查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"公告信息查询成功",announcement);
        }
    }

    /**
     * 添加公告
     * @param announcement
     * @return base
     */
    @PostMapping()
    public State<Object> inputCurriculum(Announcement announcement){
        int i = announcementService.insertAnnouncement(announcement);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"公告添加成功",announcement);
        }else{
            return packaging(StateCode.FAIL,"公告添加失败",null);
        }

    }

    /**
     *修改公告信息
     * @param announcement
     * @return
     */
    @PutMapping(value = "")
    public State<Object> updateCurriculum(Announcement announcement){
        int i = announcementService.updateAnnouncement(announcement);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"公告修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"公告修改失败",null);
        }
    }

    /**
     * 根据公告id删除公告
     * @param announcementId
     * @return
     */
    @DeleteMapping(value = "/{announcementId}")
    public State<Object> DeleteCurriculum(@PathVariable("announcementId") int announcementId){
        int i = announcementService.deletennouncement(announcementId);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"公告删除成功",null);
        }else{
            return packaging(StateCode.FAIL,"公告删除失败",null);
        }
    }
}
