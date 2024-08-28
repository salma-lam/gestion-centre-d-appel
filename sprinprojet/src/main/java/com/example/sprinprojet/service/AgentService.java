package com.example.sprinprojet.service;

import com.example.sprinprojet.Repository.AgentRepository;
import com.example.sprinprojet.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AgentService {
    // code de votre service
    @Autowired
    private AgentRepository agentRepository;
    public List<Agent> getAllAgent() {
        return agentRepository.findAll();
    }

    public Agent updateAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public Agent getAgentById(Long idAgent) {
        return agentRepository.findById(idAgent).orElse(null);
    }
}
