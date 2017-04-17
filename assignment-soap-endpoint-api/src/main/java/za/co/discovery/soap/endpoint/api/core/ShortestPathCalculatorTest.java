/*
package za.co.discovery.soap.endpoint.api.core;

import za.co.discovery.model.Graph;
import za.co.discovery.model.Planet;
import za.co.discovery.model.Route;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

//import za.co.discovery.logic.ShortestPathCalculator;

*/
/**
 * Created by tinashehondo on 4/10/17.
 *//*

public class ShortestPathCalculatorTest {
    private List<Planet> nodes;
    private List<Route> edges;

   // @Test
    public void testExcute() {
        nodes = new ArrayList<Planet>();
        edges = new ArrayList<Route>();
        for (int i = 0; i < 11; i++) {
            Planet location = new Planet("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane(0, 0, 1, 85);
        addLane(1, 0, 2, 217);
        addLane(2, 0, 4, 173);
        addLane(3, 2, 6, 186);
        addLane(4, 2, 7, 103);
        addLane(5, 3, 7, 183);
        addLane(6, 5, 8, 250);
        addLane(7, 8, 9, 84);
        addLane(8, 7, 9, 167);
        addLane(9, 4, 9, 502);
        addLane(10, 9, 10, 40);
        addLane(11, 1, 10, 600);

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        ShortestPathCalculator shortestPathCalculator = new ShortestPathCalculator(graph);
        shortestPathCalculator.execute(nodes.get(0));
        LinkedList<Planet> path = shortestPathCalculator.getPath(nodes.get(10));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Planet planet : path) {
            System.out.println(planet);
        }

    }

    public static void main(String[] args) {
        new ShortestPathCalculatorTest().testExcute();
    }
    private void addLane(int routeId,int sourceLocNo, int destLocNo,
                         double duration) {
        Route lane = new Route(routeId,duration,nodes.get(sourceLocNo),nodes.get(destLocNo));
        edges.add(lane);
    }

}
*/
