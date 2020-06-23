package com.shaw.demo.controller;

import com.shaw.demo.common.CommonResult;
import com.shaw.demo.model.*;
import com.shaw.demo.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "Article controller")
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    private ArticleInfoService articleInfoService;

    @Autowired
    private ArticleCommentService articleCommentService;

    @Autowired
    private ArticlePictureService articlePictureService;

    @Autowired
    private ArticleSortService articleSortService;

    @Autowired
    private ArticleContentService articleContentService;

    @ApiOperation("Create new article.")
    @RequestMapping(value = "/createArticle", method = RequestMethod.POST)
    public CommonResult createArticle(@RequestBody ArticleInfo articleInfo, @RequestBody ArticleContent articleContent,
                                      @RequestBody ArticlePicture articlePicture){
        try{
            articleContentService.createContent(articleContent);
            articleInfo.setArticleContent(articleContent);
            articlePictureService.createPicture(articlePicture);
            List<ArticlePicture> pictures = new ArrayList<>();
            pictures.add(articlePicture);
            articleInfo.setPictures(pictures);
            articleInfo.setComments(new ArrayList<ArticleComment>());
            articleInfo.setSorts(new ArrayList<ArticleSort>());
            articleInfoService.createArticleInfo(articleInfo);
            return CommonResult.success(articleInfo, "Create article successfully.");
        } catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }
    }

    @ApiOperation("List all articles.")
    @RequestMapping(value = "/getArticle/list", method = RequestMethod.GET)
    public CommonResult getArticleList(){
        List<ArticleInfo> result = articleInfoService.getAllArticle();
        return CommonResult.success(result, "Get all article information.");
    }

    @ApiOperation("Get the recent articles in page.")
    @RequestMapping(value = "/getRecentArticle", method = RequestMethod.GET)
    public CommonResult getRecent(){
        Page<ArticleInfo> result = articleInfoService.getRecentArticle(10);
        if(result.getSize() == 0){
            return CommonResult.failed("No any result");
        }
        return CommonResult.success(result, "Here are articles.");
    }

    @ApiOperation("Delete article by article ID.")
    @RequestMapping(value = "/deleteArticle/{id}", method = RequestMethod.DELETE)
    public CommonResult deleteArticle(@PathVariable long articleId){
        try{
            articleInfoService.deleteArticleInfo(articleId);
            return CommonResult.success(null, "Deleted.");
        } catch (Exception e){
            return CommonResult.failed(e.getMessage());
        }
    }

    @ApiOperation("Get article content.")
    @RequestMapping(value = "/getArticleContent/{id}", method = RequestMethod.GET)
    public CommonResult getArticleContent(@PathVariable long id){
        ArticleInfo articleInfo = articleInfoService.getArticleById(id);
        if(articleInfo == null){
            return CommonResult.failed("No searching result.");
        }
        return CommonResult.success(articleInfo.getArticleContent().getContent(), "Here is content");
    }

    @ApiOperation("Edit article.")
    @RequestMapping(value = "editArticle/{id}", method = RequestMethod.PUT)
    public CommonResult editArticleContent(@PathVariable long id, @RequestParam String newContent){
        ArticleInfo articleInfo = articleInfoService.getArticleById(id);
        if(articleInfo == null){
            return CommonResult.failed("No article found.");
        }
        ArticleContent articleContent = articleInfo.getArticleContent();
        articleContent.setContent(newContent);
        articleContentService.changeContent(articleContent.getId(), articleContent);
        return CommonResult.success(articleContent, "Change successfully.");
    }

}
