/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.Api.controller;

import com.garcia.Api.model.Product;
import com.garcia.Api.service.ProductService;
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
//Client
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
//Product
    @GetMapping("/Product")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("/Product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/Product")
    public void newProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PutMapping("/Product/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product productExists = productService.getProductById(id);
            if (product.getProduct() != null) {
                productExists.setProduct(product.getProduct());
            }
            if (product.getPrice() != 0) {
                productExists.setPrice(product.getPrice());
            }
            if (product.getCategory_id() != null) {
                productExists.setCategory_id(product.getCategory_id());
            }
            
            productService.saveProduct(productExists);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Product/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
}
