package com.hniu.service;

import com.hniu.dto.ArticleDto;
import com.hniu.entity.Article;

/**
 * 文章管理
 * @author 陈威
 */
public interface ArticleService {
    int insertArticle(ArticleDto articleDto);

    int updateArticle(ArticleDto articleDto);

    int deleteArticle(int articleId);

    Article queryArticle(int articleId);
}
