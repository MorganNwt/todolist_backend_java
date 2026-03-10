package com.cda.todolist_backend_java.repository;

import com.cda.todolist_backend_java.entity.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Spring va générer automatiquement save(), findById(), findAll(), deleteById(), etc...
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    // Spring Dta JPA va générer automatiquement la requête SQL pour trouver un utilisateur par son username ou son email

}

