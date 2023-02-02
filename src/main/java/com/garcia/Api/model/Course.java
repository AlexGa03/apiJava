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

public class Course {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    private Integer id;
    private String cname;
    private String codeC;
    private double price;
    private String category;
    private boolean isActive;
    private String img_url;
    private String description;

    
    
}
