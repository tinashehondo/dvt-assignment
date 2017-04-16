package za.co.discovery.repository.route;


import org.springframework.data.jpa.repository.JpaRepository;
import za.co.discovery.model.Route;

/**
 * Created by tinashehondo on 4/9/17.
 */

public interface RouteRepository extends JpaRepository<Route,Integer> {
    Route findRouteByRouteId(Integer routeId);
}
