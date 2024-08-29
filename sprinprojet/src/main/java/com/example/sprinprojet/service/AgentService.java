package com.example.sprinprojet.service;

import com.example.sprinprojet.Repository.AgentRepository;
import com.example.sprinprojet.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public Agent saveAgent(Agent agent){
        return agentRepository.save(agent);
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Agent updateAgent(Agent agent) {
        return agentRepository.save(agent);
    }
    public Agent getAgentById(long idAgent) {
        return agentRepository.findById(idAgent).orElse(null);
    }
    
    public void deleteAgentById(Long idAgent) {
        agentRepository.deleteById(idAgent);
    }
    

}
