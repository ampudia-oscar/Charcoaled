/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import byu.cit260.Charcoaled.control.GameControl;
import byu.cit260.Charcoaled.control.MapControl;
import byui.cit260.Charcoaled.model.Room;
import java.util.Scanner;
import byui.cit260.Charcoaled.view.RoomMenuView;
import java.awt.Point;

/**
 *
 * @author oscar
 */
public class GameMenuView extends View {

    public int floor = GameControl.getCurrentGame().getPlayerPosition().x;
    public int apartment = GameControl.getCurrentGame().getPlayerPosition().y;

    public GameMenuView() {
        super("________________                              \n"
                + "   GAME MENU     \\___________________________\n"
                + "                                              \n"
                + " W - Move up             M – Map              \n"
                + " A - Move to the left    V - View Items       \n"
                + " S - Move don            R - Drop/Remove Items\n"
                + " D - Move to the right   P - Pause            \n"
                + " G - Enter Door          X - Save Game        \n"
                + "                                              \n"
                + " E - Exit                                     \n"
                + "_______________________________________________");
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
            case 'M':
                this.displayMap2();
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

    private int moveDown() {
        //System.out.println(
        //        "\n***** moveUp() function called *****\n");
        if (floor > 0) {
            floor -= 1;    
            GameControl.getCurrentGame().setPlayerPosition(new Point(apartment, floor));
        }
        System.out.println(
                "You are on floor " + floor + ", apartment " + apartment + "."
                + "\n ___ "
                + "\n|" + floor + "|" + apartment + "|"
                + "\nIIIII");
        return floor;
    }

    private int moveLeft() {
        //System.out.println(
        //        "\n***** moveLeft() function called *****\n");
        if (apartment > 0) {
            apartment -= 1;
            GameControl.getCurrentGame().setPlayerPosition(new Point(apartment, floor));
        }
        System.out.println(
                "You are on floor " + floor + ", apartment " + apartment + "."
                + "\n ___ "
                + "\n|" + floor + "|" + apartment + "|"
                + "\nIIIII");
        return apartment;
    }

    private int moveUp() {
       //System.out.println(
        //        "\n***** moveDown() function called *****\n");
        if (floor < 4) {
            floor += 1;
            GameControl.getCurrentGame().setPlayerPosition(new Point(apartment, floor));
        }
        System.out.println(
                "You are on floor " + floor + ", apartment " + apartment + "."
                + "\n ___ "
                + "\n|" + floor + "|" + apartment + "|"
                + "\nIIIII");
        return floor;
    }

    private int moveRight() {
       //System.out.println(
        //        "\n***** moveRight() function called *****\n");
        if (apartment < 4) {
            apartment += 1;
            GameControl.getCurrentGame().setPlayerPosition(new Point(apartment, floor));
        }
        System.out.println(
                "You are on floor " + floor + ", apartment " + apartment + "."
                + "\n ___ "
                + "\n|" + floor + "|" + apartment + "|"
                + "\nIIIII");
        return apartment;
    }

    private void enterDoor() {
        System.out.println(
                "\n***** enterDoor() function called *****\n");

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
        System.out.println(
                "\n***** dropItems() function called *****\n");
    }

    private void pauseGame() {
        System.out.println(
                "\n***** pauseGame() function called *****\n");
    }

    private void saveGame() {
        System.out.println(
                "\n***** saveGame() function called *****\n");
    }

    private void displayMap() {
        System.out.println(
                "\n"
                + "\n                   (  .    )                        "
                + "\n               )          (           )           "
                + "\n                     .  '  .  '  .  ' .            "
                + "\n            (    , )      (.  )  (  ',    )         "
                + "\n             .' ) ( . )   , ( ,     )  ( .          "
                + "\n          ). , ( .   (  )( ,')  .' ( ,    )         "
                + "\n         (_,) . ), ) _) _,')  (, ) '. ) ,.          "
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
                + "\n/(|)\'    |IIIII_IIIII__IIIII__IIIII_IIIII|         "
                + "\n H)o(_   | ___   ___    ___    ___   ___ |         "
                + "\n  /(|)\'  ||2|1| |2|2|  |2|3|  |2|4| |2|5||         "
                + "\n  H H    |IIIII_IIIII__IIIII__IIIII_IIIII|    /)   "
                + "\n  H H    | ___   ___   _____   ___   ___ | __/ ),  "
                + "\n   ~ ^~^ ||1|1| |1|2|  o~|~o  |1|4| |1|5||  ~^~^   "
                + "\n  . ' .'.|IIIII_IIIII__|_|_|__IIIII_IIIII|'^~^'.', "
                + "\n .,  , .|             /=====\\            |. . . . "
                + "\n   `~ `  ^^~   ^^~'`  '     ` ,``~^^   ~^^     ~   "
                + "\n .                     ,   '                       "
                + "\n ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
    }

    private void displayMap2() {

        System.out.println(
                "\n"
                + "\n                   (  .    )                        "
                + "\n               )          (           )           "
                + "\n                     .  '  .  '  .  ' .            "
                + "\n            (    , )      (.  )  (  ',    )         "
                + "\n             .' ) ( . )   , ( ,     )  ( .          "
                + "\n          ). , ( .   (  )( ,')  .' ( ,    )         "
                + "\n         (_,) . ), ) _) _,')  (, ) '. ) ,.          "
                + "\n         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^         "
                + "\n         _._._._._._._._._._._._._._._._._         "
                + "\n         | ___   ___    ___    ___   ___ |         "
        );

        Room[][] rooms = MapControl.getAllRooms();
        int row = GameControl.getMap().getRowCount();
        int column = GameControl.getMap().getColumnCount();


        for (int x = row ; x > 0; x--) {
            System.out.println("\n ===================================== ");

            for (int y = 0; y < column; y++) {
                int x2 = x - 1;
                Room room = rooms[y][x -1];
                if (room.isVisited()) {
                    System.out.print("| VISITED " );
                } else {
                    System.out.print("| ??? ");
                }
            }
        }
        System.out.println("\n ===================================== \n");
    }
}
