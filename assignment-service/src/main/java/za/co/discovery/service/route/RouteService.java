package za.co.discovery.service.route;


import za.co.discovery.model.Route;

import java.util.List;

/**
 * Created by tinashehondo on 4/9/17.
 */
public interface RouteService {
    Route saveRoute(Route route);
    Route findRouteById(String id);
    List<Route> findAllRoutes();
    void deleteRoute(Route route);
}
