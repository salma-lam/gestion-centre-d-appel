package com.example.sprinprojet.service;

import com.example.sprinprojet.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private ReclamationRepository reclamationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public long getNumberOfReclamations() {
        return reclamationRepository.count();
    }

    public long getNumberOfClients() {
        return clientRepository.count();
    }

    public long getNumberOfAdmins() {
        return adminRepository.count();
    }

    public long getNumberOfAgents() {
        return agentRepository.count();
    }

    public long getNumberOfTickets() {
        return ticketRepository.count();
    }
}
