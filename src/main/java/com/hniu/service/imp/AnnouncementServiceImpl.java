package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.entity.Announcement;
import com.hniu.entity.AnnouncementExample;
import com.hniu.mapper.AnnouncementMapper;
import com.hniu.service.AnnouncementService;
import com.hniu.util.Page;
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

    @Override
    public List<Announcement> byTutionId(Integer tution_id) {
        AnnouncementExample example = new AnnouncementExample();
        example.createCriteria().andTutionIdEqualTo(tution_id);
        return announcementMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public Page<Announcement> byTitle(String title, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        AnnouncementExample example = new AnnouncementExample();
        title = "%" + title + "%";
        example.createCriteria().andTitleLike(title);
        int countNums = announcementMapper.countByExample(example);
        List<Announcement> allAnnouncement = announcementMapper.selectByExampleWithBLOBs(example);
        Page<Announcement> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allAnnouncement);
        return pageData;
    }
}
