package za.co.discovery.api.services.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.discovery.model.Planet;
import za.co.discovery.model.Route;
import za.co.discovery.service.planet.PlanetService;
import za.co.discovery.service.route.RouteService;

/**
 * Created by tinashehondo on 4/9/17.
 */
@Controller
@RequestMapping("/route")
public class RouteRestApi {

    private final static Logger logger = LoggerFactory.getLogger(RouteRestApi.class);

    @Autowired
    private PlanetService planetService;

    @Autowired
    private RouteService routeService;


    @RequestMapping(value = {"/test/"}, method = RequestMethod.GET)
    public String test(Model model){
        logger.debug("**********************testing");

        Planet planet1 = new Planet();
        planet1.setNode("A");
        // planet.setName("A");
        planet1.setName("EARTH");

        planetService.savePlanet(planet1);

        Planet planet2 = new Planet();
        planet2.setNode("B");
        // planet.setName("A");
        planet2.setName("MARS");
        planetService.savePlanet(planet2);

        Route route = new Route();

        route.setOrigin(planet1);
        route.setDestination(planet2);
        route.setDistance(1.44);

        logger.debug("**********************testing*****"+routeService.saveRoute(route));
        return "index";
    }
}
