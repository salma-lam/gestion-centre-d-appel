package com.example.sprinprojet.service;


import com.example.sprinprojet.Repository.ClientRepository;
import com.example.sprinprojet.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Register Client
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public boolean emailExists(String email) {
        return clientRepository.findByEmail(email) != null;
    }

    // Modifier profil

 
    public void updateClient(Client client) {
        clientRepository.save(client); // Assurez-vous que cette méthode gère correctement l'update
    }
    

    public Client getClientById(Long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);  // Retourne un Client
    }
    
}