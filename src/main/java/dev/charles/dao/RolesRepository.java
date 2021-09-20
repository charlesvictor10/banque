package dev.charles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.charles.entities.Roles;

public interface RolesRepository extends JpaRepository<Roles, String> {

}
