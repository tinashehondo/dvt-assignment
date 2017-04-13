package za.co.discovery.soap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by tinashehondo on 4/10/17.
 */
@XmlType(name = "planet", namespace = "http://www.discovery/assignment/api", propOrder = { "node", "name"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Planet {
    private String node;
    private String name;

    @XmlElement(name = "node", required = false)
    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @XmlElement(name = "name", required = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
