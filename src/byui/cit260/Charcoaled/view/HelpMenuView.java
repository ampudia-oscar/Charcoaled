/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import java.util.Scanner;

/**
 *
 * @author oscar and raquel
 */
public class HelpMenuView extends View {

    public HelpMenuView() {

        super(
                  "_________________         \n"
                + "   HELP MENU     \\_______\n"
                + "                          \n"
                + " G - Game Objective       \n"
                + " H - How to play          \n"
                + "                          \n"
                + " E - Exit                 \n"
                + "__________________________");
    }

    public boolean doAction(Object obj) {
        char selection = (char) obj;

        switch (selection) {
            case 'G':
                this.displayGameObjective();
                break;
            case 'H':
                this.displayHowToPlay();
                break;
            case 'E':
                return true;
            default:
                this.console.println(
                          "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                        + "\tInvalid selection - Please, try again.             \n"
                        + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }
        return true;
    }

    private void displayGameObjective() {
        this.console.println(
                  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ Game Objective ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + " You play as a fireman/fire-woman. A large apartment complex\n"
                + " is on fire and you are required to save the people in\n"
                + " the building before it burns down.\n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
    }

    private void displayHowToPlay() {
        this.console.println(
                  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ How to Play ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                + " • Go to every room of the building looking for people to rescue.\n"
                + " • All the answers of calculations should be rounded numbers.\n"
                + " • Pick up and use items in inventory to rescue them.\n"
                + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
    }

    private void viewPlayersInventory() {
        PlayerInventoryView piv = new PlayerInventoryView();
        piv.displayMenu();
    }
}
