package za.co.discovery.soap.endpoint.api.soap;

import discovery.assignment.api.soap.CalculateShortestRouteRequest;
import discovery.assignment.api.soap.CalculateShortestRouteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import za.co.discovery.model.Graph;
import za.co.discovery.model.Planet;
import za.co.discovery.model.Route;
import za.co.discovery.soap.endpoint.api.core.ShortestPathCalculator;
import za.co.discovery.soap.endpoint.api.utils.constants.SoapConstants;
import za.co.discovery.soap.endpoint.api.utils.convertors.PlanetModelToPlanet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tinashehondo on 4/15/17.
 */
@Endpoint
public class ShortestRouteSoapApi {

    private static final Logger logger = LoggerFactory.getLogger(ShortestRouteSoapApi.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ShortestPathCalculator shortestPathCalculator;

    @Autowired
    private PlanetModelToPlanet planetModelToPlanetConvertor;


    @PayloadRoot(namespace = SoapConstants.TARGET_NAMESPACE, localPart = "calculateShortestRouteRequest")
    @ResponsePayload
    public CalculateShortestRouteResponse calculateShortestRoute(@RequestPayload CalculateShortestRouteRequest request) {
        logger.info("******request** {}", request);
        try {
            Planet originPlanet = getPlanet(request.getOrigin());
            Planet destinationPlanet = getPlanet(request.getDestination());

            List<Planet> planetList = getAllPlanets();
            List<za.co.discovery.model.Route> routeList = getAllRoutes();

            Graph graph = new Graph(planetList, routeList);

            LinkedList<Planet> path = shortestPathCalculator.getShortestPath(graph, originPlanet, destinationPlanet);

           CalculateShortestRouteResponse response = getCalculateShortestRouteResponse(routeList,path);


            return response;

        } catch (Exception e) {
            logger.error("exception **** {}", e);
        }


        CalculateShortestRouteResponse response = new CalculateShortestRouteResponse();

        logger.info("***************response##{}", response);
        return response;
    }

    private CalculateShortestRouteResponse getCalculateShortestRouteResponse(List<Route> routeList, LinkedList<Planet> path) {
        CalculateShortestRouteResponse response = new CalculateShortestRouteResponse();

        discovery.assignment.api.soap.Route route = new discovery.assignment.api.soap.Route();
        //calculate distance
        //route.setDistance(calculateDistance(routeList,path));
        for (Planet p : path) {
            route.getPlanets().add(planetModelToPlanetConvertor.convert(p));
        }

        response.setRoute(route);
        return response;
    }


    private double calculateDistance(List<Route> routeList,LinkedList<Planet> path){
        logger.info("***************calculateDistance# PATH#{}", path);
        logger.info("***************calculateDistance# ROUTE LIST#{}", routeList);
        double totalDistance = 0.0;

        for (Planet p : path) {
            logger.info("***************calculateDistance# <<<<path P>>>>>>>>>#{}", p);
            logger.info("***************calculateDistance# <<<<path P index of >>>>>>>>>#{}", routeList.indexOf(p));

            totalDistance= totalDistance+(routeList.get(routeList.indexOf(p)).getDistance());
            logger.info("***************still calculateDistance##{}", totalDistance);
        }
        logger.info("***************DONE calculateDistance##{}", totalDistance);
        return totalDistance;






    }

    private Planet getPlanet(String node) {
        return restTemplate.getForObject("http://localhost:8083/assignment-api/planet/" + node, Planet.class);
    }

    private List<Planet> getAllPlanets() {
        Planet[] planets = restTemplate.getForObject("http://localhost:8083/assignment-api/planet/", Planet[].class);
        return Arrays.asList(planets);
    }

    private List<za.co.discovery.model.Route> getAllRoutes() {
        za.co.discovery.model.Route[] routes = restTemplate.getForObject("http://localhost:8083/assignment-api/route/", za.co.discovery.model.Route[].class);
        return Arrays.asList(routes);
    }


}
