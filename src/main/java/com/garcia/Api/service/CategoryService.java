/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.Api.service;

import com.garcia.Api.model.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garcia.Api.repository.CategoryRepository;
/**
 *
 * @author alexgaralv
 */
@Service
public class CategoryService {
     @Autowired
    private CategoryRepository Crepository;
    
    public List<Category>listCategories(){
        return Crepository.findAll();
    
    }
    public void saveCategory(Category category){
        Crepository.save(category);
    }
    public Category getCategoryById(Integer id){
        return Crepository.findById(id).get();
    }
    public void deleteCategory (Integer id){
        Crepository.deleteById(id);
    }
}
