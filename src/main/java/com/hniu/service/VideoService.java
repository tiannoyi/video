package com.hniu.service;

import com.hniu.dto.VideoDto;
import com.hniu.entity.Video;

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
}
