package com.alphaware.blogapplication.Controller;

import com.alphaware.blogapplication.Exceptions.ResourceNotFoundException;
import com.alphaware.blogapplication.Model.Post;
import com.alphaware.blogapplication.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) throws ResourceNotFoundException {
        Post post = postService.getPostById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return new ResponseEntity<>(createdPost,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) throws ResourceNotFoundException {
        Post updatedPost = postService.updatePost(id, post);
        return new ResponseEntity<>(updatedPost,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id) throws ResourceNotFoundException {
    	Post post = postService.getPostById(id);   	
    	if(post!=null) {
    		postService.deletePost(id);
    	}
        
        return  new ResponseEntity<>(post, HttpStatus.OK);
    }
}

