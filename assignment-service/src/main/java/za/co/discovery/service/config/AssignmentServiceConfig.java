package za.co.discovery.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tinashehondo on 4/15/17.
 */
@Configuration
@ComponentScan(basePackages = {"za.co.discovery.service.planet","za.co.discovery.service.route"})
public class AssignmentServiceConfig {
}
