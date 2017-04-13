package za.co.discovery.soap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by tinashehondo on 4/10/17.
 */
@XmlType(name = "routeResponse", namespace = "http://www.discovery/assignment/api", propOrder = { "distance", "planets"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RouteResponse implements Serializable {

    private double distance;
    private LinkedList<Planet> planets;

    @XmlElement(name = "distance", required = false)
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @XmlElement(name = "planets", required = false)

    public LinkedList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(LinkedList<Planet> planets) {
        this.planets = planets;
    }
}
