package za.co.discovery.api.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"za.co.discovery.api.services.rest"})
public class ApiServiceConfig {
}
