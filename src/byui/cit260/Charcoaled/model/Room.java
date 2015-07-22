/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import java.io.Serializable;
import java.util.Arrays;
/*
 * @author oscar and raquel
 */

public class Room implements Serializable {

    //class instance variables
    private double row;
    private double column;
    private boolean visited;
    private InventoryItem[] roomInventory;
    private Person[] personsToRescue;

    public Person[] getPersonsToRescue() {
        return personsToRescue;
    }

    public void setPersonsToRescue(Person[] personsToRescue) {
        this.personsToRescue = personsToRescue;
    }

    public InventoryItem[] getRoomInventory() {
        return roomInventory;
    }

    public void setRoomInventory(InventoryItem[] roomInventory) {
        this.roomInventory = roomInventory;
    }

    public Room() {
    }

    public Room(int row, int column) {

        this.row = row;
        this.column = column;
    }

    public double getRow() {
        return row;
    }

    public void setRow(double row) {
        this.row = row;
    }

    public double getColumn() {
        return column;
    }

    public void setColumn(double column) {
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.row) ^ (Double.doubleToLongBits(this.row) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.column) ^ (Double.doubleToLongBits(this.column) >>> 32));
        hash = 79 * hash + (this.visited ? 1 : 0);
        hash = 79 * hash + Arrays.deepHashCode(this.roomInventory);
        hash = 79 * hash + Arrays.deepHashCode(this.personsToRescue);
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
        final Room other = (Room) obj;
        if (Double.doubleToLongBits(this.row) != Double.doubleToLongBits(other.row)) {
            return false;
        }
        if (Double.doubleToLongBits(this.column) != Double.doubleToLongBits(other.column)) {
            return false;
        }
        if (this.visited != other.visited) {
            return false;
        }
        if (!Arrays.deepEquals(this.roomInventory, other.roomInventory)) {
            return false;
        }
        if (!Arrays.deepEquals(this.personsToRescue, other.personsToRescue)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Room{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", roomInventory=" + roomInventory + ", personsToRescue=" + personsToRescue + '}';
    }
       
}