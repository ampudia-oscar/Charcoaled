/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

/**
 *
 * @author Oscar
 */
public class RoomItemView extends View {

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
                this.viewItems();
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

    private void viewItems() {
                System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             ITEMS AVAILABLE IN ROOM             \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
    } 

     private void viewPlayerIventory() {
        PlayerInventoryView piv = new PlayerInventoryView();        
        piv.displayMenu();
    }
     
}
