package za.co.discovery.web.convertors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import za.co.discovery.assignment.assignment.ws.client.Planet;

/**
 * Created by tinashehondo on 4/18/17.
 */
@Component
public class PlanetToPlanetModel implements Converter<za.co.discovery.assignment.assignment.ws.client.Planet,za.co.discovery.model.Planet> {

    public za.co.discovery.model.Planet convert(za.co.discovery.assignment.assignment.ws.client.Planet planet) {
        za.co.discovery.model.Planet outputPlanet = new za.co.discovery.model.Planet();
        outputPlanet.setNode(planet.getNode());
        outputPlanet.setName(planet.getName());
        return outputPlanet;
    }


}
