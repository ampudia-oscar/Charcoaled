/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import Charcoaled.Charcoaled;
import byu.cit260.Charcoaled.control.GameControl;
import byui.cit260.Charcoaled.exceptions.GameControlException;
import byui.cit260.Charcoaled.exceptions.MapControlException;
import byui.cit260.Charcoaled.view.GameMenuView;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar and raquel
 */
public class MainMenuView extends View {

    public MainMenuView() {
        super(
                "__________________                      \n"
                + "    MAIN MENU     \\____________________\n"
                + "                                        \n"
                + " G - Start Existing Game                \n"
                + " N - Start New Game                     \n"
                + " H - Get help on how to play the game   \n"
                + " S - Save Game                          \n"
                + "                                        \n"
                + " E - Exit                               \n"
                + "________________________________________");
    }

    @Override
    public boolean doAction(Object obj) {

        char selection = (char) obj;

        switch (selection) {
            case 'G':
                this.startExistingGame();
                break;
            case 'N':
                this.startNewGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'E':
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
                        + "\n         || | | | | |  | | |  | | | | | ||         "
                        + "\n         |IIIII_IIIII__IIIII__IIIII_IIIII|         "
                        + "\n         | ___   ___    ___    ___   ___ |         "
                        + "\n         || | | | | |  | | |  | | | | | ||         "
                        + "\n         |IIIII_IIIII__IIIII__IIIII_IIIII|         "
                        + "\n         | ___   ___    ___    ___   ___ |         "
                        + "\n )o(_    || | | | | |  | | |  | | | | | ||         "
                        + "\n/(|)\'    |IIIII_IIIII__IIIII__IIIII_IIIII|         "
                        + "\n H)o(_   | ___   ___    ___    ___   ___ |         "
                        + "\n  /(|)\'  || | | | | |  | | |  | | | | | ||         "
                        + "\n  H H    |IIIII_IIIII__IIIII__IIIII_IIIII|    /)   "
                        + "\n  H H    | ___   ___   _____   ___   ___ | __/ ),  "
                        + "\n   ~ ^~^ || | | | | |  o~|~o  | | | | | ||  ~^~^   "
                        + "\n  . ' .'.|IIIII_IIIII__|_|_|__IIIII_IIIII|'^~^'.', "
                        + "\n .,  , .|             /=====\\            |. . . . "
                        + "\n   `~ `  ^^~   ^^~'`  '     ` ,``~^^   ~^^     ~   "
                        + "\n .                     ,   '                       "
                        + "\n                                                   "
                        + "\n             Save the people and pets              "
                        + "\n       in the building before it burns down.       "
                        + "\n                                                   "
                        + "\n                  COME BACK SOON!                  "
                        + "\n                                                   "
                        + "\n ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
                return true;
            default:
                System.out.println(
                        "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                        + "             Invalid selection - Please, try again.             \n"
                        + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
        }
        return true;
    }

    private void startExistingGame() {
        GameControl.startExistingGame(Charcoaled.getPlayer());
    }

    private void startNewGame() {
        try {
            GameControl.createNewGame(Charcoaled.getPlayer());
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.setXY();
            gameMenu.displayMenu();

        } catch (GameControlException me) {
            System.out.println(me.getMessage());
        } catch (MapControlException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayHelpMenu() {
        HelpMenuView hmv = new HelpMenuView();
        hmv.displayMenu();
    }

    private void saveGame() {
        GameControl.saveGame(Charcoaled.getPlayer());
    }
}
