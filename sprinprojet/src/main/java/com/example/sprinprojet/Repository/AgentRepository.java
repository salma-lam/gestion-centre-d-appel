package com.example.sprinprojet.Repository;

import com.example.sprinprojet.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    Agent findByEmail(String email);
}
