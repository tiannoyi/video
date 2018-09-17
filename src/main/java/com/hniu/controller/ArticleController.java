package com.hniu.controller;

import com.hniu.constant.StateCode;
import com.hniu.dto.ArticleDto;
import com.hniu.entity.Article;
import com.hniu.service.ArticleService;
import com.hniu.util.State;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 陈威
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleController extends Base{
    
    @Resource
    private ArticleService articleService;
    /**
     * 根据id查看文章信息
     * @param articleId
     * @return
     */
    @GetMapping(value = "/{articleId}")
    public State<Object> selectArticle(@PathVariable("articleId") int articleId){
        Article article = articleService.queryArticle(articleId);
        if(StringUtils.isEmpty(article)){
            return packaging(StateCode.FAIL,"文章信息查询失败",null);
        }else {
            return packaging(StateCode.SUCCESS,"文章信息查询成功",article);
        }
    }

    /**
     * 添加文章
     * @param articleDto
     * @return base
     */
    @PostMapping()
    public State<Object> inputArticle(ArticleDto articleDto){
        int i = articleService.insertArticle(articleDto);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"文章添加成功",null);
        }else{
            return packaging(StateCode.FAIL,"文章添加失败",null);
        }

    }

    /**
     *修改文章信息
     * @param articleDto
     * @return
     */
    @PostMapping(value = "/update")
    public State<Object> updateArticle(ArticleDto articleDto){
        int i = articleService.updateArticle(articleDto);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"文章修改成功",null);
        }else{
            return packaging(StateCode.FAIL,"文章修改失败",null);
        }
    }

    /**
     * 根据文章id删除文章
     * @param articleId
     * @return
     */
    @DeleteMapping(value = "/{articleId}")
    public State<Object> DeleteArticle(@PathVariable("articleId") int articleId){
        int i = articleService.deleteArticle(articleId);
        if(i != 0){
            return packaging(StateCode.SUCCESS,"文章删除成功",null);
        }else{
            return packaging(StateCode.FAIL,"文章删除失败",null);
        }
    }


}
