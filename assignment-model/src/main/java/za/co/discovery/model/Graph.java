package za.co.discovery.model;

import java.util.List;

/**
 * Created by tinashehondo on 4/10/17.
 */
public class Graph {
    private final List<Planet> vertexes;
    private final List<Route> edges;

    public Graph(List<Planet> vertexes, List<Route> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public List<Planet> getVertexes() {
        return vertexes;
    }

    public List<Route> getEdges() {
        return edges;
    }
}
