package com.github.willyancaetano.planets.api.client;

import com.github.willyancaetano.planets.api.dto.PlanetsIntegrationResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "swapi", url = "${external.api.planets.url}")
public interface PlanetClient {

    @GetMapping("api/planets")
    PlanetsIntegrationResponseDTO getInfoPlanet(@RequestHeader("name") String name);
}
