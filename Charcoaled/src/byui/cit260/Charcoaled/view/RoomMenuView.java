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

    private void rescuePerson() {
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

        int x = (int) (Math.random() * 100);
        if (x > 0 && x < 20) {
            solvePrism();
        }
        if (x > 20 & x < 40) {
            solvePyramidVol();
        }
        if (x > 40 & x < 60) {
            solveHoursToSeconds();
        }
        if (x > 60 & x < 80) {
            solveTrapeziumVol();
        }
        if (x > 80 & x < 100) {
            solveKiteArea();
        }
    }

    private void solveHoursToSeconds() {
        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value (1 - 50) to Convert hours to Seconds! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int hours = getIntNumber();
        ObstacleControl instance = new ObstacleControl();
        int result = 0;
        try {
            result = instance.calcHoursToSeconds(hours);
        } catch (ObstacleControlException me) {
            System.out.println(me.getMessage());
            return;
        }

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "  Solve the following Calculation: Convert " + hours + " hours to Seconds  \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int userAnswer = this.getIntNumber();

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
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }
    }

    private void solvePrism() {

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for A (1 - XX) to Solve the Area of a Prism! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        double a = this.getDoubleNumber();

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for B (1 - XX) to Solve the Area of a Prism! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        double b = this.getDoubleNumber();

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for C (1 - XX) to Solve the Area of a Prism! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        double c = this.getDoubleNumber();

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Height (1 - XX) to Solve the Area of a Prism! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        double height = this.getDoubleNumber();

        double result = 0;
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

        double userAnswer = 0;

        try {
            userAnswer = this.getDoubleNumber();

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

    private int getIntNumber() {
        int number = 0;

        while (number <= 0) {

            String value = this.getInput();
            value = value.trim().toUpperCase();

            if (value.equals("Q")) {
                break;
            }
            number = Integer.parseInt(value);
        }
        return number;
    }

    private void solvePyramidVol() {
        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Lenght (1 - 25) to Solve the Volume of a Pyramid! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int lenght = getIntNumber();

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Width (1 - 25) to Solve the Volume of a Pyramid! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int width = getIntNumber();

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Height (1 - 25) to Solve the Volume of a Pyramid! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int heigth = getIntNumber();

        ObstacleControl instance = new ObstacleControl();
        double result = 0;

        try {
            result = instance.calcPyramidVol(lenght, width, heigth);
        } catch (ObstacleControlException me) {
            System.out.println(me.getMessage());
            return;
        }

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "  Solve the following Calculation: Calculate the volume of a Pyramid \n"
                + "Enter answer as whole Integer and always round your number UP!! \n"
                + "Length = " + lenght
                + "\n  Width = " + width
                + "\n  Height = " + heigth
                + "\n∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int userAnswer = Integer.parseInt(this.getInput());

        if (result == userAnswer) {
            System.out.println(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "                You have Rescued the Person !!!                 \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        } else {
            System.out.println(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "             You have Failed to Rescue the Person the answer WAS " + result + " !!!     \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }
    }

    private void solveTrapeziumVol() {
        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Lenght (1 - 25) to Solve the Volume of a Trapezium! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int lenght = getIntNumber();

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Height (1 - 25) to Solve the Volume of a Trapezium! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int height = getIntNumber();

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Base (1 - 25) to Solve the Volume of a Trapezium! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int Base = getIntNumber();

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for base (1 - 24) to Solve the Volume of a Trapezium! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int base = getIntNumber();

        ObstacleControl instance = new ObstacleControl();
        double result = 0;

        try {
            result = instance.calcTrapeziumVol(lenght, height, Base, base);
        } catch (ObstacleControlException me) {
            System.out.println(me.getMessage());
            return;
        }

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "  Solve the following Calculation: Calculate the volume of a Trapezium \n"
                + "Enter answer as whole Integer and always round your number UP!! \n"
                + "Length = " + lenght
                + "\n  Width = " + height
                + "\n  Height = " + Base
                + "\n  Height = " + base
                + "\n∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int userAnswer = Integer.parseInt(this.getInput());

        if (result == userAnswer) {
            System.out.println(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "                You have Rescued the Person !!!                 \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        } else {
            System.out.println(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "             You have Failed to Rescue the Person the answer WAS " + result + " !!!     \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }
    }

    private void solveKiteArea() {
        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Side (1 - 30) to Calculate the Area of a Kite! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        int side = getIntNumber();

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Base (1 - 20) to Calculate the Area of a Kite! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        int base = getIntNumber();

        ObstacleControl instance = new ObstacleControl();
        int result = 0;
        try {
            result = instance.calcKiteArea(side, base);
        } catch (ObstacleControlException me) {
            System.out.println(me.getMessage());
            return;
        }

        System.out.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "  Solve the following Calculation: Calculate the Area of a Kite \n"
                + "Enter answer as whole Integer and always round your number UP!! \n"
                + "Base = " + base
                + "\n  Side = " + side
                + "\n∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int userAnswer = this.getIntNumber();

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
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }
    }
}
