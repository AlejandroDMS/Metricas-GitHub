package com.zero.backend.negocio.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api")
// Permitimos que nuestro frontend de React en el puerto 5173 acceda a este controlador
@CrossOrigin(origins = "http://localhost:5173")
public class TestController {

    @GetMapping("/status")
    public Map<String, String> getStatus() {
        return Map.of(
            "status", "UP",
            "message", "Conexión exitosa entre React y Spring Boot"
        );
    }
}
