/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author oscar
 */
public class Inventory implements Serializable{
    
    //class instance variables
    private String name;
    private int numberOfAxes;
    private int numberOfFireExtinguishers;
    private int numberOfWaters;

    public int getNumberOfWaters() {
        return numberOfWaters;
    }

    public void setNumberOfWaters(int numberOfWaters) {
        this.numberOfWaters = numberOfWaters;
    }

    public int getNumberOfRopes() {
        return numberOfRopes;
    }

    public void setNumberOfRopes(int numberOfRopes) {
        this.numberOfRopes = numberOfRopes;
    }
    private int numberOfRopes;
    
    
    public int getNumberOfAxes() {
        return numberOfAxes;
    }

    public void setNumberOfAxes(int numberOfAxes) {
        this.numberOfAxes = numberOfAxes;
    }

    public int getNumberOfFireExtinguishers() {
        return numberOfFireExtinguishers;
    }

    public void setNumberOfFireExtinguishers(int numberOfFireExtinguishers) {
        this.numberOfFireExtinguishers = numberOfFireExtinguishers;
    }
    private String type;
    private String description;
    private double totalItems;
    private double maxItems;

    public Inventory() {
    }

    @Override
    public String toString() {
        return "Inventory{" + "name=" + name + ", type=" + type + ", description=" + description + ", totalItems=" + totalItems + ", maxItems=" + maxItems + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(double totalItems) {
        this.totalItems = totalItems;
    }

    public double getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(double maxItems) {
        this.maxItems = maxItems;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.totalItems) ^ (Double.doubleToLongBits(this.totalItems) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.maxItems) ^ (Double.doubleToLongBits(this.maxItems) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inventory other = (Inventory) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalItems) != Double.doubleToLongBits(other.totalItems)) {
            return false;
        }
        if (Double.doubleToLongBits(this.maxItems) != Double.doubleToLongBits(other.maxItems)) {
            return false;
        }
        return true;
    }
    
    
}
