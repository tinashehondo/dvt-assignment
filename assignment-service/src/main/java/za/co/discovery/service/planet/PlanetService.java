package za.co.discovery.service.planet;


import za.co.discovery.model.Planet;

import java.util.List;

/**
 * Created by tinashehondo on 4/9/17.
 */

public interface PlanetService {
    Planet savePlanet(Planet planet);
    Planet findPlanetById(String id);
    List<Planet> findAllPlanets();
    void deletePlanet(Planet planet);
}
