package com.hniu.service;

import com.hniu.dto.VideoDto;
import com.hniu.entity.Video;
import com.hniu.util.Page;

import java.util.List;

/**
 * @author 陈威
 */
public interface VideoService {
    /**
     * 添加视频信息
     * @param videoDto VideoDto
     * @return
     */
    Boolean insertVideo(VideoDto videoDto);

    Boolean updateVideo(VideoDto videoDto);

    int deleteVideo(int videoId);

    Video queryVideo(int videoId);

    //根据知识目录id查询视频信息
    List<Video> byKnowledgeId(Integer id);

    //根据视频名称模糊查询视频信息
    Page<Video> byName(String name,Integer currentPage, Integer pageSize);
}
