package com.zero.backend.persistencia.dtos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public record MetricasDTO (
    String nombre,
    @JsonProperty("full_name") String nombreCompleto,
    @JsonProperty("stargazers_count") int numEstrellas,
    @JsonProperty("open_issues_count") int issuesAbiertas,
    String descripcion,
    @JsonProperty("html_url") String htmlUrl
) {}
