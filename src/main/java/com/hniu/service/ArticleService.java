package com.hniu.service;

import com.hniu.dto.ArticleDto;
import com.hniu.entity.Article;
import com.hniu.util.Page;

import java.util.List;

/**
 * 文章管理
 * @author 陈威
 */
public interface ArticleService {
    int insertArticle(ArticleDto articleDto);

    int updateArticle(ArticleDto articleDto);

    int deleteArticle(int articleId);

    Article queryArticle(int articleId);

    //根据知识目录id查询文章信息
    List<Article> byKnowledgeId(Integer knowledge_id);

    //根据文章名称模糊查询文章信息
    Page<Article> byName(String name,Integer currentPage, Integer pageSize);
}
