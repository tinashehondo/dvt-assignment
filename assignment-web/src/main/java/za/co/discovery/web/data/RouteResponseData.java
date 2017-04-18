package za.co.discovery.web.data;

import za.co.discovery.model.Planet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tinashehondo on 4/18/17.
 */
public class RouteResponseData {
    private double distance;
    private List<Planet> planets;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Planet> getPlanets() {

        if (planets == null) {
            planets = new ArrayList<Planet>();
        }
        return this.planets;
    }

    @Override
    public String toString() {
        return "RouteResponseData{" +
                "distance=" + distance +
                ", planets=" + planets +
                '}';
    }
}
