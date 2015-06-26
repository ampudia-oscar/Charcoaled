/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;
import byu.cit260.Charcoaled.control.InventoryControl;
import byu.cit260.Charcoaled.control.ObstacleControl;
import java.util.Scanner;
import byui.cit260.Charcoaled.view.PlayerInventoryView;
/**
 *
 * @author Raquel
 */
public class RoomMenuView  extends View {
    
    public RoomMenuView() { 
        super("________________                              \n" +
            "   Room MENU     \\___________________________\n" +
            "                                              \n" +
            " W - Use Axe                                  \n" +
            " A - Use Fire Ext                             \n" +
            " S - Use Rope            P  - Rescue Person    \n" +
            " D - Use Water                                \n" +
            " E - Exit                                     \n" +
            " I - View Player Inventory                    \n" +
            " R - View Items in Room                       \n" +
            "_______________________________________________");
    }    
    
    @Override
    public boolean doAction(Object obj) {        
        char selection = (char)obj;
        switch(selection){
            case 'W':
                this.useAxe();
                break;
            case 'A':  
                this.useFireExt();
                break;                             
            case 'D':    
                this.useWater();
                break;                                            
            case 'S':  
                this.useRope();
                break;                                                            
            case 'P':  
                this.rescuePerson();
                break;
            case 'I':  
                this.viewPlayerIventory();
                break;
            case 'R':  
                this.viewRoomItems();
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

    private static void useAxe() {        
       if (InventoryControl.useItem("Axe"))
           usedItemMessage("Axe");
       else 
           NoItemMessage("Axe");
    }        
    

    private void useFireExt() {
       
    }

    private void useWater() {
        
    }

    private void useRope() {
            
    }
    
    private static void usedItemMessage(String itemType)            
    {
                System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             You have used the " + itemType + "!!!             \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");    
    }
    
        private static void NoItemMessage(String itemType)            
    {
                System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             You don't have any " + itemType + "!!!   left           \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");    
    }

    private void rescuePerson() {
        
        double hours = 45;
        ObstacleControl instance = new ObstacleControl();        
        double result = instance.calcHoursToSeconds(hours);
        
        System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             Solve the following Calculation: Convert 45 hours to Seconds            \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
                
        double userAnswer = Double.parseDouble(this.getInput());
        
        if (result == userAnswer) {                
        System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             You have Rescued the Person !!!             \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
        }
        else {
                
                     System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             You have Failed to Rescue the Person !!!             \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");                  
                                
        }        
    }    

    private void viewPlayerIventory() {
        PlayerInventoryView piv = new PlayerInventoryView();        
        piv.displayMenu();
    }

    private void viewRoomItems() {
        RoomItemView riv = new RoomItemView();        
        riv.displayMenu();
    }
}