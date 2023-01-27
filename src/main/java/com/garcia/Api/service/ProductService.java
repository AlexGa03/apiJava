/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.Api.service;
import com.garcia.Api.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garcia.Api.repository.ProductRepository;
/**
 *
 * @author alexgaralv
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository Prepository;
    
    public List<Product>listProducts(){
        return Prepository.findAll();
    
    }
    public void saveProduct(Product product){
        Prepository.save(product);
    }
    public Product getProductById(Integer id){
        return Prepository.findById(id).get();
    }
    public void deleteProduct (Integer id){
        Prepository.deleteById(id);
    }
    
}
