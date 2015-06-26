/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import byui.cit260.Charcoaled.model.InventoryItem;
import byui.cit260.Charcoaled.model.Items;

/**
 *
 * @author oscar
 */
public class InventoryControl {    
    
    //private static InventoryItem[] items;
    
    public static boolean useItem (int x) {
        
    
    InventoryItem item = InventoryControl.getPlayerSingleInventoryItem(x);
    InventoryItem[] items = InventoryControl.getPlayerInventory();
    int count = item.getQuantityInStock();

    if (count > 0) {    
        items[x].setQuantityInStock(count - 1);
        return true;
    }
        return false;
    }    
    
    
    public static InventoryItem[] createRoomInventoryList(int axes, int ropes, int waters, int fires, int keys) {
        
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
        fire.setInventoryType("Master Key");
        fire.setQuantityInStock(keys);
               
                
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
        axe.setInventoryType("Axe");
        axe.setQuantityInStock(5);
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
        inventory[Items.Fire.ordinal()] = fire;
        inventory[Items.Water.ordinal()] = water;
        inventory[Items.Axe.ordinal()] = axe;
        inventory[Items.MasterKey.ordinal()] = key;
        
        return inventory;        
    }    
    
    public static InventoryItem[] getPlayerInventory() {  
        return GameControl.getCurrentGame().getInventory();        
    }  
    
     public static InventoryItem[] getRoomInventory() {  
        return GameControl.getCurrentGame().getInventory();        
    }  
    
     public static InventoryItem getPlayerSingleInventoryItem(int x) {  
        
         InventoryItem[] items = InventoryControl.getPlayerInventory();
         InventoryItem item = items[x];
         return item;
    }
    
    public void updatePlayerInventory (InventoryItem[] inventory) {        
        GameControl.setGameInventory(inventory);
    }
}
