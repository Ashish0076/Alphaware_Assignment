package com.alphaware.blogapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alphaware.blogapplication.Model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
}