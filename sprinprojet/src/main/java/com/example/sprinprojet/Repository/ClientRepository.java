package com.example.sprinprojet.Repository;


import com.example.sprinprojet.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Optional<Client> findByEmail(String email);
    Client findByEmail(String email);  // Retourne directement un Client
    Optional<Client> findByEmailAndPassword(String email, String password);
}
