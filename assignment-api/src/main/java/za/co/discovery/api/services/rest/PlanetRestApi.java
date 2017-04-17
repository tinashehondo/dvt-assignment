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
import za.co.discovery.service.planet.PlanetService;

import java.util.List;

/**
 * Created by tinashehondo on 4/9/17.
 */
@Controller
@RequestMapping("/planet/")
public class PlanetRestApi {

    private static final Logger logger = LoggerFactory.getLogger(PlanetRestApi.class);


    @Autowired
    private PlanetService planetService;

    @RequestMapping(value = {"/test/"}, method = RequestMethod.GET)
    public String test(Model model){
        logger.info("**********************testing");
        Planet planet = new Planet();
        planet.setNode("B");
        planet.setName("ZIM");
        System.out.print("**********************testing");
        System.out.print("**********************testing*****"+planetService.savePlanet(planet));
        return "index";
    }



    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Planet>>getAll(){
        //LOG.info("getting user with id: {}", id);
        List<Planet> planets = planetService.findAllPlanets();

        if (planets == null || planets.isEmpty()){

            return new ResponseEntity<List<Planet>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Planet>>(planets,HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Planet> get(@PathVariable("id") String id){
        logger.info("get Planet . Planet with id {} ", id);
        Planet planet = planetService.findPlanetById(id);

        if (planet == null){
            return new ResponseEntity<Planet>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Planet>(planet, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Planet planet){
        logger.info("create Planet . Planet with planet {} ", planet);
        planetService.savePlanet(planet);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Planet> update(@PathVariable String id, @RequestBody Planet planet){
        Planet currentPlanet = planetService.findPlanetById(id);

        if (currentPlanet == null){

            return new ResponseEntity<Planet>(HttpStatus.NOT_FOUND);
        }

        currentPlanet.setNode(planet.getNode());
        currentPlanet.setName(planet.getName());

        planetService.savePlanet(planet);
        return new ResponseEntity<Planet>(currentPlanet, HttpStatus.OK);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        Planet planet = planetService.findPlanetById(id);

        if (planet == null){
            logger.info("Unable to delete. User with id {} not found", id);
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        planetService.deletePlanet(planet);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
