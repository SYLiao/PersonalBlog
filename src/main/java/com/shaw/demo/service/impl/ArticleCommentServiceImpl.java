package com.shaw.demo.service.impl;

import com.shaw.demo.model.ArticleComment;
import com.shaw.demo.model.ArticleInfo;
import com.shaw.demo.model.Comment;
import com.shaw.demo.repository.ArticleCommentRepository;
import com.shaw.demo.repository.ArticleInfoRepository;
import com.shaw.demo.service.ArticleCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {
    @Autowired
    private ArticleCommentRepository articleCommentRepository;

    @Autowired
    private ArticleInfoRepository articleInfoRepository;

    public int createComment(ArticleInfo articleInfo, Comment comment) {
        ArticleComment articleComment = new ArticleComment();
        articleComment.setComment(comment);
        articleComment.setEffective(true);
        articleComment.setCreateBy(new Date());
        articleComment.setArticleInfo(articleInfo);
        articleCommentRepository.save(articleComment);
        return 1;
    }

    public int deleteComment(long commentId) {
        if(articleCommentRepository.findById(commentId).map(Collections::singletonList).orElse(Collections.emptyList()).size() == 0){
            return 0;
        }
        articleCommentRepository.deleteById(commentId);
        return 1;
    }

    public ArticleComment getComment(long commentId) {
        List<ArticleComment> result = articleCommentRepository.findById(commentId).map(Collections::singletonList).orElse(Collections.emptyList());
        if( result.size() == 1){
            return result.get(0);
        }
        return null;
    }

    @Override
    public int addComment(long articleId, ArticleComment articleComment) {
        ArticleInfo articleInfo = articleInfoRepository.findById(articleId).orElse(null);
        if(articleInfo == null){
            return 0;
        }
        articleComment.setArticleInfo(articleInfo);
        articleCommentRepository.save(articleComment);
        return 1;
    }

    @Override
    public ArticleComment findById(long id) {

        return articleCommentRepository.findById(id).orElse(null);
    }

}
