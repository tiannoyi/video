package com.hniu.service.imp;

import com.hniu.dto.ArticleDto;
import com.hniu.entity.Article;
import com.hniu.mapper.ArticleMapper;
import com.hniu.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author 陈威
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Value("${web.upload-path}")
    private String adVideoSavePath;

    @Value("${web.videoPath}")
    private String videoPath;
    @Override
    public int insertArticle(ArticleDto articleDto) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDto,article);
        if(articleDto.getFile()!=null&&articleDto.getFile().getSize()>0){
            String fileName = System.currentTimeMillis()+"_"+articleDto.getFile().getOriginalFilename();
            File file = new File(adVideoSavePath+fileName);
            File fileFolder = new File(adVideoSavePath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try {
                articleDto.getFile().transferTo(file);
                article.setArticleAddress(videoPath+fileName);
                return articleMapper.insertSelective(article);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        else{
            return 0;
        }

    }

    @Override
    public int updateArticle(ArticleDto articleDto) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDto,article);
        if(articleDto.getFile()!=null&&articleDto.getFile().getSize()>0){
            String fileName = System.currentTimeMillis()+"_"+articleDto.getFile().getOriginalFilename();
            File file = new File(adVideoSavePath+fileName);
            File fileFolder = new File(adVideoSavePath);
            if(!fileFolder.exists()){
                fileFolder.mkdirs();
            }
            try {
                articleDto.getFile().transferTo(file);
                article.setArticleAddress(videoPath+fileName);
                return articleMapper.updateByPrimaryKey(article);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        else{
            return 0;
        }

    }

    @Override
    public int deleteArticle(int articleId) {
        return articleMapper.deleteByPrimaryKey(articleId);
    }

    @Override
    public Article queryArticle(int articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }
}
