/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import java.io.Serializable;
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

}
