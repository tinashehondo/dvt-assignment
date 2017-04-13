package za.co.discovery.service.route;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.discovery.model.Route;
import za.co.discovery.repository.route.RouteRepository;
import za.co.discovery.service.planet.PlanetService;

import java.util.List;

/**
 * Created by tinashehondo on 4/9/17.
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PlanetService planetService;


    public Route saveRoute(Route route) {
        if (planetService.findPlanetById(route.getDestination().getNode()) != null && planetService.findPlanetById(route.getOrigin().getNode()) != null) {
            return routeRepository.save(route);
        }
        return routeRepository.save(route);
    }

    public Route findRouteById(String id) {
        return routeRepository.findRouteByRouteId(id);
    }

    public List<Route> findAllRoutes() {
        return routeRepository.findAll();
    }

    public void deleteRoute(Route route) {
        routeRepository.delete(route);

    }
}
