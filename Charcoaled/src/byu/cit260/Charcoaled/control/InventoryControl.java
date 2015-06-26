/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import Charcoaled.Charcoaled;
import byui.cit260.Charcoaled.model.InventoryItem;
import byui.cit260.Charcoaled.model.Items;

/**
 *
 * @author oscar
 */
public class InventoryControl {    
    
    private static InventoryItem[] items;
    
    public static boolean useItem (String itemType) {
        
    boolean usedItem = false;
    items = getInventory();
    
    int count = items[Items.Axe.ordinal()].getQuantityInStock();
    
    if (count > 0) {
    
        items[Items.Axe.ordinal()].setQuantityInStock(count - 1);
        return true;
    }
    
        return usedItem;
    }
    
    static InventoryItem[] createInventoryList() {
        
        InventoryItem[] inventory = new InventoryItem[5];
        InventoryItem axe = new InventoryItem();
        axe.setInventoryType("Axe");
        axe.setQuantityInStock(3);
        axe.setMaxItemsInStock(5);
        
        InventoryItem rope = new InventoryItem();
        rope.setInventoryType("Rope");
        rope.setQuantityInStock(0);
        rope.setMaxItemsInStock(5);
        
        InventoryItem water = new InventoryItem();
        water.setInventoryType("Bucket of Water");
        water.setQuantityInStock(0);
        water.setMaxItemsInStock(5);
        
        InventoryItem fire = new InventoryItem();
        fire.setInventoryType("Fire Extinguisher");
        fire.setQuantityInStock(0);
        fire.setMaxItemsInStock(5);
        
        InventoryItem key = new InventoryItem();
        key.setInventoryType("Master Key");
        key.setQuantityInStock(0);
        key.setMaxItemsInStock(5);
        
        inventory[Items.Rope.ordinal()] = rope;
        inventory[Items.FireExtinguisher.ordinal()] = fire;
        inventory[Items.BucketOfWater.ordinal()] = water;
        inventory[Items.Axe.ordinal()] = axe;
        inventory[Items.MasterKey.ordinal()] = key;
        
        return inventory;        
    }    
    
    public static InventoryItem[] getInventory() {  
        return GameControl.getCurrentGame().getInventory();        
//return  Charcoaled.getCurrentGame().getInventory();                
    }     
    
    public void updateInventory (InventoryItem[] inventory) {        
        GameControl.setGameInventory(inventory);
    }
}
