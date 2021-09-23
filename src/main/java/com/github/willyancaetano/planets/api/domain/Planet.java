package com.github.willyancaetano.planets.api.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planets")
public final class Planet {

    @Id
    private String id;

    private final String name;

    private final String climate;

    private final String terrain;

    private final Integer films;

    public Planet(final String name, final String climate, final String terrain, final Integer films) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.films = films;
    }

    public final String getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final String getClimate() {
        return climate;
    }

    public final String getTerrain() {
        return terrain;
    }

    public Integer getFilms() {
        return films;
    }

}
