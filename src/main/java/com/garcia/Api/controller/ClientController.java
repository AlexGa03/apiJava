/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.Api.controller;

import com.garcia.Api.model.Client;
import com.garcia.Api.service.ClientService;
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
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/Client")
    public List<Client> listClients() {
        return clientService.listClients();
    }

    @GetMapping("/Client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Integer id) {
        try {
            Client client = clientService.getClientById(id);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("Client/{id}")
    public void newClient(@RequestBody Client client) {
        clientService.saveClients(client);
    }

    @PutMapping("Client/{id}")
    public ResponseEntity<?> editClient(@RequestBody Client client, @PathVariable Integer id) {
        try {
            Client clientExists = clientService.getClientById(id);
            if (client.getFirst_name() != null) {
                clientExists.setFirst_name(client.getFirst_name());
            }
            if (client.getLast_name() != null) {
                clientExists.setLast_name(client.getLast_name());
            }
            if (client.getEmail() != null) {
                clientExists.setEmail(client.getEmail());
            }
            if (client.getCountry() != null) {
                clientExists.setCountry(client.getCountry());
            }
            if (client.getIp_address() != null) {
                clientExists.setIp_address(client.getIp_address());
            }
            clientService.saveClients(clientExists);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Client/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
