package com.example.easynotes.controller;

import com.example.easynotes.model.Category;
import com.example.easynotes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by amer on 2/18/18.
 */

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    // Get all categories
    @GetMapping("/categories")
    public List<Category> getAllCategories(){ return categoryRepository.findAll(); }

    // Create a new category
    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category category){ return categoryRepository.save(category); }

    // Get a single category
    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value="id") Long categoryId){
        Category category = categoryRepository.findOne(categoryId);
        if(category==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category);
    }

    // Update a category
    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(value="id") Long categoryId,
                                                   @Valid @RequestBody Category categoryDetails){
        Category category = categoryRepository.findOne(categoryId);
        if(category==null){
            return ResponseEntity.notFound().build();
        }
        category.setName(categoryDetails.getName());

        Category updatedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(updatedCategory);
    }

    // Delete a category
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable(value="id") Long categoryId){
        Category category = categoryRepository.findOne(categoryId);
        if(category==null){
            return ResponseEntity.notFound().build();
        }

        categoryRepository.delete(category);
        return ResponseEntity.ok().build();
    }

}
