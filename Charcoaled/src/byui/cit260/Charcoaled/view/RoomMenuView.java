/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import byu.cit260.Charcoaled.control.InventoryControl;
import byu.cit260.Charcoaled.control.MapControl;
import byu.cit260.Charcoaled.control.ObstacleControl;
import byui.cit260.Charcoaled.exceptions.ObstacleControlException;
import byui.cit260.Charcoaled.model.Items;
import byui.cit260.Charcoaled.model.Person;
import byui.cit260.Charcoaled.model.Room;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raquel
 */
public class RoomMenuView extends View {

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
                "_________________                             \n"
                + "   Room MENU     \\___________________________\n"
                + "                                              \n"
                + " P - Rescue Person                            \n"
                + " W - Use Axe                                  \n"
                + " A - Use Fire Ext                             \n"
                + " S - Use Rope                                 \n"
                + " D - Use Water                                \n"
                + "                                              \n"
                + " I - View Player Inventory                    \n"
                + " R - View Items in Room                       \n"
                + "                                              \n"
                + " E - Exit                                     \n"
                + "______________________________________________"
        );
    }

    public void displayNumberOfPeopleThatNeedsRescue() {

        Room room = MapControl.getCurrentRoom(x, y);
        Person[] persons = room.getPersonsToRescue();
        if (persons != null) {
            System.out.println(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "Number of People that needs Rescue: " + persons.length + ".    \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
            );
        } else {
            System.out.println(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "           There are no People to rescue in this room           \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
            );
        }
    }

    @Override
    public boolean doAction(Object obj) {
        char selection = (char) obj;
        switch (selection) {
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
        {
            try {
                this.rescuePerson();
            } catch (ObstacleControlException ex) {
                Logger.getLogger(RoomMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
                        + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }
        return true;
    }

    private static void useAxe() {

        int x = Items.Axe.ordinal();
        if (InventoryControl.useItem(x)) {
            usedItemMessage("Axe");
        } else {
            NoItemMessage("Axe");
        }
    }

    private void useFireExt() {

        int x = Items.Fire.ordinal();

        if (InventoryControl.useItem(x)) {
            usedItemMessage("Fire Extinguisher");
        } else {
            NoItemMessage("Fire Extinguisher");
        }
    }

    private void useWater() {
        int x = Items.Axe.ordinal();

        if (InventoryControl.useItem(x)) {
            usedItemMessage("Bucket of Water");
        } else {
            NoItemMessage("Bucket of Water");
        }
    }

    private void useRope() {

        int x = Items.Axe.ordinal();
        if (InventoryControl.useItem(x)) {
            usedItemMessage("Rope");
        } else {
            NoItemMessage("Rope");
        }
    }

    private static void usedItemMessage(String itemType) {
        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "             You have used the " + itemType + "!                \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
    }

    private static void NoItemMessage(String itemType) {
        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "             You don't have any " + itemType + " left!          \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
    }

    private void rescuePerson() throws ObstacleControlException {
        // calcTrianglePrismArea
        Room room = MapControl.getCurrentRoom(x, y);
        Person[] persons = room.getPersonsToRescue();
        if (persons == null) {
            System.out.println(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "            There are no People to rescue in this room          \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
            );
            return;
        }

        double a = Math.round(Math.random() * 10);
        double b = Math.round(Math.random() * 10);
        double c = Math.round(Math.random() * 10);
        double height = Math.round(Math.random() * 10);

        if ((a + c) < b) {
            a += b;
        }
        if ((a + b) < c) {
            a += c;
        }
        if ((b + c) < a) {
            b += a;
        }
        double result = 0.0;
        //a = 0;

        ObstacleControl instance = new ObstacleControl();
        try {
            result = instance.calcTrianglePrismArea(a, b, c, height);
        } catch (ObstacleControlException me) {
            System.out.println(me.getMessage());
            return;
        }

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "  Solve the following Calculation:\n"
                + "  The Triangle Prism Area for a=" + a + ", b=" + b + ", c=" + c + ", height=" + height + ".  \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        double userAnswer = 0.0;

        try {
            userAnswer = getDoubleNumber();

            if (result == userAnswer) {
                System.out.println(
                        "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                        + "                You have Rescued the Person !!!                 \n"
                        + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            } else {
                System.out.println(
                        "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                        + "                   The answer is " + result + ".                   \n"
                        + "             You have Failed to Rescue the Person !!!           \n"
                        + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                );
            }
        } catch (NumberFormatException ex) {
            System.out.println("\n You must enter a valid number. Try again or enter Q to quit.");
        }

        /* calcHoursToSeconds    
         double hours = Math.round(Math.random()*100);
         ObstacleControl instance = new ObstacleControl();        
         double result = instance.calcHoursToSeconds(hours);
        
         System.out.println(
         "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
         + "  Solve the following Calculation: Convert "+hours+" hours to Seconds  \n"
         + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
                
         double userAnswer = Double.parseDouble(this.getInput());
        
         if (result == userAnswer) {                
         System.out.println(
         "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
         + "                You have Rescued the Person !!!                 \n"
         + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
         }
        
         else {                
         System.out.println(
         "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
         + "             You have Failed to Rescue the Person !!!           \n"
         + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");                  
                                
         }*/
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
        Room room = MapControl.getCurrentRoom( x, y);
        MapControl.setRoomVisited(room);
    }

    private double getDoubleNumber() {
        Double number = null;        

        while (number == null) {
        
            String value = this.getInput();
            value = value.trim().toUpperCase();

            if (value.equals("Q")) {
                break;
            }
            number = Double.parseDouble(value);        
        }
        return number;
    }
}