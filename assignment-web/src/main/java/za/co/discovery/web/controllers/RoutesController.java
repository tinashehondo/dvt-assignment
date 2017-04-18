package za.co.discovery.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.discovery.model.Planet;
import za.co.discovery.web.services.ShortestRouteClient;

import java.util.List;

/**
 * Created by primrose on 4/18/17.
 */
@Controller
@RequestMapping("/route")
public class RoutesController {

    @Autowired
    private ShortestRouteClient shortestRouteClient;


    @RequestMapping("/")
        public String getPlanetHomePage() {
            return "route/form";
        }

        @RequestMapping(value = "/search/",method = RequestMethod.POST)
        public String searchPlanets(Model model, @RequestParam(required = true) String origin,@RequestParam(required = true) String destination) {
            System.out.println("Search Planets with :"+origin+" and :"+destination);
            //do service call and get list of planet routes
            List<Planet> planetsResultList=shortestRouteClient.getShortestDistance(origin,destination).getPlanets();
            model.addAttribute("planets",planetsResultList);
            return "route/form";
        }
}
