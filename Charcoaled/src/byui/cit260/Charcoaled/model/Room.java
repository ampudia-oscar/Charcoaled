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
public class Room implements Serializable{
    
    //class instance variables
    private double row;
    private double column;
    private boolean visited;
    private double amountRemaining;
    private InventoryItem[] roomInventory;

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

    @Override
    public String toString() {
        return "Room{" + "row=" + row + ", column=" + column + ", visited=" + visited + ", amountRemaining=" + amountRemaining + '}';
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

    public double getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(double amountRemaining) {
        this.amountRemaining = amountRemaining;
    }    
}