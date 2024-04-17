package com.alphaware.blogapplication.Service;

import java.util.List;

import com.alphaware.blogapplication.Exceptions.ResourceNotFoundException;
import com.alphaware.blogapplication.Model.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id) throws ResourceNotFoundException;
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category) throws ResourceNotFoundException;
    void deleteCategory(Long id) throws ResourceNotFoundException;
}
