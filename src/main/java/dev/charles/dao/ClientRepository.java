package dev.charles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.charles.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
