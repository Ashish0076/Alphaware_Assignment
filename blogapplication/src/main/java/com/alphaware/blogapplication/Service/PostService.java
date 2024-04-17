package com.alphaware.blogapplication.Service;

import java.util.List;

import com.alphaware.blogapplication.Exceptions.ResourceNotFoundException;
import com.alphaware.blogapplication.Model.Post;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id) throws ResourceNotFoundException;
    Post createPost(Post post);
    Post updatePost(Long id, Post post) throws ResourceNotFoundException;
    void deletePost(Long id) throws ResourceNotFoundException;
}
