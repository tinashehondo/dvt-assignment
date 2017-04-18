package za.co.discovery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by tinashehondo on 4/9/17.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( name = "Planet")
@Entity
public class Planet {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String node;
    private String name;

    public Planet() {
    }
    public Planet(String node) {
        this.node=node;
    }

    public Planet(String node, String name) {
        this.node = node;
        this.name = name;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((node == null) ? 0 : node.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Planet other = (Planet) obj;
        if (node == null) {
            if (other.node != null)
                return false;
        } else if (!node.equals(other.node))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "node='" + node + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
