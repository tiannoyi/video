package com.hniu.service.imp;

import com.github.pagehelper.PageHelper;
import com.hniu.dto.VideoDto;
import com.hniu.entity.Video;
import com.hniu.entity.VideoExample;
import com.hniu.mapper.VideoMapper;
import com.hniu.service.VideoService;
import com.hniu.util.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 陈威
 */
@Service
public class VideoServiceImpl implements VideoService {
    /**
     * 注入mapper
     */
    @Resource
    private VideoMapper videoMapper;

    @Value("${web.upload-path}")
    private String adVideoSavePath;

    @Value("${web.videoPath}")
    private String videoPath;
    @Override
    public Boolean insertVideo(VideoDto videoDto) {
        Video video = new Video();
        BeanUtils.copyProperties(videoDto, video);
        if (videoDto.getFile() != null && videoDto.getFile().getSize() > 0) {
            String fileName = System.currentTimeMillis() + "_" + videoDto.getFile().getOriginalFilename();
            File file = new File(adVideoSavePath + fileName);
            File fileFolder = new File(adVideoSavePath);
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            try {
                videoDto.getFile().transferTo(file);
                video.setVideoAddress(videoPath+fileName);
                videoMapper.insert(video);
                return true;
            } catch (IllegalStateException | IOException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateVideo(VideoDto videoDto) {
        Video video = new Video();
        BeanUtils.copyProperties(videoDto, video);
        if (videoDto.getFile() != null && videoDto.getFile().getSize() > 0) {
            String fileName = System.currentTimeMillis() + "_" + videoDto.getFile().getOriginalFilename();
            File file = new File(adVideoSavePath + fileName);
            File fileFolder = new File(adVideoSavePath);
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            try {
                videoDto.getFile().transferTo(file);
                video.setVideoAddress(videoPath+fileName);
                videoMapper.updateByPrimaryKeySelective(video);
                return true;
            } catch (IllegalStateException | IOException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int deleteVideo(int videoId) {
        return videoMapper.deleteByPrimaryKey(videoId);
    }

    @Override
    public Video queryVideo(int videoId) {
        return videoMapper.selectByPrimaryKey(videoId);
    }

    @Override
    public List<Video> byKnowledgeId(Integer id) {
        VideoExample example = new VideoExample();
        example.createCriteria().andKnowledgeIdEqualTo(id);
        return videoMapper.selectByExample(example);
    }

    @Override
    public Page<Video> byName(String name, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        VideoExample example = new VideoExample();
        name = "%" + name + "%";
        example.createCriteria().andVideoNameLike(name);
        int countNums = videoMapper.countByExample(example);
        List<Video> allVideo = videoMapper.selectByExample(example);
        Page<Video> pageData = new Page<>(currentPage,pageSize,countNums);
        pageData.setList(allVideo);
        return pageData;
    }
}
