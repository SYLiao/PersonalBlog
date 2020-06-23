package com.shaw.demo.service.impl;

import com.shaw.demo.model.ArticleContent;
import com.shaw.demo.repository.ArticleContentRepository;
import com.shaw.demo.service.ArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleContentServiceImpl implements ArticleContentService {
    @Autowired
    private ArticleContentRepository articleContentRepository;

    @Override
    public int createContent(ArticleContent articleContent) {
        articleContentRepository.saveAndFlush(articleContent);
        return 1;
    }

    @Override
    public int changeContent(long articleId, ArticleContent articleContent) {
        articleContent.setId(articleId);
        articleContentRepository.save(articleContent);
        return 1;
    }
}
