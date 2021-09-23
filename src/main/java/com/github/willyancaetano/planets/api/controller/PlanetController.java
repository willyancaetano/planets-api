package com.github.willyancaetano.planets.api.controller;

import com.github.willyancaetano.planets.api.domain.Planet;
import com.github.willyancaetano.planets.api.dto.PlanetRequestDTO;
import com.github.willyancaetano.planets.api.service.PlanetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/planets")
public class PlanetController {

    private final PlanetService service;

    public PlanetController(final PlanetService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createPlanet(@RequestBody PlanetRequestDTO planetRequestDTO) {
        String id = service.createPlanet(planetRequestDTO);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri().toString() + "/v1/planets/id/" + id);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Planet>> findAllPlanets(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size){

        List<Planet> allPlanets = this.service.findAllPlanets(page, size);

        return ResponseEntity.ok(allPlanets);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Planet> findByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Planet> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
