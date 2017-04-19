package za.co.discovery.repository.config;

import org.hsqldb.util.DatabaseManagerSwing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import za.co.discovery.model.Planet;
import za.co.discovery.model.Route;
import za.co.discovery.repository.planet.PlanetRepository;
import za.co.discovery.repository.route.RouteRepository;
import za.co.discovery.repository.utils.CsvFileReaderUtil;

import javax.annotation.PostConstruct;

/**
 * Created by tinashehondo on 4/17/17.
 */
@Configuration
public class AppBootStrapConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppBootStrapConfig.class);

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PlanetRepository planetRepository;

    @PostConstruct
    public void startDBManager() {

        try {
            logger.info("####loading initial Data ####");
            CsvFileReaderUtil csvFileReaderUtil = new CsvFileReaderUtil();
            for (Planet planet : csvFileReaderUtil.getPlanets()) {
                logger.info("#########################loading initial Data ####>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}",planet);
                planetRepository.save(planet);
            }

            for (Route route : csvFileReaderUtil.getRoutes()) {
                routeRepository.save(route);
            }
            logger.info("####loading initial Data ####");
        } catch (Exception e) {
            logger.error("#################################error loading initial data ####{}",e);
        }
        //derby
        DatabaseManagerSwing.main(new String[] { "--url", "jdbc:derby:memory:testdb;create=true", "--user", "", "--password", "" });

    }
}
