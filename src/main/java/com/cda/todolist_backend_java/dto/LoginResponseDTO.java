package com.cda.todolist_backend_java.dto;

public class LoginResponseDTO {
    private String token;

    public LoginResponseDTO() {}

    public LoginResponseDTO(String token) {
        this.token = token;
    }


    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    
}
   


