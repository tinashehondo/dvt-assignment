package za.co.discovery.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import za.co.discovery.service.planet.PlanetService;
import za.co.discovery.service.route.RouteService;

/**
 * Created by tinashehondo on 4/11/17.
 */

@Configuration
@ComponentScan(basePackageClasses ={PlanetService.class, RouteService.class})
public class ServicesServiceConfig {
}
