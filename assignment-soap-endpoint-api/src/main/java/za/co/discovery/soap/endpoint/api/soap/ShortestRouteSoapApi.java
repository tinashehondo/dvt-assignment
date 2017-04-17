package za.co.discovery.soap.endpoint.api.soap;

import discovery.assignment.api.soap.CalculateShortestRouteRequest;
import discovery.assignment.api.soap.CalculateShortestRouteResponse;
import discovery.assignment.api.soap.Route;
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
import za.co.discovery.soap.endpoint.api.core.ShortestPathCalculator;
import za.co.discovery.soap.endpoint.api.utils.constants.SoapConstants;

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


    @PayloadRoot(namespace = SoapConstants.TARGET_NAMESPACE, localPart = "calculateShortestRouteRequest")
    @ResponsePayload
    public CalculateShortestRouteResponse calculateShortestRoute(@RequestPayload CalculateShortestRouteRequest request) {
        logger.info("*****************testing#########request######" + request);
        logger.info("*****************testing#########planet Service######{}"+restTemplate);
        Planet planet = new Planet();
        planet.setNode("A");
        planet.setName("Earth");
        try {
            Planet destinationPlanet = restTemplate.getForObject("http://localhost:8083/assignment-api/planet/"+request.getDestination(),Planet.class);



            Planet[] planets = restTemplate.getForObject("http://localhost:8083/assignment-api/planet/",Planet[].class);
            List<Planet> planetList = Arrays.asList(planets);
            //logger.info("******planet***********LIST#########planet Service###list###{}"+planetList);
            za.co.discovery.model.Route[] routes = restTemplate.getForObject("http://localhost:8083/assignment-api/route/", za.co.discovery.model.Route[].class);
            List<za.co.discovery.model.Route> routeList =  Arrays.asList(routes);
           // logger.info("****Route*************LIST#########Route serviceist###{}",routeList);

            Graph graph = new Graph(planetList, routeList);
            //ShortestPathCalculator shortestPathCalculator = new ShortestPathCalculator();

            shortestPathCalculator.setGraph(graph);
            shortestPathCalculator.execute(planet);
            LinkedList<Planet> path = shortestPathCalculator.getPath(destinationPlanet);


            for (Planet planetResult : path) {
                System.out.println(planetResult);
            }


        }catch (Exception e){
            logger.error("exception **** {}",e);
            e.printStackTrace();
        }


        CalculateShortestRouteResponse response = new CalculateShortestRouteResponse();
        final Route route = new Route();
        route.setDistance(124);
        response.setRoute(route);
        System.out.print("*****************testing#############response##" + response);
        return response;
    }


}
