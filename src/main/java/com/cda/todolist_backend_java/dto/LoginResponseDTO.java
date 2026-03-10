package com.cda.todolist_backend_java.dto;

public class LoginResponseDTO {
    private String message;

    public LoginResponseDTO() {}

    public LoginResponseDTO(String message) {
        this.message = message;
    }


    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
