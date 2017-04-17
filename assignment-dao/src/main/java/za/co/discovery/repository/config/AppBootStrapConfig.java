package za.co.discovery.repository.config;

import org.hsqldb.util.DatabaseManagerSwing;
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

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PlanetRepository planetRepository;

    @PostConstruct
    public void startDBManager() {

        try {

            System.out.print("####POST CONSTRUCT ####");

            CsvFileReaderUtil csvFileReaderUtil = new CsvFileReaderUtil();

            for (Planet planet :csvFileReaderUtil.getPlanets()) {
                planetRepository.save(planet);

            }
            int i=0;

            for (Route route :csvFileReaderUtil.getRoutes()) {
                i++;
                System.out.print(i+"####POST CONSTRUCT SAVING ####{} , {}"+route);
                try {
                    routeRepository.save(route);
                }catch (Exception e){
                    System.out.print("*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                            ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+
                            ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+

                            ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
                                    +route);
                    e.printStackTrace();
                }


            }

            System.out.print("####POST CONSTRUCT DONE ####");
        }catch (Exception e){

        }




        //derby
        DatabaseManagerSwing.main(new String[] { "--url", "jdbc:derby:memory:testdb;create=true", "--user", "", "--password", "" });


    }
}
