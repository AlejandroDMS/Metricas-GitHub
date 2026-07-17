package com.zero.backend.negocio.controladores;

import com.zero.backend.persistencia.dtos.MetricasDTO;
import com.zero.backend.servicios.ServicioGitHub;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/metrics")
@CrossOrigin(origins = "http://localhost:5173")
public class ControladorCUObtenerMetricas {

    private final ServicioGitHub githubService;

    // Inyección de dependencias por constructor (Estándar de calidad en Spring)
    public ControladorCUObtenerMetricas(ServicioGitHub githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/repo")
    public MetricasDTO getRepoMetrics(
            @RequestParam String owner,
            @RequestParam String repo) {
        return githubService.getMetricasGitHub(owner, repo);
    }
}
