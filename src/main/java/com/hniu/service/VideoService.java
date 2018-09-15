package com.hniu.service;

import com.hniu.dto.VideoDto;

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
}
