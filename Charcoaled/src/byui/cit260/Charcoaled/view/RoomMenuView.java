/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import byu.cit260.Charcoaled.control.InventoryControl;
import static byu.cit260.Charcoaled.control.InventoryControl.addItemToInventory;
import byu.cit260.Charcoaled.control.MapControl;
import byu.cit260.Charcoaled.control.ObstacleControl;
import byui.cit260.Charcoaled.exceptions.ObstacleControlException;
import byui.cit260.Charcoaled.model.InventoryItem;
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
                + " P - Rescue Person  (Challange)               \n"
                + " W - Rescue Person with Axe                   \n"
                + " A - Rescue Person with Fire Extinguisher     \n"
                + " S - Rescue Person with Rope                  \n"
                + " D - Rescue Person with Bucket of Water       \n"
                + " G - Display Person Information               \n"
                + " I - View Player Inventory                    \n"
                + " R - View Items in Room                       \n"
                + " V - Pickup Items in Room                     \n"
                + " E - Exit                                     \n"
                + "______________________________________________"
        );
    }

    public void displayNumberOfPeopleThatNeedsRescue() {

        Room room = MapControl.getCurrentRoom(x, y);
        Person[] persons = room.getPersonsToRescue();
        if (persons != null) {
            this.console.println(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "Total persons in the room: " + persons.length
            );

            int needRescue = 0;

            for (int x = 0; x < persons.length; x++) {
                if (persons[x].isNeedsRescue()) {
                    needRescue++;
                }
            }

            this.console.println(
                      "Number of people that need to be Rescued: " + needRescue + "\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
            );

        } else {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tThere are no People to rescue in this room           \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }
    }

    @Override
    public boolean doAction(Object obj) {
        char selection = (char) obj;
        switch (selection) {
            case 'W':
                this.useAxe();
                break;
            case 'G':
                this.displayNumberOfPeopleThatNeedsRescue();
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
                this.startChallangeQuestion();
                break;
            case 'I':
                this.viewPlayerIventory();
                break;
            case 'R':
                this.viewRoomItems();
                break;
            case 'V':
                this.pickItems();
                break;
            case 'E':
                return true;
            default:
                this.console.println(
                          "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                        + "\tInvalid selection - Please, try again.             \n"
                        + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }
        return true;
    }

    private void pickItems() {

        pickItemType(Items.Fire.ordinal());
        pickItemType(Items.Axe.ordinal());
        pickItemType(Items.Rope.ordinal());
        pickItemType(Items.Water.ordinal());
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Picked up the items! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        PlayerInventoryView piv = new PlayerInventoryView();
        piv.viewPlayerItems(false);
    }

    private void pickItemType(int itemType) {
        InventoryItem[] roomInventory = InventoryControl.getRoomInventory(MapControl.getCurrentRoom(x, y));
        InventoryItem roomItem = roomInventory[itemType];
        int itemQuantity = roomItem.getQuantityInStock();

        for (int k = 0; k < itemQuantity; k++) {

            if (addItemToInventory(itemType)) {
                int count = roomItem.getQuantityInStock();
                roomItem.setQuantityInStock(count - 1);
            }
        }
    }

    private void rescuePersonWithItem(String itemType) {

        int positionPersonToRescue = personToRescue();
        if (positionPersonToRescue == -1) {
            return;
        }
        rescuePerson(MapControl.getCurrentRoom(x, y), positionPersonToRescue);
        usedItemMessage(itemType);
    }

    private void useAxe() {

        int positionPersonToRescue = personToRescue();
        if (positionPersonToRescue == -1) {
            return;
        }

        int z = Items.Axe.ordinal();
        if (InventoryControl.useItem(z)) {
            rescuePersonWithItem("Axe");
        } else {
            noItemMessage("Axe");
        }
    }

    private void useFireExt() {

        int positionPersonToRescue = personToRescue();
        if (positionPersonToRescue == -1) {
            return;
        }

        int z = Items.Fire.ordinal();

        if (InventoryControl.useItem(z)) {
            rescuePersonWithItem("Fire Extinguisher");
        } else {
            noItemMessage("Fire Extinguisher");
        }
    }

    private void useWater() {
        int positionPersonToRescue = personToRescue();
        if (positionPersonToRescue == -1) {
            return;
        }

        int z = Items.Water.ordinal();

        if (InventoryControl.useItem(z)) {
            rescuePersonWithItem("Bucket of Water");
        } else {
            noItemMessage("Bucket of Water");
        }
    }

    private void useRope() {
        int positionPersonToRescue = personToRescue();
        if (positionPersonToRescue == -1) {
            return;
        }

        int z = Items.Rope.ordinal();
        if (InventoryControl.useItem(z)) {
            rescuePersonWithItem("Rope");
        } else {
            noItemMessage("Rope");
        }
    }

    private void usedItemMessage(String itemType) {
        this.console.println(
                  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "\tYou have used the " + itemType + "!                \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
    }

    private void noItemMessage(String itemType) {
        this.console.println(
                  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "\tYou don't have any " + itemType + " left!          \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
    }

    private void rescuePerson(Room room, int positionPersonToRescue) {

        String masterKey = MapControl.setPersonAsRescued(room, positionPersonToRescue);
        this.console.println(
                  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "\t" + masterKey + "\n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

    }

    private int personToRescue() {
        Room room = MapControl.getCurrentRoom(x, y);
        Person[] persons = room.getPersonsToRescue();
        if (persons == null) {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tThere are no People to rescue in this room          \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            return -1;
        }

        boolean personNeedRescue = false;
        int positionPersonToRescue = 0;

        for (int x = 0; x < persons.length; x++) {
            if (persons[x].isNeedsRescue()) {
                positionPersonToRescue = x;
                personNeedRescue = true;
                break;
            }
        }

        if (!(personNeedRescue)) {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tThere are no People to rescue in this room          \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            return -1;
        }

        return positionPersonToRescue;
    }

    private void startChallangeQuestion() {
        // calcTrianglePrismArea

        int positionPersonToRescue = personToRescue();
        if (positionPersonToRescue == -1) {
            return;
        }

        int k = (int) (Math.random() * 100);

        if (k > 0 && k < 20) {
            boolean correctAnswer = solvePrism();
            if (correctAnswer) {
                rescuePerson(MapControl.getCurrentRoom(x, y), positionPersonToRescue);
            }
        }
        if (k > 20 & k < 40) {
            boolean correctAnswer = solvePyramidVol();
            if (correctAnswer) {
                rescuePerson(MapControl.getCurrentRoom(x, y), positionPersonToRescue);
            }
        }
        if (k > 40 & k < 60) {
            boolean correctAnswer = solveHoursToSeconds();
            if (correctAnswer) {
                rescuePerson(MapControl.getCurrentRoom(x, y), positionPersonToRescue);
            }
        }
        if (k > 60 & k < 80) {
            boolean correctAnswer = solveTrapeziumVol();
            if (correctAnswer) {
                rescuePerson(MapControl.getCurrentRoom(x, y), positionPersonToRescue);
            }
        }
        if (k > 80 & k < 100) {
            boolean correctAnswer = solveKiteArea();
            if (correctAnswer) {
                rescuePerson(MapControl.getCurrentRoom(x, y), positionPersonToRescue);
            }
        }
    }

    private boolean solveHoursToSeconds() {
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value (1 - 50) to Convert hours to Seconds! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int hours = getIntNumber();
        ObstacleControl instance = new ObstacleControl();
        int result = 0;
        try {
            result = instance.calcHoursToSeconds(hours);
        } catch (ObstacleControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            return false;
        }

        this.console.println(
                  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + " Solve the following Calculation: Convert " + hours + " hours to Seconds  \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int userAnswer = this.getIntNumber();

        if (result == userAnswer) {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tYou have Rescued the Person!!!\n");
            return true;
        } else {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tThe answer is " + result + ".                   \n"
                    + "\tYou have Failed to Rescue the Person !!!           \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            return false;
        }
    }

    private boolean solvePrism() {

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for A (1 - XX) to Solve the Area of a Prism! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        double a = this.getDoubleNumber();

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for B (1 - XX) to Solve the Area of a Prism! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        double b = this.getDoubleNumber();

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for C (1 - XX) to Solve the Area of a Prism! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        double c = this.getDoubleNumber();

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Height (1 - XX) to Solve the Area of a Prism! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        double height = this.getDoubleNumber();

        double result = 0;
        //a = 0;

        ObstacleControl instance = new ObstacleControl();
        try {
            result = instance.calcTrianglePrismArea(a, b, c, height);
        } catch (ObstacleControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            return false;
        }

        this.console.println(
                  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + " Solve the following Calculation:\n"
                + " The Triangle Prism Area for a=" + a + ", b=" + b + ", c=" + c + ", height=" + height + ".  \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        double userAnswer = 0;
        int intResult = (int) result;
        try {
            userAnswer = this.getDoubleNumber();

            if (result == userAnswer) {
                this.console.println(
                          "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                        + "\tYou have Rescued the Person!!!\n");
                return true;
            } else {
                this.console.println(
                          "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                        + "\tThe answer is " + intResult + ".                   \n"
                        + "\tYou have Failed to Rescue the Person !!!           \n"
                        + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
                return false;
            }
        } catch (NumberFormatException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: You must enter a valid number. Try again or enter Q to quit.  " + e.getMessage());
            return false;
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

        try {

            while (number <= 0) {

                String value = this.getInput();
                value = value.trim().toUpperCase();

                if (value.equals("Q")) {
                    break;
                }
                number = Integer.parseInt(value);
            }
        } catch (Exception ex) {
            ErrorView.display("RoomMenuView", ex.getMessage());
        }
        return number;
    }

    private boolean solvePyramidVol() {
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Lenght (1 - 25) to Solve the Volume of a Pyramid! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int lenght = getIntNumber();

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Width (1 - 25) to Solve the Volume of a Pyramid! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int width = getIntNumber();

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Height (1 - 25) to Solve the Volume of a Pyramid! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int heigth = getIntNumber();

        ObstacleControl instance = new ObstacleControl();
        double result = 0;

        try {
            result = instance.calcPyramidVol(lenght, width, heigth);
        } catch (ObstacleControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            return false;
        }
        int intResult = (int) result;

        this.console.println(
                  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "Solve the following Calculation: Calculate the volume of a Pyramid \n"
                + "Enter answer as whole Integer and always round your number UP!! \n"
                + "\tLength = " + lenght + "\n"
                + "\tWidth = " + width + "\n"
                + "\tHeight = " + heigth + "\n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int userAnswer = Integer.parseInt(this.getInput());

        if (intResult == userAnswer) {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tYou have Rescued the Person!!!\n");
            return true;
        } else {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tYou have Failed to Rescue the Person the answer WAS " + intResult + " !!!  \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            return false;
        }
    }

    private boolean solveTrapeziumVol() {
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Lenght (1 - 25) to Solve the Volume of a Trapezium! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int lenght = getIntNumber();

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Height (1 - 25) to Solve the Volume of a Trapezium! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int height = getIntNumber();

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Base (1 - 25) to Solve the Volume of a Trapezium! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int Base = getIntNumber();

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for base (1 - 24) to Solve the Volume of a Trapezium! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int base = getIntNumber();

        ObstacleControl instance = new ObstacleControl();
        double result = 0;

        try {
            result = instance.calcTrapeziumVol(lenght, height, Base, base);
        } catch (ObstacleControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            return false;
        }
        int intResult = (int) result;
        this.console.println(
                  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "Solve the following Calculation: Calculate the volume of a Trapezium \n"
                + "Enter answer as whole Integer and always round your number UP!! \n"
                + "\tLength = " + lenght + "\n"
                + "\tWidth = " + height + "\n"
                + "\tHeight = " + Base + "\n"
                + "\tHeight = " + base + "\n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int userAnswer = Integer.parseInt(this.getInput());

        if (intResult == userAnswer) {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tYou have Rescued the Person!!!\n");
            return true;
        } else {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tYou have Failed to Rescue the Person the answer WAS " + intResult + " !!! \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            return false;
        }
    }

    private boolean solveKiteArea() {
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Side (1 - 30) to Calculate the Area of a Kite! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        int side = getIntNumber();

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Enter a value for Base (1 - 20) to Calculate the Area of a Kite! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        int base = getIntNumber();

        ObstacleControl instance = new ObstacleControl();
        int result = 0;
        try {
            result = instance.calcKiteArea(side, base);
        } catch (ObstacleControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            return false;
        }
        int intResult = (int) result;
        this.console.println(
                  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "Solve the following Calculation: Calculate the Area of a Kite \n"
                + "Enter answer as whole Integer and always round your number UP!! \n"
                + "\tBase = " + base + "\n"
                + "\tSide = " + side + "\n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        int userAnswer = this.getIntNumber();

        if (intResult == userAnswer) {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tYou have Rescued the Person!!!\n");
            return true;
        } else {
            this.console.println(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "\tThe answer is " + intResult + ".                   \n"
                    + "\tYou have Failed to Rescue the Person !!!           \n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            return false;
        }
    }
}
