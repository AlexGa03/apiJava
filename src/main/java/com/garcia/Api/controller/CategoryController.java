/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.Api.controller;
import com.garcia.Api.model.Category;
import com.garcia.Api.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author alexgaralv
 */
@RestController
@RequiredArgsConstructor
public class CategoryController {
     private final CategoryService categoryService;
//Category
    @GetMapping("/Category")
    public List<Category> listCategorys() {
        return categoryService.listCategories();
    }

    @GetMapping("/Category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer id) {
        try {
            Category category = categoryService.getCategoryById(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/Category")
    public void newCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @PutMapping("/Category/{id}")
    public ResponseEntity<?> editCategory(@RequestBody Category category, @PathVariable Integer id) {
        try {
            Category categoryExists = categoryService.getCategoryById(id);
                categoryExists.setCategory(category.getCategory());
            categoryService.saveCategory(categoryExists);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Category/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
    
}
