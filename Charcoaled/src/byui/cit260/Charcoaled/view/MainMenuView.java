/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;


import Charcoaled.Charcoaled;
import byu.cit260.Charcoaled.control.GameControl;
import byui.cit260.Charcoaled.view.GameMenuView;
import java.util.Scanner;

/**
 *
 * @author oscar and raquel
 */
public class MainMenuView {
    
    private final String MENU = 
        "__________________                     \n" +
        "    MAIN MENU     \\____________________\n" +
        "                                       \n" +
        " G - Start Existing Game               \n" +
        " N - Start New Game                    \n" +
        " H - Get help on how to play the game  \n" +
        " S - Save Game                         \n" +
        " E - Exit                              \n" +
        "_______________________________________";
    
    void displayMenu(){
        
        char selection = ' ';
        do{
            System.out.println(MENU);
            
            String input = this.getInput();
            selection = input.charAt(0);
            
            this.doAction(selection);
        }while(selection !='E');
        
        //System.out.println("*** MainMenuView.displayMenu() function called ***");
    }
    
    private String getInput() {

        boolean valid = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        
        while(!valid) {        
            System.out.println("\nSelect a value:");
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.length() > 1) {
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
            case 'G':
            case 'g':
                this.startExistingGame();
                break;
            case 'N':
            case 'n':
                this.startNewGame();
                break;
            case 'H':
            case 'h':    
                this.displayHelpMenu();
                break;
            case 'S':
            case 's':
                this.saveGame();
                break;
            case 'E':
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
+"\n                                                   "
+"\n             Save the people and pets              "
+"\n       in the building before it burns down.       "
+"\n                                                   "        
+"\n                  COME BACK SOON!                  "
+"\n                                                   " 
+"\n ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
                return;
            default:
                System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             Invalid selection - Please, try again.             \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
        }        
    }

    private void startExistingGame() {
        GameControl.startExistingGame(Charcoaled.getPlayer());
    }

    private void startNewGame() {
        GameControl.createNewGame(Charcoaled.getPlayer());
        GameMenuView gameMenu = new GameMenuView();
    }

    private void displayHelpMenu() {
        HelpMenuView hmv = new HelpMenuView();
        hmv.displayMenu();
    }

    private void saveGame() {
        GameControl.saveGame(Charcoaled.getPlayer());
    }
    
    
}
