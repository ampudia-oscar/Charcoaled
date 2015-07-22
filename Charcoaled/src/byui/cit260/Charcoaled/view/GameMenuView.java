/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import Charcoaled.Charcoaled;
import byu.cit260.Charcoaled.control.GameControl;
import byu.cit260.Charcoaled.control.MapControl;
import byui.cit260.Charcoaled.model.Room;
import byui.cit260.Charcoaled.exceptions.GameControlException;
import byui.cit260.Charcoaled.exceptions.MapControlException;
import byui.cit260.Charcoaled.model.Person;
import java.awt.Point;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class GameMenuView extends View {

    public int floor;
    public int apartment;
    private int apartmentCount;
    private int floorCount;

    private static final PrintWriter raquelLogFile = Charcoaled.getRaquelLogFile();

    public GameMenuView() {
        super("__________________                         \n"
                + "   GAME MENU      \\________________________\n"
                + "                                           \n"
                + " W - Move up        M – Map                \n"
                + " A - Move left      V - View Items         \n"
                + " S - Move down                             \n"
                + " D - Move right                            \n"
                + " G - Enter Door                            \n"
                + " H - Enter Final Room                      \n"
                + " E - Exit                                  \n"
                + "___________________________________________");
        try {
            apartmentCount = MapControl.getRowCount();
            floorCount = MapControl.getColumnCount();
        } catch (GameControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
        }
    }

    @Override
    public boolean doAction(Object obj) {
        char selection = (char) obj;

        switch (selection) {
            case 'W':
                this.moveUp();
                break;
            case 'A':
                this.moveLeft();
                break;
            case 'S':
                this.moveDown();
                break;
            case 'D':
                this.moveRight();
                break;
            case 'G':
                this.enterDoor();
                break;
            case 'M': {
                try {
                    this.displayMap2();
                } catch (MapControlException e) {
                    ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
                }
            }
            break;
            case 'V':
                this.viewItems();
                break;
            case 'R':
                this.dropItems();
                break;
            case 'P':
                this.pauseGame();
                break;
            case 'X':
                this.saveGame();
                break;
            case 'H':
                if (this.finalRoom()) {
                    System.exit(0);
                }
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

    private int moveDown() {

        if (floor > 0) {
            floor -= 1;
            try {
                GameControl.getCurrentGame().setPlayerPosition(new Point(apartment, floor));
            } catch (GameControlException e) {
                ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            }
        }
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "  You are on floor " + floor + ", apartment " + apartment + ".  \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
        /*"You are on floor " + floor + ", apartment " + apartment + "."
         + "\n ___ "
         + "\n|" + floor + "|" + apartment + "|"
         + "\nIIIII"*/
        );
        return floor;
    }

    private int moveLeft() {

        if (apartment > 0) {
            apartment -= 1;
            try {
                GameControl.getCurrentGame().setPlayerPosition(new Point(apartment, floor));
            } catch (GameControlException e) {
                ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            }
        }
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "  You are on floor " + floor + ", apartment " + apartment + ".  \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
        /*"You are on floor " + floor + ", apartment " + apartment + "."
         + "\n ___ "
         + "\n|" + floor + "|" + apartment + "|"
         + "\nIIIII"*/
        );
        return apartment;
    }

    private int moveUp() {

        int x = floorCount - 1;
        //if (floor < 4) {
        if (floor < x) {
            floor += 1;
            try {
                GameControl.getCurrentGame().setPlayerPosition(new Point(apartment, floor));
            } catch (GameControlException e) {
                ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            }
        }
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "  You are on floor " + floor + ", apartment " + apartment + ".  \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
        /*"You are on floor " + floor + ", apartment " + apartment + "."
         + "\n ___ "
         + "\n|" + floor + "|" + apartment + "|"
         + "\nIIIII"*/
        );
        return floor;
    }

    private int moveRight() {

        int x = apartmentCount - 1;
        //if (apartment < 4) {
        if (apartment < x) {
            apartment += 1;
            try {
                GameControl.getCurrentGame().setPlayerPosition(new Point(apartment, floor));
            } catch (GameControlException e) {
                ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            }
        }
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "  You are on floor " + floor + ", apartment " + apartment + ".  \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
        /*"You are on floor " + floor + ", apartment " + apartment + "."
         + "\n ___ "
         + "\n|" + floor + "|" + apartment + "|"
         + "\nIIIII"*/
        );
        return apartment;
    }

    private void enterDoor() {

        RoomMenuView roomMenu = new RoomMenuView();
        roomMenu.setX(apartment);
        roomMenu.setY(floor);
        roomMenu.setRoomVisited(apartment, floor);
        roomMenu.displayNumberOfPeopleThatNeedsRescue();
        roomMenu.displayMenu();
    }

    private void viewItems() {
        PlayerInventoryView piv = new PlayerInventoryView();
        piv.displayMenu();
    }

    private void dropItems() {
        this.console.println(
                "\n***** dropItems() function called *****\n");
    }

    private void pauseGame() {
        this.console.println(
                "\n***** pauseGame() function called *****\n");
    }

    private void saveGame() {
        this.console.println(
                "\n***** saveGame() function called *****\n");
    }

    private void displayMap() {
        this.console.println(
                "\n"
                + "\n                   (  .    )                       "
                + "\n               )          (           )            "
                + "\n                     .  '  .  '  .  ' .            "
                + "\n            (    , )      (.  )  (  ',    )        "
                + "\n             .' ) ( . )   , ( ,     )  ( .         "
                + "\n          ). , ( .   (  )( ,')  .' ( ,    )        "
                + "\n         (_,) . ), ) _) _,')  (, ) '. ) ,.         "
                + "\n         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^         "
                + "\n         _._._._._._._._._._._._._._._._._         "
                + "\n         | ___   ___    ___    ___   ___ |         "
                + "\n         ||5|1| |5|2|  |5|3|  |5|4| |5|5||         "
                + "\n         |IIIII_IIIII__IIIII__IIIII_IIIII|         "
                + "\n         | ___   ___    ___    ___   ___ |         "
                + "\n         ||4|1| |4|2|  |4|3|  |4|4| |4|5||         "
                + "\n         |IIIII_IIIII__IIIII__IIIII_IIIII|         "
                + "\n         | ___   ___    ___    ___   ___ |         "
                + "\n )o(_    ||3|1| |3|2|  |3|3|  |3|4| |3|5||         "
                + "\n/(|)\'    |IIIII_IIIII__IIIII__IIIII_IIIII|        "
                + "\n H)o(_   | ___   ___    ___    ___   ___ |         "
                + "\n  /(|)\'  ||2|1| |2|2|  |2|3|  |2|4| |2|5||        "
                + "\n  H H    |IIIII_IIIII__IIIII__IIIII_IIIII|    /)   "
                + "\n  H H    | ___   ___   _____   ___   ___ | __/ ),  "
                + "\n   ~ ^~^ ||1|1| |1|2|  o~|~o  |1|4| |1|5||  ~^~^   "
                + "\n  . ' .'.|IIIII_IIIII__|_|_|__IIIII_IIIII|'^~^'.', "
                + "\n .,  , .|             /=====\\            |. . . . "
                + "\n   `~ `  ^^~   ^^~'`  '     ` ,``~^^   ~^^     ~   "
                + "\n .                     ,   '                       "
                + "\n ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
    }

    private void writePersonRoomInformationToFile(Room room, int row, int column) {
        row++;
        column++;

        try {

            raquelLogFile.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Room information: " + row + ", " + column + " ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            Person[] persons = room.getPersonsToRescue();

            if (persons == null) {
                return;
            }

            for (int x = 0; x < persons.length; x++) {
                String needsRescue = java.lang.Boolean.toString(persons[x].isNeedsRescue());
                raquelLogFile.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Person #: " + x + "  Needs Rescue? : " + needsRescue + " ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            }

            raquelLogFile.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ END ROOM: " + row + ", " + column + " ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n\n\n");
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
        }
    }

    private void displayMap2() throws MapControlException {

        try {
            this.console.println(
                    "\n"
                    + "\n      (  .    )                "
                    + "\n       )     (           )     "
                    + "\n          .'  .  '  .  ' .     "
                    + "\n    (    , )  (.  ) (  ',    ) "
                    + "\n     .' ) ( . ) , ( ,   )  ( . "
                    + "\n  ). ,( .  (  )( ,') .' ( ,  ) "
                    + "\n (_,). ), )  _)_,') (, ) '.),. "
                    + "\n ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ "
                    + "\n _._._._._._._._._._._._._._._ "
                    + "\n|=============================| "
            );

            Room[][] rooms = MapControl.getAllRooms();
            int row = 0;
            row = GameControl.getMap().getRowCount();
            int column = 0;
            column = GameControl.getMap().getColumnCount();

            for (int x = row; x > 0; x--) {
                this.console.println(
                        "\n  ___   ___   ___   ___   ___  "
                );
                for (int y = 0; y < column; y++) {
                    int x2 = x - 1;
                    Room room = rooms[y][x2];
                    writePersonRoomInformationToFile(room, y, x2);
                    //addFunctionHere to display items in room
                    if (room.isVisited()) {
                        this.console.print(
                                " | ✓ |"
                        );
                    } else {
                        this.console.print(
                                " |???|"
                        );
                    }
                }
                this.console.println(
                        "\n IIIII IIIII IIIII IIIII IIIII"
                );
            }
            this.console.println(
                    "\n  . . . .|  /=====\\  |. . . . "
                    + "\n  ~ ^^~'   /=======\\ ,``~^ ~^~"
                    + "\n                              "
            );
        } catch (GameControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
        }
    }

    public void setXY() {
        try {
            floor = GameControl.getCurrentGame().getPlayerPosition().x;
            apartment = GameControl.getCurrentGame().getPlayerPosition().y;
        } catch (GameControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
        }
    }

    private boolean finalRoom() {

        String gameFinalKey = null;

        try {
            gameFinalKey = GameControl.gamefinalKey();

        } catch (GameControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            return false;
        }

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "Enter the final Pass key \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");

        String userFinalKey = getInput();
        if (!gameFinalKey.equals(userFinalKey)) {
            this.console.println(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "  That was not the correct answer !!!!!!\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            return false;
        }

        boolean allPersonRescued = false;

        try {
            allPersonRescued = MapControl.allPersonRescued();
        } catch (MapControlException | GameControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
            return false;
        }

        if (!allPersonRescued) {
            this.console.println(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "  You MUST rescue all Persons in the building !!!!!!\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
            return false;
        }

        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "  You have FINISHED THE GAME !!!!!!\n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        return true;
    }
}