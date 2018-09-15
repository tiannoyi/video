package com.hniu.service.imp;

import com.hniu.entity.Announcement;
import com.hniu.mapper.AnnouncementMapper;
import com.hniu.service.AnnouncementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 陈威
 */
@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {

    @Resource
    private AnnouncementMapper announcementMapper;

    @Override
    public int insertAnnouncement(Announcement announcement) {
        return announcementMapper.insertSelective(announcement);
    }

    @Override
    public int updateAnnouncement(Announcement announcement) {
        return announcementMapper.updateByPrimaryKeySelective(announcement);
    }

    @Override
    public int deletennouncement(int announcementId) {
        return announcementMapper.deleteByPrimaryKey(announcementId);
    }

    @Override
    public Announcement queryAnnouncement(int announcementId) {
        return announcementMapper.selectByPrimaryKey(announcementId);
    }

    @Override
    public List<Announcement> listAnnouncement() {
        return announcementMapper.listAnnouncement();
    }
}
