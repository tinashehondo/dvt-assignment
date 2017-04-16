package za.co.discovery.soap.endpoint.api.soap;

import discovery.assignment.api.soap.CalculateShortestRoute;
import discovery.assignment.api.soap.CalculateShortestRouteResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by tinashehondo on 4/15/17.
 */
@Endpoint
public class ShortestRouteApi {


    @PayloadRoot(namespace = "http://www.discovery/assignment/api", localPart = "calculateShortestRoute")
    @ResponsePayload
    public CalculateShortestRouteResponse process(@RequestPayload CalculateShortestRoute request) {

        System.out.print("*****************testing###############");

        CalculateShortestRouteResponse response = new CalculateShortestRouteResponse();

        return response;
    }


}
