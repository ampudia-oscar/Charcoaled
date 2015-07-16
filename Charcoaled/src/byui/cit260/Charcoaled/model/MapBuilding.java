/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import byu.cit260.Charcoaled.control.InventoryControl;
import java.io.Serializable;
import java.util.Arrays;

/*
 * @author Raquel
 */
public class MapBuilding implements Serializable {

    private int rowCount;
    private int columnCount;
    private Room[][] rooms;
            
    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }

    public MapBuilding() {
    }

    private int getRandomItem() {

        int x = (int) (Math.random() * 100);

        if (x < 10) {
            return 1;
        }
        return 0;
    }

    private int getRandomPerson() {
        int x = (int) (Math.random() * 100);
        if (x > 0 && x < 40) {
            return 1;
        }
        if (x > 40 & x < 60) {
            return 2;
        }
        if (x > 60 & x < 70) {
            return 3;
        }
        if (x > 70 & x < 85) {
            return 4;
        }
        if (x > 85 & x < 100) {
            return 5;
        }        
       return 0;
    }

    private InventoryItem[] generateRoomItems() {
        /// Generate Room with amount of each Item Type. Generate each room with a % chance Room having 1 item.
        int axes = getRandomItem();
        int ropes = getRandomItem();
        int waters = getRandomItem();
        int fires = getRandomItem();
        InventoryItem[] roomItems = InventoryControl.createRoomInventory(axes, ropes, waters, fires, 0);
        return roomItems;
    }

    private Person[] personsToRescue() {

        int x = getRandomPerson();

        if (x < 1) {
            return null;
        }
        
        // Create a final key
        boolean setKey = false;
        int finalkeyprobability = (int) (Math.random() * 100);        
        if (finalkeyprobability > 0 && finalkeyprobability < 15) {
            setKey = true;
        }

        Person[] person = new Person[x];
        
        for (int y = 0; y < x; y++) {
            
            person[y] = new Person();
            person[y].setNeedsRescue(true);
            boolean finalKeyCreated = Charcoaled.Charcoaled.getCurrentGame().isFinalKeyCreated();
            
            if (setKey && !finalKeyCreated)
            {
                 String finalKey = Charcoaled.Charcoaled.getCurrentGame().getGameFinalKey();
                 Charcoaled.Charcoaled.getCurrentGame().setFinalKeyCreated(true);
                 person[y].setPassKey(finalKey);
                 person[y].setHasFinalPassKey(true);
            }            
        }
        
        return person;
    }

    public MapBuilding(int rowCount, int columnCount) {
        
        if (rowCount < 1 || columnCount < 1) {
            return;
        }

        rooms = new Room[rowCount][columnCount];
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.rooms = new Room[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                Room room = new Room(row, column);
                room.setColumn(column);
                room.setRow(row);
                room.setVisited(false);
                room.setRoomInventory(generateRoomItems());
                room.setPersonsToRescue(personsToRescue());
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
    public String toString() {
        return "MapBuilding{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + ", rooms=" + rooms + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.rowCount;
        hash = 83 * hash + this.columnCount;
        hash = 83 * hash + Arrays.deepHashCode(this.rooms);
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
        if (!Arrays.deepEquals(this.rooms, other.rooms)) {
            return false;
        }
        return true;
    }    
}