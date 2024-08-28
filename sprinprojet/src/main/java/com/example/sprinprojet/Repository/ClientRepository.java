package com.example.sprinprojet.Repository;


import com.example.sprinprojet.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);

    Optional<Client> findByEmailAndPassword(String email, String password);
}
