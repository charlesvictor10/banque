package dev.charles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.charles.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
}
