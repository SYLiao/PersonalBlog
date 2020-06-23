package com.shaw.demo.service;

import com.shaw.demo.model.ArticleComment;
import com.shaw.demo.model.ArticleContent;
import com.shaw.demo.model.ArticleInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArticleInfoService {
    int createArticleInfo(ArticleInfo articleInfo);

    int deleteArticleInfo(long articleId);

    int changeContent(long articleId, ArticleContent articleContent);

//    int addComment(long articleId, ArticleComment articleComment);
//
//    int deleteComment(long articleId, long commentId);

    List<ArticleComment> getAllCommentsFromArticle(long articleId);

    Page<ArticleInfo> getArticlePage(long articleId, int pageNum, int pageSize);

    Page<ArticleInfo> getRecentArticle(int pageSize);

    List<ArticleInfo> getAllArticle();

    ArticleInfo getArticleById(long id);

    ArticleInfo getArticleByTitle(String title);
}
