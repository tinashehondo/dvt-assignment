package za.co.discovery.api.services.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.discovery.model.Planet;
import za.co.discovery.model.Route;
import za.co.discovery.service.planet.PlanetService;
import za.co.discovery.service.route.RouteService;

import java.util.List;

/**
 * Created by tinashehondo on 4/9/17.
 */
@Controller
@RequestMapping("/route")
public class RouteRestApi {

    private static final  Logger logger = LoggerFactory.getLogger(RouteRestApi.class);

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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Route>> getAll(){
        //LOG.info("getting user with id: {}", id);
        List<Route> routes = routeService.findAllRoutes();

        if (routes == null || routes.isEmpty()){

            return new ResponseEntity<List<Route>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Route>>(routes,HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Route> get(@PathVariable("id") Integer id){
        logger.info("get route . route with id {} ", id);
        Route route = routeService.findRouteById(id);

        if (route == null){
            return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Route>(route, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Route route){
        logger.info("create Route . Route with planet {} ", route);
        routeService.saveRoute(route);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Route> update(@PathVariable Integer id, @RequestBody Route route ){
        Route currentRoute = routeService.findRouteById(id);

        if (currentRoute == null){

            return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
        }
        currentRoute.setDestination(route.getDestination());
        currentRoute.setOrigin(route.getOrigin());
        currentRoute.setDestination(route.getDestination());


        routeService.saveRoute(route);
        return new ResponseEntity<Route>(currentRoute, HttpStatus.OK);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        Route route = routeService.findRouteById(id);

        if (route == null){
            logger.info("Unable to delete. Route with id {} not found", id);
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        routeService.deleteRoute(route);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
