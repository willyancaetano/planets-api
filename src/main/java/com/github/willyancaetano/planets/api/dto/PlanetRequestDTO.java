package com.github.willyancaetano.planets.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;

public final class PlanetRequestDTO implements RequestDTO {

    private final String name;

    private final String climate;

    private final String terrain;

    public PlanetRequestDTO(@JsonProperty("name") final String name,
        @JsonProperty("climate") final String climate,
        @JsonProperty("terrain") final String terrain) {
        this.name = StringUtils.capitalize(name.trim());
        this.climate = climate.trim();
        this.terrain = terrain.trim();
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

}
