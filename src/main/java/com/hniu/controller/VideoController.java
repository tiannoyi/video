package com.hniu.controller;

import com.hniu.constant.StateCode;
import com.hniu.dto.VideoDto;
import com.hniu.entity.Video;
import com.hniu.service.VideoService;
import com.hniu.util.Page;
import com.hniu.util.State;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author 陈威
 */
@RestController
@RequestMapping(value="/video")
public class VideoController extends Base {
    @Resource
    private VideoService videoService;


    /**
     * 根据id查看视频信息
     * @param videoId
     * @return
     */
    @GetMapping(value = "/{videoId}")
    public State<Object> selectVideo(@PathVariable("videoId") int videoId){
        Video video = videoService.queryVideo(videoId);
        if(StringUtils.isEmpty(video)){
            return packaging(StateCode.FAIL,"视频信息查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"视频信息查询成功",video);
        }
    }

    /**
     * 添加视频
     * @param videoDto
     * @return base
     */
    @PostMapping()
    public State<Object> inputVideo(VideoDto videoDto){
        Boolean aBoolean = videoService.insertVideo(videoDto);
        if(aBoolean){
            return packaging(StateCode.SUCCESS,"视频添加成功",null);
        }else{
            return packaging(StateCode.FAIL,"视频添加失败",null);
        }

    }

    /**
     *修改视频信息
     * @param video
     * @return
     */
    @PostMapping(value = "/update")
    public State<Object> updateVideo(VideoDto video){
        Boolean aBoolean = videoService.updateVideo(video);
        if(aBoolean){
            return packaging(StateCode.SUCCESS,"视频修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"视频修改失败",null);
        }
    }

    /**
     * 根据视频id删除视频
     * @param videoId
     * @return
     */
    @DeleteMapping(value = "/{videoId}")
    public State<Object> deleteVideo(@PathVariable("videoId") int videoId){
        int i = videoService.deleteVideo(videoId);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"视频删除成功",null);
        }else{
            return packaging(StateCode.FAIL,"视频删除失败",null);
        }
    }

    //根据知识目录id查询视频信息
    @GetMapping("knowledgeId")
    public  State<Object> byKnowledgeId(Integer knowledge_id){
        List<Video> list = videoService.byKnowledgeId(knowledge_id);
        if(list.size()>0){
            return packaging(StateCode.SUCCESS,"视频查询成功",list);
        }else {
            return packaging(StateCode.FAIL,"视频查询失败",null);
        }
    }

    //根据视频名称模糊查询视频信息
    @GetMapping("VideoName")
   public State<Object> byName(String name,Integer currentPage, Integer pageSize){
       Page<Video> list = videoService.byName(name, currentPage, pageSize);
       if(list.getList().size()>=0){
           return packaging(StateCode.SUCCESS,"视频信息查询成功",list);
       }else{
           return packaging(StateCode.FAIL,"视频信息查询失败",null);
       }
   }

}
