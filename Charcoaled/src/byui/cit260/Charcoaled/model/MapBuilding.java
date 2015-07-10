/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import Charcoaled.Charcoaled;
import byu.cit260.Charcoaled.control.InventoryControl;
import java.io.PrintWriter;
import java.io.Serializable;

/*
 * @author Raquel
 */
public class MapBuilding implements Serializable {

    private int rowCount;
    private int columnCount;
    private Room[][] rooms;
    private int[] finalKeys;
    protected final PrintWriter console = Charcoaled.getOutFile();

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

        if (x < 30) {
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

        Person[] person = new Person[x];

        /*
        for (Person _person : person) {
            _person = new Person();
            _person.setNeedsRescue(true);
        }
        */
        
        
        for (int y = 0; y < x; y++) {
            person[y] = new Person();
            person[y].setNeedsRescue(true);
        }
        
        return person;
    }

    public MapBuilding(int rowCount, int columnCount, int finalKeyCount) {
        
        if (rowCount < 1 || columnCount < 1) {
            this.console.println("The number of rows and columbs must be > zero");
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
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.rowCount;
        hash = 37 * hash + this.columnCount;
        return hash;
    }
}