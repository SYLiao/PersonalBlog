package com.shaw.demo.controller;

import com.shaw.demo.common.CommonResult;
import com.shaw.demo.model.ArticleComment;
import com.shaw.demo.model.ArticleInfo;
import com.shaw.demo.model.Comment;
import com.shaw.demo.service.ArticleCommentService;
import com.shaw.demo.service.ArticleInfoService;
import com.shaw.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleInfoService articleInfoService;

    @Autowired
    private ArticleCommentService articleCommentService;

    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public CommonResult createComment(@RequestBody Comment comment, @RequestParam String title){
        commentService.createMessage(comment);
        ArticleComment articleComment = new ArticleComment();
        articleComment.setComment(comment);
        ArticleInfo articleInfo = articleInfoService.getArticleByTitle(title);
        articleCommentService.createComment(articleInfo, comment);
        return CommonResult.success(comment, "");
    }

    @RequestMapping(value = "/deleteComment/{id}", method = RequestMethod.DELETE)
    public CommonResult deleteComment(@PathVariable long id){
        ArticleComment comment = articleCommentService.findById(id);
        Comment message = comment.getComment();
        commentService.deleteMessage(message.getId());
        articleCommentService.deleteComment(id);
        return CommonResult.success(null, "");
    }

    @RequestMapping(value = "/getComment/{id}", method = RequestMethod.GET)
    public CommonResult getComment(@PathVariable long id){
        ArticleComment comment = articleCommentService.findById(id);
        return CommonResult.success(comment.getComment(), "Here are the comment");
    }
}
