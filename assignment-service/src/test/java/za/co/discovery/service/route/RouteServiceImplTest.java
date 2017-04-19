package za.co.discovery.service.route;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.discovery.model.Planet;
import za.co.discovery.model.Route;
import za.co.discovery.service.config.ServiceTestConfig;
import za.co.discovery.service.planet.PlanetService;

import static org.junit.Assert.assertEquals;

/*
 * Created by tinashehondo on 4/16/17.

*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceTestConfig.class})
public class RouteServiceImplTest {

    @Autowired
    private RouteService routeService;

    @Autowired
    private PlanetService planetService;


    @Test
    public void testSaveRoute() throws Exception {

        Planet origin = new Planet();
        origin.setNode("A");
        origin.setName("EARTH");

        planetService.savePlanet(origin);

        Planet destination = new Planet();
        destination.setNode("B");
        destination.setName("MARS");
        planetService.savePlanet(destination);

        Route route = new Route();

        route.setOrigin(origin);
        route.setDestination(destination);
        route.setDistance(1.44);

       Route savedRoute = routeService.saveRoute(route);


        assert savedRoute != null;
        assertEquals("A",savedRoute.getOrigin().getNode());
        assertEquals("B",savedRoute.getDestination().getNode());

        assertEquals(1.44,savedRoute.getDistance(),0.01);

    }

    @Test
    public void testFindRouteById() throws Exception {

        Planet origin = new Planet();
        origin.setNode("A");
        origin.setName("Earth");

        planetService.savePlanet(origin);

        Planet destination = new Planet();
        destination.setNode("B");
        destination.setName("Mars");
        planetService.savePlanet(destination);

        Route route = new Route();

        route.setRouteId(1);
        route.setOrigin(origin);
        route.setDestination(destination);
        route.setDistance(1.44);

        routeService.saveRoute(route);

        Route searchedRoute = routeService.findRouteById(1);

        assert searchedRoute != null;
        assertEquals("Earth",searchedRoute.getOrigin().getName());
        assertEquals("Mars",searchedRoute.getDestination().getName());
    }

 @Test
    public void testUpdateRoute() throws Exception {

        Planet origin = new Planet();
        origin.setNode("A");
        origin.setName("EARTH");

        planetService.savePlanet(origin);

        Planet destination = new Planet();
        destination.setNode("B");
        destination.setName("MARS");
        planetService.savePlanet(destination);

        Route route = new Route();

        route.setRouteId(1);
        route.setOrigin(origin);
        route.setDestination(destination);
        route.setDistance(1.44);

        routeService.saveRoute(route);

        Planet newDestination = new Planet();
        newDestination.setNode("C");
        newDestination.setName("Moon");
        planetService.savePlanet(newDestination);

        Route routeTobeUpdated = new Route();

         routeTobeUpdated.setRouteId(1);
        routeTobeUpdated.setOrigin(origin);
        routeTobeUpdated.setDestination(newDestination);
        routeTobeUpdated.setDistance(2.67);

        Route updatedRoute = routeService.saveRoute(routeTobeUpdated);

 assert updatedRoute != null;
        assertEquals("A",updatedRoute.getOrigin().getNode());
        assertEquals("C",updatedRoute.getDestination().getNode());

        assertEquals(2.67,updatedRoute.getDistance(),0.01);

    }

    @Test
    public void testDeleteRoute() throws Exception {

        Planet origin = new Planet();
        origin.setNode("X");
        origin.setName("EARTH");

        planetService.savePlanet(origin);

        Planet destination = new Planet();
        destination.setNode("B");
        destination.setName("MARS");
        planetService.savePlanet(destination);

        Route route = new Route();

        route.setRouteId(1);
        route.setOrigin(origin);
        route.setDestination(destination);
        route.setDistance(1.44);

        Route savedRoute = routeService.saveRoute(route);

        routeService.deleteRoute(savedRoute);

        Route deletedRoute = routeService.findRouteById(1);

        assert deletedRoute == null;


    }

}
