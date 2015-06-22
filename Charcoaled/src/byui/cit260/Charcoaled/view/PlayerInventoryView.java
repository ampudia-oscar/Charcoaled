/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import byu.cit260.Charcoaled.control.InventoryControl;

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
                
        //int axes = 1;        
        //int fires = 2;
        //int ropes = 3;
        //int waters = 4;
        
        InventoryControl ic = new InventoryControl();
        
        int axes = ic.getAxes();
        int fires = ic.getFires();
        int ropes = ic.getRopes();
        int waters = ic.getWaters();
        
        System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             You have: " + fires +" Fire extinguishers available             \n"
+ "                                                                             \n"
+ "             You have: " + axes +" Axes available                            \n"
+ "                                                                             \n"
+ "             You have: " + waters +" Buckets of Waters available             \n"
+ "                                                                             \n"
+ "             You have: " + ropes +" Ropes available                          \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
    }    
}