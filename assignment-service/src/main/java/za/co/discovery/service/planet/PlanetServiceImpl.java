package za.co.discovery.service.planet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.discovery.model.Planet;
import za.co.discovery.repository.planet.PlanetRepository;

import java.util.List;

/**
 * Created by tinashehondo on 4/9/17.
 */
@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    public Planet savePlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    public Planet findPlanetById(String id) {
        return planetRepository.findPlanetByNode(id);
    }

    public List<Planet> findAllPlanets() {
        return planetRepository.findAll();
    }

    public Planet updatePlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    public void deletePlanet(Planet planet) {
        planetRepository.delete(planet);
    }
}
