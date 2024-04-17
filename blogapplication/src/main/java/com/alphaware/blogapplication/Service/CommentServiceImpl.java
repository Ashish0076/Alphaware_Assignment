package com.alphaware.blogapplication.Service;

import com.alphaware.blogapplication.Model.Comment;
import com.alphaware.blogapplication.Repository.CommentRepository;
import com.alphaware.blogapplication.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) throws ResourceNotFoundException {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
    }

    @Override
    public Comment createComment(Comment comment) {
        // Implement comment creation logic here
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment comment) throws ResourceNotFoundException {
        if (!commentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Comment not found with id: " + id);
        }
        comment.setId(id);
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) throws ResourceNotFoundException {
        if (!commentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Comment not found with id: " + id);
        }
        commentRepository.deleteById(id);
    }
}

