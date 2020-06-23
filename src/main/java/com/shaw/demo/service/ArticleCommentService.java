package com.shaw.demo.service;

import com.shaw.demo.model.ArticleComment;
import com.shaw.demo.model.ArticleInfo;
import com.shaw.demo.model.Comment;

public interface ArticleCommentService {

    int createComment(ArticleInfo articleInfo, Comment comment);

    int deleteComment(long commentId);

    ArticleComment getComment(long commentId);

    int addComment(long articleId, ArticleComment articleComment);

    ArticleComment findById(long id);
}
