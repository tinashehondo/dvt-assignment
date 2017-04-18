package za.co.discovery.web.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import za.co.discovery.soap.endpoint.client.wsdl.CalculateShortestRouteRequest;
import za.co.discovery.soap.endpoint.client.wsdl.CalculateShortestRouteResponse;

/**
 * Created by tinashehondo on 4/18/17.
 */
public class RoutesClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(RoutesClient.class);

    public CalculateShortestRouteResponse calculateShortestRoute(String destination) {

        try {
            log.info("### calculateShortestRoute ##{}",destination);

            CalculateShortestRouteRequest request = new CalculateShortestRouteRequest();
            request.setDestination(destination);



            CalculateShortestRouteResponse routes = (CalculateShortestRouteResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8081/assignment-soap-service/ws",request);

            log.info("### calculateShortestRoute # Result #{}",routes);
            return routes;

        }catch (Exception e){
            log.info("### calculateShortestRoute # ERROR #{}",e);
            e.printStackTrace();
            return null;
        }



}
    }

