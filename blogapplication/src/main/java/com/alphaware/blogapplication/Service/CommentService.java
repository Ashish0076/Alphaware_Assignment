package com.alphaware.blogapplication.Service;

import java.util.List;

import com.alphaware.blogapplication.Exceptions.ResourceNotFoundException;
import com.alphaware.blogapplication.Model.Comment;

public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(Long id) throws ResourceNotFoundException;
    Comment createComment(Comment comment);
    Comment updateComment(Long id, Comment comment) throws ResourceNotFoundException;
    void deleteComment(Long id) throws ResourceNotFoundException;
}
