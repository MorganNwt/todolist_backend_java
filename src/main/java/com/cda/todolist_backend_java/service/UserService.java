package com.cda.todolist_backend_java.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cda.todolist_backend_java.dto.LoginRequestDTO;
import com.cda.todolist_backend_java.dto.LoginResponseDTO;
import com.cda.todolist_backend_java.entity.User;
import com.cda.todolist_backend_java.exception.EmailAlreadyExistsException;
import com.cda.todolist_backend_java.exception.InvalidCredentialsException;
import com.cda.todolist_backend_java.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO registerUser(User user) {

        // Vérifier si l'email existe déjà
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        // Encoder le mot de passe avant de sauvegarder
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Sauvegarder l'utilisateur dans la base de données
        User savedUser = userRepository.save(user);

        // Retourner les informations de l'utilisateur enregistré (sans le mot de passe)
        return new UserResponseDTO(
            savedUser.getId(),
            savedUser.getUsername(),
            savedUser.getEmail()
        );
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
            .orElseThrow(() -> new InvalidCredentialsException("Email ou mot de passe invalide"));

       boolean passwordMatches = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if (!passwordMatches) {
            throw new InvalidCredentialsException("Email ou mot de passe invalide");
        }

        return new LoginResponseDTO("Login successful");
    }



}
