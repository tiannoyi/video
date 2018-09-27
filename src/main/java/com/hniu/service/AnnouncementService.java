package com.hniu.service;

import com.hniu.entity.Announcement;
import com.hniu.util.Page;

import java.util.List;

/**
 * @author 陈威
 */
public interface AnnouncementService {

    int insertAnnouncement(Announcement announcement);

    int updateAnnouncement(Announcement announcement);

    int deletennouncement(int announcementId);

    Announcement queryAnnouncement(int announcementId);

    List<Announcement> listAnnouncement();

    //根据开课id查询公告信息
    List<Announcement> byTutionId(Integer tution_id);

    //根据公告标题进行模糊查询
    Page<Announcement> byTitle(String title,Integer currentPage, Integer pageSize);
}
