package com.cda.todolist_backend_java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
        // Endpoint de test pour vérifier que le backend fonctionne
        @GetMapping("/api/test")
        public String securitytEndpoint() {
            return "Accès autorisé";
        }
}
