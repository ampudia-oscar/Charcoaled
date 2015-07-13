/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import Charcoaled.Charcoaled;
import byui.cit260.Charcoaled.exceptions.InventoryControlException;
import byui.cit260.Charcoaled.model.Game;
import byui.cit260.Charcoaled.model.InventoryItem;
import byui.cit260.Charcoaled.model.Items;
import byui.cit260.Charcoaled.model.Room;

/**
 *
 * @author oscar
 */
public class InventoryControl {

    //private static InventoryItem[] items;
    public static boolean useItem(int x) {

        InventoryItem item = InventoryControl.getPlayerSingleInventoryItem(x);
        InventoryItem[] items = InventoryControl.getPlayerInventory(false);
        int count = item.getQuantityInStock();

        if (count > 0) {
            items[x].setQuantityInStock(count - 1);
            return true;
        }
        return false;
    }
    
    public static boolean addItemToInventory(int itemType) {

        InventoryItem item = InventoryControl.getPlayerSingleInventoryItem(itemType);
        InventoryItem[] items = InventoryControl.getPlayerInventory(false);

        int count = item.getQuantityInStock();

        if (count < item.getMaxItemsInStock()) {
            items[itemType].setQuantityInStock(count + 1);
            return true;
        } else {
            return false;
        }
    }

    public static InventoryItem[] createRoomInventory(int axes, int ropes, int waters, int fires, int keys) {

        InventoryItem[] inventory = new InventoryItem[4];

        InventoryItem axe = new InventoryItem();
        axe.setInventoryType("Axe");
        axe.setQuantityInStock(axes);

        InventoryItem rope = new InventoryItem();
        rope.setInventoryType("Rope");
        rope.setQuantityInStock(ropes);

        InventoryItem water = new InventoryItem();
        water.setInventoryType("Bucket of Water");
        water.setQuantityInStock(waters);

        InventoryItem fire = new InventoryItem();
        fire.setInventoryType("Fire Extinguisher");
        fire.setQuantityInStock(fires);

        InventoryItem key = new InventoryItem();
        key.setInventoryType("Master Key");
        key.setQuantityInStock(keys);

        inventory[Items.Rope.ordinal()] = rope;
        inventory[Items.Fire.ordinal()] = fire;
        inventory[Items.Water.ordinal()] = water;
        inventory[Items.Axe.ordinal()] = axe;
        //inventory[Items.MasterKey.ordinal()] = key;

        return inventory;

    }

    static InventoryItem[] createPlayerInventory() {

        InventoryItem[] inventory = new InventoryItem[5];
        InventoryItem axe = new InventoryItem();
        axe.setInventoryType("Axes");
        axe.setQuantityInStock(1);
        axe.setMaxItemsInStock(5);

        InventoryItem rope = new InventoryItem();
        rope.setInventoryType("Ropes");
        rope.setQuantityInStock(1);
        rope.setMaxItemsInStock(5);

        InventoryItem water = new InventoryItem();
        water.setInventoryType("Buckets of Water");
        water.setQuantityInStock(1);
        water.setMaxItemsInStock(5);

        InventoryItem fire = new InventoryItem();
        fire.setInventoryType("Fire Extinguishers");
        fire.setQuantityInStock(1);
        fire.setMaxItemsInStock(5);

        InventoryItem key = new InventoryItem();
        key.setInventoryType("Master Key");
        key.setQuantityInStock(0);
        key.setMaxItemsInStock(5);

        inventory[Items.Rope.ordinal()] = rope;
        inventory[Items.Fire.ordinal()] = fire;
        inventory[Items.Water.ordinal()] = water;
        inventory[Items.Axe.ordinal()] = axe;
        inventory[Items.MasterKey.ordinal()] = key;

        return inventory;
    }

    public static InventoryItem[] getPlayerInventory(boolean sort) {

        Game game = Charcoaled.getCurrentGame();

        InventoryItem[] inventory = game.getInventory();
        if (sort) {
            return getInsertionSortedInventory(inventory);
        } else {
            return inventory;
        }
    }

    public static int getQuantityOfItems(InventoryItem[] inventory) {
        int x = 0;
        for (InventoryItem item : inventory) {
            x += item.getQuantityInStock();
        }
        return x;
    }

    public static InventoryItem[] getRoomInventory(Room room) {
        InventoryItem[] inventory = room.getRoomInventory();
        return getBubbleSortedInventory(inventory);
    }
    
     public static InventoryItem[] getUnsortedRoomInventory(Room room) {
        InventoryItem[] inventory = room.getRoomInventory();
        return inventory;
    }

    public static InventoryItem[] getInsertionSortedInventory(InventoryItem[] inventory) {

        for (int i = 0; i < inventory.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < inventory.length; ++j) {
                String inventoryType = inventory[j].getInventoryType();
                String inventoryType2 = inventory[minIndex].getInventoryType();
                //if (arr[j].compareTo(arr[minIndex]) < 0)
                if (inventoryType.compareTo(inventoryType2) < 0) {
                    minIndex = j;
                }
            }
            // int changed to String
            InventoryItem temp = inventory[i];
            inventory[i] = inventory[minIndex];
            inventory[minIndex] = temp;
        }

        return inventory;
    }

    public static InventoryItem[] getBubbleSortedInventory(InventoryItem[] inventory) {

        InventoryItem tempItem = null;

        for (int i = 0; i < inventory.length - 1; i++) {
            for (int j = 0; j < inventory.length - 1 - i; j++) {
                if (inventory[j].getInventoryType().compareToIgnoreCase(inventory[j + 1].getInventoryType()) > 0) {
                    tempItem = inventory[j];
                    inventory[j] = inventory[j + 1];
                    inventory[j + 1] = tempItem;
                }
            }
        }
        return inventory;
    }

    public static InventoryItem getPlayerSingleInventoryItem(int x) {

        InventoryItem[] items = InventoryControl.getPlayerInventory(false);
        InventoryItem item = items[x];
        return item;
    }

    public void updatePlayerInventory(InventoryItem[] inventory) {
        //GameControl.setGameInventory(inventory);
        Game game = Charcoaled.getCurrentGame();
        game.setInventory(inventory);
    }
}