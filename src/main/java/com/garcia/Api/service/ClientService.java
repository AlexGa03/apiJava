/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.Api.service;
import com.garcia.Api.model.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garcia.Api.repository.ClientRepository;
/**
 *
 * @author alexgaralv
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    
    public List<Client>listClients(){
        return repository.findAll();
     
    }
    public void saveClients(Client client){
        repository.save(client);
    }
    public Client getClientById(Integer id){
        return repository.findById(id).get();
    }
    public void editClientById(Client client,Integer id){
        repository.findById(id);
    }
    public void deleteClient (Integer id){
        repository.deleteById(id);
    }
    
}
