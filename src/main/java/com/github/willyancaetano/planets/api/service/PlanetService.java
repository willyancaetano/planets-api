package com.github.willyancaetano.planets.api.service;

import com.github.willyancaetano.planets.api.client.PlanetClient;
import com.github.willyancaetano.planets.api.domain.Planet;
import com.github.willyancaetano.planets.api.dto.PlanetRequestDTO;
import com.github.willyancaetano.planets.api.dto.PlanetsIntegrationResponseDTO;
import com.github.willyancaetano.planets.api.repository.PlanetRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    private final PlanetRepository repository;
    private final PlanetClient client;

    public PlanetService(final PlanetRepository repository, final PlanetClient client) {
        this.repository = repository;
        this.client = client;
    }

    public List<Planet> findAllPlanets(final int page, final int size) {
        return repository.findAll(PageRequest.of(page, size)).getContent();
        //TODO 404
    }

    public Planet findByName(final String name) {
        Optional<Planet> planetOptional = repository.findByName(name);

        if(!planetOptional.isPresent()){
            //TODO exception
        }

        return planetOptional.get();
    }

    public Planet findById(final String id) {
        Optional<Planet> planetOptional = repository.findById(id);

        if(!planetOptional.isPresent()){
            //TODO exception
        }

        return planetOptional.get();
    }

    public void deleteById(final String id) {
        repository.deleteById(id);
    }

    public String createPlanet(final PlanetRequestDTO planetRequestDTO) {

        Optional<Planet> optionalPlanet = repository.findByName(planetRequestDTO.getName());

        if(optionalPlanet.isPresent()){
            //Conflict
        }

        PlanetsIntegrationResponseDTO infoPlanet = client.getInfoPlanet(planetRequestDTO.getName());

        Planet planet = new Planet(planetRequestDTO.getName(), planetRequestDTO.getClimate(), planetRequestDTO.getTerrain(), infoPlanet.getFilms());

        return repository.save(planet).getId();
    }

}
