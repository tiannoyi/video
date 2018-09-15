package com.hniu.service;

import com.hniu.entity.Announcement;

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
}
