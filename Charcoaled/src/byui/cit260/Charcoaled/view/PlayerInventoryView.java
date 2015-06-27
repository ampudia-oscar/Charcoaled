/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import byu.cit260.Charcoaled.control.GameControl;
import byu.cit260.Charcoaled.control.InventoryControl;
import byui.cit260.Charcoaled.model.InventoryItem;

/**
 *
 * @author raquel
 */
public class PlayerInventoryView extends View {
    
    public PlayerInventoryView() { 
      super("__________________________                    \n" +
            "   Player's Iventory Menu\\___________________\n" +
            "                                              \n" +
            " W - View Player Inventory                    \n" +  
            " E - Exit                                     \n" +
           "_______________________________________________");
    }    
    
    @Override
    public boolean doAction(Object obj) {        
        char selection = (char)obj;
        switch(selection){
            case 'W':
                this.viewPlayerItems();
                break;                                                         
           case 'E':
                return true;
            default:
                System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             Invalid selection - Please, try again.             \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
        }  
        return true;
    }
  

    private void viewPlayerItems() {
               
        InventoryItem[] inventory = InventoryControl.getPlayerInventory();
        System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        
        for (InventoryItem item : inventory) {
           System.out.println( "             You have:" + item.getQuantityInStock() + "    " + item.getInventoryType() + " available. \n");
        }        
    }    
}