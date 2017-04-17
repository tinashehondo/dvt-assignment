package za.co.discovery.model;

import javax.persistence.*;

/**
 * Created by tinashehondo on 4/9/17.
 */

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeId;
    private double distance;
    @OneToOne
    private Planet origin;
    @OneToOne
    private Planet destination;

    public Route() {
    }

    public Route(Integer routeId, double distance, Planet origin, Planet destination) {
        this.routeId=routeId;
        this.distance = distance;
        this.origin = origin;
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Planet getOrigin() {
        return origin;
    }

    public void setOrigin(Planet origin) {
        this.origin = origin;
    }

    public Planet getDestination() {
        return destination;
    }

    public void setDestination(Planet destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", distance=" + distance +
                ", origin=" + origin +
                ", destination=" + destination +
                '}';
    }
}
