package com.alphaware.blogapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alphaware.blogapplication.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
