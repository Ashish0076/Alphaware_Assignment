package com.alphaware.blogapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alphaware.blogapplication.Model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
}
