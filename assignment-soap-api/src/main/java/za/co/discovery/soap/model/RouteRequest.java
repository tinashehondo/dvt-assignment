package za.co.discovery.soap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by tinashehondo on 4/10/17.
 */
@XmlType(name = "routeRequest", namespace = "http://www.discovery/assignment/api", propOrder = { "origin", "destination"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class RouteRequest {

    private String origin;
    private String destination;
    @XmlElement(name = "origin", required = false)
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    @XmlElement(name = "destination", required = false)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
