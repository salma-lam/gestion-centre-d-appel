package com.example.sprinprojet.Repository;

import com.example.sprinprojet.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo  extends JpaRepository<Produit, Long> {
}
