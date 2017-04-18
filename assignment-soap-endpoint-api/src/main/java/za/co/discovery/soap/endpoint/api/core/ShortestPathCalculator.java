package za.co.discovery.soap.endpoint.api.core;


import org.springframework.stereotype.Component;
import za.co.discovery.model.Graph;
import za.co.discovery.model.Planet;
import za.co.discovery.model.Route;

import java.util.*;

/**
 * Created by tinashehondo on 4/10/17.
 */
@Component
public class ShortestPathCalculator {
    private List<Planet> nodes;
    private List<Route> edges;
    private Set<Planet> settledNodes;
    private Set<Planet> unSettledNodes;
    private Map<Planet, Planet> predecessors;
    private Map<Planet, Double> distance;

    public void setGraph(Graph graph) {

        this.nodes = new ArrayList<Planet>(graph.getVertexes());
        this.edges = new ArrayList<Route>(graph.getEdges());
    }


    public void execute(Planet source) {
        settledNodes = new HashSet<Planet>();
        unSettledNodes = new HashSet<Planet>();
        distance = new HashMap<Planet, Double>();
        predecessors = new HashMap<Planet, Planet>();
        distance.put(source, 0.0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Planet node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Planet node) {
        List<Planet> adjacentNodes = getNeighbors(node);
        for (Planet target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }


    }

    private double getDistance(Planet node, Planet target) {

        for (Route edge : edges) {
            if (edge.getOrigin().equals(node)
                    && edge.getDestination().equals(target)) {
                return edge.getDistance();
            }
        }
        throw new RuntimeException("Not expected to happen");
    }

    private List<Planet> getNeighbors(Planet node) {
        List<Planet> neighbors = new ArrayList<Planet>();
        for (Route edge : edges) {
            if (edge.getOrigin().equals(node)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Planet getMinimum(Set<Planet> vertexes) {
        Planet minimum = null;
        for (Planet vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Planet vertex) {
        return settledNodes.contains(vertex);
    }

    private double getShortestDistance(Planet destination) {
        Double d = distance.get(destination);

        if (d == null) {
            return Double.MAX_VALUE;
        } else {
            return d;
        }
    }


    public LinkedList<Planet> getShortestPath(Graph graph, Planet origin, Planet target) {
        setGraph(graph);
        execute(origin);
        LinkedList<Planet> path = new LinkedList<Planet>();
        Planet step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }

        // Ordering
        Collections.reverse(path);
        return path;
    }


}
