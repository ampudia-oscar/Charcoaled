/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import byu.cit260.Charcoaled.control.InventoryControl;
import byui.cit260.Charcoaled.model.InventoryItem;
import byui.cit260.Charcoaled.model.Room;

/**
 *
 * @author Oscar
 */
public class RoomItemView extends View {

    private Room room;

    public void setRoom(Room room) {
        this.room = room;
    }
    
     public RoomItemView() { 
        super("__________________                \n" +
            "   Room Item MENU  \\_______________\n" +
            "                                    \n" +
            " W - View Available Items in room   \n" +
            " I - View Player Inventory          \n" +
            "____________________________________");
    }   

    @Override
    public boolean doAction(Object obj) {        
        char selection = (char)obj;
        switch(selection){
            case 'W':
                this.viewRoomItems();
                break;
            case 'I':  
                this.viewPlayerIventory();
                break;
           case 'E':
                return true;
            default:
                System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             Invalid selection - Please, try again.             \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
        }  
        return true;
    }

    private void viewRoomItems() {
                
         InventoryItem[] inventory = room.getRoomInventory();
        System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        
        for (InventoryItem item : inventory) {
           System.out.println( " There are :" + item.getQuantityInStock() + "    " + item.getInventoryType() + " available  in the ROOM    \n");
        }               
    } 

     private void viewPlayerIventory() {
        PlayerInventoryView piv = new PlayerInventoryView();        
        piv.displayMenu();
    }     
}
