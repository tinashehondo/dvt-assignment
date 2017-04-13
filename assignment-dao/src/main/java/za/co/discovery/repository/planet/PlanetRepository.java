package za.co.discovery.repository.planet;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.discovery.model.Planet;

/**
 * Created by tinashehondo on 4/9/17.
 */

public interface PlanetRepository extends JpaRepository<Planet,String> {
    Planet findPlanetByNode(String node);
}
