/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.Api.repository;

import com.garcia.Api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alexgaralv
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
