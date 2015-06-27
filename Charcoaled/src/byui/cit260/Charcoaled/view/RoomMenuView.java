/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;
import byu.cit260.Charcoaled.control.InventoryControl;
import byu.cit260.Charcoaled.control.MapControl;
import byu.cit260.Charcoaled.control.ObstacleControl;
import byui.cit260.Charcoaled.model.Items;
import byui.cit260.Charcoaled.model.Person;
import byui.cit260.Charcoaled.model.Room;

/**
 *
 * @author Raquel
 */
public class RoomMenuView  extends View {
    
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public RoomMenuView() { 
        super(
            "________________                             \n" +
            "   Room MENU     \\___________________________\n" +
            "                                              \n" +
            " W - Use Axe                                  \n" +
            " A - Use Fire Ext                             \n" +
            " S - Use Rope            P  - Rescue Person   \n" +
            " D - Use Water                                \n" +
            " E - Exit                                     \n" +
            " I - View Player Inventory                    \n" +
            " R - View Items in Room                       \n" +
            "_______________________________________________"  
           );
    }    
    
    public void displayNumberOfPeopleThatNeedsRescue(){        
        
        Room room = MapControl.getCurrentRoom(x, y);
        Person[] persons = room.getPersonsToRescue();
        if (persons != null)        
            System.out.println("Number of People that needs Rescue:" + persons.length);
        else 
           System.out.println("There are no People to rescue in this room");
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
        
        int x =  Items.Axe.ordinal();
        if (InventoryControl.useItem(x))
           usedItemMessage("Axe");
       else 
           NoItemMessage("Axe");
    }            

    private void useFireExt() {
        
        int x =  Items.Fire.ordinal();
       
        if (InventoryControl.useItem(x))
            usedItemMessage("Fire Extinguisher");
        else 
            NoItemMessage("Fire Extinguisher");
    }

    private void useWater() {
        int x =  Items.Axe.ordinal();
         
        if (InventoryControl.useItem(x))
            usedItemMessage("Bucket of Water");
        else 
            NoItemMessage("Bucket of Water");
    }

    private void useRope() {
  
        int x =  Items.Axe.ordinal();
        if (InventoryControl.useItem(x))
            usedItemMessage("Rope");
        else 
            NoItemMessage("Rope");
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
        Room room = MapControl.getCurrentRoom(x, y);
        RoomItemView riv = new RoomItemView();
        riv.setRoom(room);
        riv.displayMenu();
    }

    void setRoomVisited(int apartment, int floor) {
        Room room = MapControl.getCurrentRoom(x, y);
        MapControl.setRoomVisited(room);
    }
}