/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.Api.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alexgaralv
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table (name = "product")
public class Product {
    public Integer getId() {
        return Id;
    }
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;
    
    @Column(name = "product")
    private String product;
    
     @Column(name = "price")
    private double price;
    
}
