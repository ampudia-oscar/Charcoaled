/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import java.io.Serializable;

/**
 *
 * @author Raquel
 */
public class MapBuilding implements Serializable{ 
    
    private int rowCount;
    private int columnCount;
    private Room[][] rooms;

    public MapBuilding() {
    }

    public MapBuilding(int rowCount, int columnCount) {
                
        if (rowCount < 1 || columnCount < 1 ){
            
            System.out.println("The number of rows and columbs must be > zero");
            return;
        }
        
        rooms = new Room[rowCount][columnCount];
        
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.rooms = new Room[rowCount][columnCount];
        
        for (int row = 0; row < rowCount; row++ ) {
            for (int column = 0; column < columnCount; column++ ) {
                Room room = new Room();
                room.setColumn(column);
                room.setRow(row);
                room.setVisited(false);
                rooms[row][column] = room;                
            }
        }        
    }

    
    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.rowCount;
        hash = 37 * hash + this.columnCount;
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
        final MapBuilding other = (MapBuilding) obj;
        if (this.rowCount != other.rowCount) {
            return false;
        }
        if (this.columnCount != other.columnCount) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "MapBuilding{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + '}';
    }
    
    
}
