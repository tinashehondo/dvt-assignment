package za.co.discovery.soap.api;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import za.co.discovery.soap.model.RouteRequest;
import za.co.discovery.soap.model.RouteResponse;

import javax.jws.WebService;

/**
 * Created by tinashehondo on 4/10/17.
 */
@WebService(serviceName = "PaymentService", endpointInterface = "za.co.discovery.soap.api.ShortestRouteService", portName = "ShortestRoutePort", targetNamespace = "http://www.discovery/assignment/api/soap")
public class ShortestRouteServiceImpl  extends SpringBeanAutowiringSupport implements ShortestRouteService{

    public RouteResponse calculateShortestRoute(RouteRequest routeRequest) {




        return null;
    }
}
