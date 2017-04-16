package za.co.discovery.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.co.discovery.repository.config.DataDaoConfiguration;

/**
 * Created by tinashehondo on 4/15/17.
 */
@Configuration
@ComponentScan(basePackages = {"za.co.discovery.service.planet","za.co.discovery.service.route"})
@Import(DataDaoConfiguration.class)
public class ServiceTestConfig {
}
