package com.example.sprinprojet.Repository;

import com.example.sprinprojet.model.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
    Technicien findByEmail(String email);
}
