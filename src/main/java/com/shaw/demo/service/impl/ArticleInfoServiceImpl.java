package com.shaw.demo.service.impl;

import com.shaw.demo.model.*;
import com.shaw.demo.repository.*;
import com.shaw.demo.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {
    @Autowired
    private ArticleInfoRepository articleInfoRepository;

    @Autowired
    private ArticleCommentRepository articleCommentRepository;

    @Autowired
    private ArticleContentRepository articleContentRepository;

    @Autowired
    private ArticleSortRepository articleSortRepository;

    @Autowired
    private ArticlePictureRepository articlePictureRepository;

    @Override
    public int createArticleInfo(ArticleInfo articleInfo) {
        articleInfoRepository.save(articleInfo);
        return 1;
    }

    @Override
    public int deleteArticleInfo(long articleId) {
        ArticleInfo articleInfo = articleInfoRepository.findById(articleId).orElse(null);
        List<ArticleComment> comments = articleInfo.getComments();
        comments.forEach((comment) -> {
            articleCommentRepository.deleteById(comment.getId());
        });

        articleContentRepository.deleteById(articleInfo.getArticleContent().getId());

        List<ArticleSort> sorts = articleInfo.getSorts();
        sorts.forEach((sort) -> {
            articleSortRepository.deleteById(sort.getId());
        });

        List<ArticlePicture> pictures = articleInfo.getPictures();
        pictures.forEach((picture) -> {
            articlePictureRepository.deleteById(picture.getId());
        });

        articleInfoRepository.deleteById(articleId);
        return 1;
    }

    @Override
    public int changeContent(long articleId, ArticleContent articleContent) {
        ArticleInfo articleInfo = articleInfoRepository.findById(articleId).orElse(null);
        if(articleInfo == null){
            return 0;
        }
        articleInfo.setArticleContent(articleContent);
        articleInfoRepository.save(articleInfo);
        return 1;
    }

//    @Override
//    public int addComment(long articleId, ArticleComment articleComment) {
//        ArticleInfo articleInfo = articleInfoRepository.findById(articleId).orElse(null);
//        if(articleInfo == null){
//            return 0;
//        }
//        articleInfo.getComments().add(articleComment);
//        articleInfoRepository.save(articleInfo);
//        return 1;
//    }
//
//    @Override
//    public int deleteComment(long articleId, long commentId) {
//        ArticleInfo articleInfo = articleInfoRepository.findById(articleId).orElse(null);
//        if(articleInfo == null){
//            return 0;
//        }
//        List<ArticleComment> comments = articleInfo.getComments();
//        List<ArticleComment> newComments = comments.stream().filter(comment -> comment.getId() != commentId).collect(Collectors.toList());
//        articleInfo.setComments(newComments);
//        articleInfoRepository.save(articleInfo);
//        return 1;
//    }

    @Override
    public List<ArticleComment> getAllCommentsFromArticle(long articleId) {
        ArticleInfo articleInfo = articleInfoRepository.findById(articleId).orElse(null);
        if(articleInfo == null){
            return null;
        }
        return articleInfo.getComments();
    }

    @Override
    public Page<ArticleInfo> getArticlePage(long articleId, int pageNum, int pageSize) {
        Pageable page = PageRequest.of(pageNum, pageSize);
        return articleInfoRepository.findAll(page);
    }

    @Override
    public Page<ArticleInfo> getRecentArticle(int pageSize) {
        Pageable page = PageRequest.of(0, pageSize, Sort.Direction.DESC, "createBy");
        return articleInfoRepository.findAll(page);
    }

    @Override
    public List<ArticleInfo> getAllArticle() {
        List<ArticleInfo> result = (List<ArticleInfo>) articleInfoRepository.findAll();
        return result;
    }

    @Override
    public ArticleInfo getArticleById(long id) {
        ArticleInfo articleInfo = articleInfoRepository.findById(id).orElse(null);
        if(articleInfo != null){
            return articleInfo;
        }
        return null;
    }

    @Override
    public ArticleInfo getArticleByTitle(String title) {
        List<ArticleInfo> articleInfos = articleInfoRepository.findByTitle(title);
        if(articleInfos.size() > 0){
            return articleInfos.get(0);
        }
        return null;
    }
}
