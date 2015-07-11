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
                this.startSavedGame();
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
                this.console.println(
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
                this.console.println(
                        "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                        + "             Invalid selection - Please, try again.             \n"
                        + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
        }
        return true;
    }

    private void startSavedGame() {
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "             Please enter the file path of saved game.             \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
        String filePath = this.getInput();
        try {
            GameControl.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.setXY();
        gameMenu.displayMenu();
    }

    private void startNewGame() {
        try {
            GameControl.createNewGame(Charcoaled.getPlayer());
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.setXY();
            gameMenu.displayMenu();

        } catch (GameControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());
        } catch (MapControlException e) {
            ErrorView.display(this.getClass().getName(), "ERROR: " + e.getMessage());;
        }
    }

    private void displayHelpMenu() {
        HelpMenuView hmv = new HelpMenuView();
        hmv.displayMenu();
    }

    private void saveGame() {        
        this.console.println(
                "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ INFORMATION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + "             Please enter the file path for file where to save the game.             \n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
        String filePath = this.getInput();
        try {
            GameControl.saveGame(Charcoaled.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }
}