package com.shaw.demo.service;

import com.shaw.demo.common.CommonResult;
import com.shaw.demo.model.ArticleContent;

public interface ArticleContentService {
    int createContent(ArticleContent articleContent);

    int changeContent(long articleId, ArticleContent articleContent);
}
