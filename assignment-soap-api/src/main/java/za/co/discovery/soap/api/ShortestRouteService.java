package za.co.discovery.soap.api;

import za.co.discovery.soap.model.RouteRequest;
import za.co.discovery.soap.model.RouteResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by tinashehondo on 4/10/17.
 */
@WebService(name = "ShortestRoutePort" , targetNamespace="http://www.discovery/assignment/api/soap")
public interface ShortestRouteService {
    @WebMethod
    RouteResponse calculateShortestRoute(@WebParam(name = "routeRequest") RouteRequest routeRequest);
}
