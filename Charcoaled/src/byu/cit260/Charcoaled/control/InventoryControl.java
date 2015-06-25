/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import byui.cit260.Charcoaled.model.InventoryItem;

/**
 *
 * @author oscar
 */
public class InventoryControl {    
    
    private static InventoryItem inventory = null;
    public  InventoryControl (){
        inventory = Charcoaled.Charcoaled.getInventory();    
    }
    
    public static int getAxes() {        
       //return Charcoaled.Charcoaled.getInventory().getNumberOfAxes();
        return inventory.getNumberOfAxes();
    }
    public static int getRopes() {        
       return inventory.getNumberOfRopes();
    }
    public static int getWaters() {        
       return inventory.getNumberOfWaters();
    }
    public static int getFires() {        
       return inventory.getNumberOfFireExtinguishers();
    }
    
    public void removeItemFromIventory (String itemType)
    {
        switch (itemType){            
            case "axe":
               inventory.setNumberOfAxes(getAxes() - 1);
                break;
            case "water" :
                inventory.setNumberOfWaters(getWaters() - 1);
                break;                  
            case "fires" :  
                inventory.setNumberOfFireExtinguishers(getFires() - 1);
                break;
            case "ropes" :  
                inventory.setNumberOfRopes(getRopes() - 1);
                break;
            default:
                return;
        }
    }
    
    public void addItemToInventory (String itemType)
    {
        switch (itemType){            
            case "axe":
               inventory.setNumberOfAxes(getAxes() +1);
                break;
            case "water" :
                inventory.setNumberOfWaters(getWaters() + 1);
                break;                  
            case "fires" :  
                inventory.setNumberOfFireExtinguishers(getFires() + 1);
                break;
            case "ropes" :  
                inventory.setNumberOfRopes(getRopes() + 1);
                break;
            default:
                return;
        }
    }
}
