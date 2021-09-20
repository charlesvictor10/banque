package dev.charles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.charles.entities.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

}
