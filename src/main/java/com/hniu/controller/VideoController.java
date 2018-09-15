package com.hniu.controller;

import com.hniu.dto.VideoDto;
import com.hniu.service.VideoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈威
 */
@RestController
@RequestMapping(value="/video")
public class VideoController {
    @Resource
    private VideoService videoService;


    /**
     * 添加视频
     * @param videoDto
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertVideo(VideoDto videoDto){
        Map<String,Object> map = new HashMap<>(2);
      Boolean b =  videoService.insertVideo(videoDto);
        if(b){
            map.put("msg","添加成功");
            return map;
        }
        else {
            map.put("msg","添加失败");
            return map;
        }
    }
}
