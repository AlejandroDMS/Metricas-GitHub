package com.zero.backend.servicios;

import com.zero.backend.persistencia.dtos.MetricasDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicioGitHub {
    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiToken;

    public ServicioGitHub(
            @Value("${github.api.url}") String apiUrl,
            @Value("${github.api.token}") String apiToken) {
        this.apiUrl = apiUrl;
        this.apiToken = apiToken;
        this.restTemplate = new RestTemplate();
    }

    public MetricasDTO getMetricasGitHub(String propietario, String repositorio) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(apiToken);
            headers.set("Accept", "application/vnd.github+json");
            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<MetricasDTO> response = restTemplate.exchange(
                    apiUrl + "/repos/{owner}/{repo}",
                    HttpMethod.GET,
                    requestEntity,
                    MetricasDTO.class,
                    propietario,
                    repositorio
            );

            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error al acceder a las metricas - GitHub responded with status "
                    + e.getStatusCode() + ": " + e.getResponseBodyAsString(), e);
        } catch (RestClientException e) {
            throw new RuntimeException("Error al acceder a las metricas - " + e.getMessage(), e);
        }
    }
}
