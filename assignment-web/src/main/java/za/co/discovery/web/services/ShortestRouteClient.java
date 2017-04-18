package za.co.discovery.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.discovery.assignment.assignment.ws.client.*;
import za.co.discovery.web.convertors.PlanetToPlanetModel;
import za.co.discovery.web.data.RouteResponseData;

import java.net.URL;
import java.util.List;

/**
 * Created by tinashehondo on 4/18/17.
 */
@Component
public class ShortestRouteClient {

    @Autowired
    private PlanetToPlanetModel planetModelToPlanetConvertor;


    public RouteResponseData getShortestDistance(String origin, String destination) {
        RouteResponseData responseData = new RouteResponseData();
        try {
            System.out.print("\ncalling service getShortestDistance  :" + destination + origin);
            URL url = new URL("http://localhost:8081/assignment-soap-service/ws/routes.wsdl");
            ShortestRouteApiPortService s = new ShortestRouteApiPortService(url);

            CalculateShortestRouteRequest request = new CalculateShortestRouteRequest();
            request.setDestination(destination);
            request.setOrigin(origin);
            CalculateShortestRouteResponse response = s.getShortestRouteApiPortSoap11().calculateShortestRoute(request);

            za.co.discovery.assignment.assignment.ws.client.Route route = response.getRoute();

            System.out.print("\nROUTE :" + route);


            responseData.setDistance(route.getDistance());

            List<za.co.discovery.assignment.assignment.ws.client.Planet> planets = route.getPlanets();


            for (za.co.discovery.assignment.assignment.ws.client.Planet planet:planets
                 ) {
                responseData.getPlanets().add(planetModelToPlanetConvertor.convert(planet));
                
            }


            System.out.print("\nRESPONSE :" + responseData);
        } catch (Exception e) {
            System.out.print("\nERROR :" + e);

        }

        return responseData;
    }
}
