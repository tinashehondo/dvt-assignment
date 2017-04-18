package za.co.discovery.api.services.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Route>> getAllRoutes(){
        logger.info("getting all Routes:");
        List<Route> routes = routeService.findAllRoutes();

        if (routes == null || routes.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(routes,HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Route> get(@PathVariable("id") Integer id){
        logger.info("get route . route with id {} ", id);
        Route route = routeService.findRouteById(id);

        if (route == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(route, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Route route){
        logger.info("create Route . Route with routes {} ", route);
        routeService.saveRoute(route);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Route> update(@PathVariable Integer id, @RequestBody Route route ){
        Route currentRoute = routeService.findRouteById(id);

        if (currentRoute == null){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentRoute.setDestination(route.getDestination());
        currentRoute.setOrigin(route.getOrigin());
        currentRoute.setDestination(route.getDestination());


        routeService.saveRoute(route);
        return new ResponseEntity<>(currentRoute, HttpStatus.OK);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        Route route = routeService.findRouteById(id);

        if (route == null){
            logger.info("Unable to delete. Route with id {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        routeService.deleteRoute(route);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
