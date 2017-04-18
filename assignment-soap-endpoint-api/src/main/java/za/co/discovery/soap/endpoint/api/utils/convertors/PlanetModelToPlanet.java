package za.co.discovery.soap.endpoint.api.utils.convertors;

import org.springframework.core.convert.converter.Converter;
import discovery.assignment.api.soap.Planet;
import org.springframework.stereotype.Component;

/**
 * Created by tinashehondo on 4/18/17.
 */
@Component
public class PlanetModelToPlanet implements Converter<za.co.discovery.model.Planet,discovery.assignment.api.soap.Planet> {
    @Override
    public discovery.assignment.api.soap.Planet convert(za.co.discovery.model.Planet planet) {
        discovery.assignment.api.soap.Planet outputPlanet = new discovery.assignment.api.soap.Planet();
        outputPlanet.setNode(planet.getNode());
        outputPlanet.setName(planet.getName());
        return outputPlanet;
    }

}
