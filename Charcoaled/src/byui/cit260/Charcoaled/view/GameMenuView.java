/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class GameMenuView {

    public GameMenuView() {
    }
    
    private final String MENU = 
            "________________                              \n" +
            "   GAME MENU     \\___________________________\n" +
            "                                              \n" +
            " W - Move up             M – Map              \n" +
            " A - Move to the left    V - View Items       \n" +
            " S - Move don            R - Drop/Remove Items\n" +
            " D - Move to the right   P - Pause            \n" +
            " G - Enter Door          X - Save Game        \n" +
            "                                              \n" +
            " E - Exit                                     \n" +
           "_______________________________________________";
    
    void displayMenu(){
        
        char selection = ' ';
        do{
            System.out.println(MENU);
            
            String input = this.getInput();
            selection = input.charAt(0);
            
            this.doAction(selection);
        }while(selection !='E');
        
        
    }
    
    private String getInput() {

        boolean valid = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        
        while(!valid) {        
            System.out.println("\nSelect a value");
            input = keyboard.nextLine();
            input = input.trim();
            input = input.toUpperCase();
            
            if (input.length() < 1) {
                System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "               Invalid value - Please, try again.               \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
                continue;
            }  
            break;
        }        
        return input;        
    }

    private void doAction(char selection) {
        switch(selection){
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
                this.displayMap();
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
                return;
            default:
                System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             Invalid selection - Please, try again.             \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
        }        
    }

    public int apartment = 3;
    public int floor = 1;
    
    private int moveUp() {
        //System.out.println(
        //        "\n***** moveUp() function called *****\n");
        if (floor < 5){
            floor += 1;
        }
        System.out.println(
                 "You are on floor "+floor+", apartment "+apartment+"."
                +"\n ___ "
                +"\n|"+floor+"|"+apartment+"|"
                +"\nIIIII");
        return floor;
    }

    private int moveLeft() {
        //System.out.println(
        //        "\n***** moveLeft() function called *****\n");
        if (apartment > 1){
            apartment -= 1;
        }
        System.out.println(
                 "You are on floor "+floor+", apartment "+apartment+"."
                +"\n ___ "
                +"\n|"+floor+"|"+apartment+"|"
                +"\nIIIII");
        return apartment;
    }

    private int moveDown() {
       //System.out.println(
       //        "\n***** moveDown() function called *****\n");
        if (floor > 1){
            floor -= 1;
        }
        System.out.println(
                 "You are on floor "+floor+", apartment "+apartment+"."
                +"\n ___ "
                +"\n|"+floor+"|"+apartment+"|"
                +"\nIIIII");
        return floor;
    }
    private int moveRight() {
       //System.out.println(
       //        "\n***** moveRight() function called *****\n");
        if (apartment < 5){
            apartment += 1;
        }
        System.out.println(
                 "You are on floor "+floor+", apartment "+apartment+"."
                +"\n ___ "
                +"\n|"+floor+"|"+apartment+"|"
                +"\nIIIII");
        return apartment;
    }
    private void enterDoor() {
       System.out.println(
               "\n***** enterDoor() function called *****\n");
    }
    private void viewItems() {
       System.out.println(
               "\n***** viewItems() function called *****\n");
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
+"\n                   (  .    )                        "
+"\n               )          (           )           "  
+"\n                     .  '  .  '  .  ' .            " 
+"\n            (    , )      (.  )  (  ',    )         "
+"\n             .' ) ( . )   , ( ,     )  ( .          "
+"\n          ). , ( .   (  )( ,')  .' ( ,    )         "
+"\n         (_,) . ), ) _) _,')  (, ) '. ) ,.          "
+"\n         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^         "
+"\n         _._._._._._._._._._._._._._._._._         "
+"\n         | ___   ___    ___    ___   ___ |         "
+"\n         ||5|1| |5|2|  |5|3|  |5|4| |5|5||         "
+"\n         |IIIII_IIIII__IIIII__IIIII_IIIII|         "
+"\n         | ___   ___    ___    ___   ___ |         "
+"\n         ||4|1| |4|2|  |4|3|  |4|4| |4|5||         "
+"\n         |IIIII_IIIII__IIIII__IIIII_IIIII|         "
+"\n         | ___   ___    ___    ___   ___ |         "
+"\n )o(_    ||3|1| |3|2|  |3|3|  |3|4| |3|5||         "
+"\n/(|)\'    |IIIII_IIIII__IIIII__IIIII_IIIII|         "
+"\n H)o(_   | ___   ___    ___    ___   ___ |         "
+"\n  /(|)\'  ||2|1| |2|2|  |2|3|  |2|4| |2|5||         "
+"\n  H H    |IIIII_IIIII__IIIII__IIIII_IIIII|    /)   "
+"\n  H H    | ___   ___   _____   ___   ___ | __/ ),  "
+"\n   ~ ^~^ ||1|1| |1|2|  o~|~o  |1|4| |1|5||  ~^~^   "
+"\n  . ' .'.|IIIII_IIIII__|_|_|__IIIII_IIIII|'^~^'.', "
+"\n .,  , .|             /=====\\            |. . . . "
+"\n   `~ `  ^^~   ^^~'`  '     ` ,``~^^   ~^^     ~   "
+"\n .                     ,   '                       "
+"\n ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
    }
    
}