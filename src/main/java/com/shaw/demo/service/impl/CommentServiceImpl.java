package com.shaw.demo.service.impl;

import com.shaw.demo.model.Comment;
import com.shaw.demo.repository.CommentRepository;
import com.shaw.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public int createMessage(Comment comment) {
        commentRepository.saveAndFlush(comment);
        return 1;
    }

    @Override
    public int deleteMessage(long messageId) {
        commentRepository.deleteById(messageId);
        return 1;
    }

    @Override
    public int modifyMessage(long messageId, Comment comment) {
        comment.setId(messageId);
        commentRepository.save(comment);
        return 1;
    }

    @Override
    public Comment findById(long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        return comment;
    }
}
