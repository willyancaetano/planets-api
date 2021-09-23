package com.github.willyancaetano.planets.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class PlanetsIntegrationResponseDTO {

    @JsonProperty("results")
    private final Result[] results;

    @JsonCreator
    public PlanetsIntegrationResponseDTO(@JsonProperty("results") final Result[] results) {
        this.results = results;
    }

    public int getFilms() {
        return List.of(results).stream().mapToInt(Result::getSizeFilms).sum();
    }
}

final class Result implements DTO {

    final String[] films;

    @JsonCreator
    public Result(@JsonProperty("films") final String[] films) {
        this.films = films;
    }

    public int getSizeFilms() {
        return this.films.length;
    }

}

