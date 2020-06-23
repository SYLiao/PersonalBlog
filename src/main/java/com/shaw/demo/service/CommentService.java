package com.shaw.demo.service;

import com.shaw.demo.model.Comment;

public interface CommentService {
    int createMessage(Comment comment);

    int deleteMessage(long messageId);

    int modifyMessage(long messageId, Comment comment);

    Comment findById(long id);
}
