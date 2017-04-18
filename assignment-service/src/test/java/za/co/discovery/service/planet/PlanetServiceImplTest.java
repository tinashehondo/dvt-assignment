//package za.co.discovery.service.planet;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import za.co.discovery.service.config.ServiceTestConfig;
//import za.co.discovery.model.Planet;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by tinashehondo on 4/16/17.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {ServiceTestConfig.class})
//public class PlanetServiceImplTest {
//
//    @Autowired
//    private PlanetService planetService;
//
//    @Test
//    public void testSavePlanet() throws Exception {
//
//        Planet planet = new Planet();
//        planet.setNode("A");
//        planet.setName("Earth");
//
//        Planet savedPlanet = planetService.savePlanet(planet);
//
//        assert savedPlanet != null;
//        assert savedPlanet.getNode() != null;
//        assert savedPlanet.getName() != null;
//
//    }
//
//    @Test
//    public void testFindPlanetById() throws Exception {
//
//        Planet planet = new Planet();
//        planet.setNode("A");
//        planet.setName("Earth");
//        planetService.savePlanet(planet);
//
//        Planet searchedPlanet = planetService.findPlanetById("A");
//
//        assert searchedPlanet != null;
//        assertEquals("Earth",searchedPlanet.getName());
//        assert searchedPlanet.getNode() != null;
//        assert searchedPlanet.getName() != null;
//
//    }
//
//    @Test
//    public void testUpdatePlanet() throws Exception {
//
//        Planet planet = new Planet();
//        planet.setNode("A");
//        planet.setName("Earth");
//        planetService.savePlanet(planet);
//
//        Planet planetTobeUpdated = new Planet();
//        planetTobeUpdated.setNode("A");
//        planetTobeUpdated.setName("Mars");
//
//        Planet updatedPlanet = planetService.savePlanet(planetTobeUpdated);
//
//        assert updatedPlanet != null;
//        assertEquals("Mars",updatedPlanet.getName());
//        assert updatedPlanet.getNode() != null;
//        assert updatedPlanet.getName() != null;
//
//    }
//
//    @Test
//    public void testDeletePlanet() throws Exception {
//
//        Planet planet = new Planet();
//        planet.setNode("A");
//        planet.setName("Earth");
//        planetService.savePlanet(planet);
//
//        planetService.deletePlanet(planet);
//
//        Planet deletedPlanet = planetService.findPlanetById("A");
//
//        assertEquals(deletedPlanet,null);
//
//
//    }
//
//}
//
//
