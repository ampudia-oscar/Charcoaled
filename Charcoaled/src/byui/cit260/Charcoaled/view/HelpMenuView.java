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

        super("_________________        \n"
                + "   HELP MENU     \\_______\n"
                + "                         \n"
                + " G - Game Objective      \n"
                + " H - How to play         \n"
                + " D - Difficulty levels   \n"
                + " V - Player's Iventory   \n"
                + " E - Exit                \n"
                + "_________________________");
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
            case 'D':
                this.displayDifficultyLevels();
                break;
            case 'V':
                this.viewPlayersInventory();
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

    private void displayGameObjective() {
        System.out.println(
                "\n***** displayGameObjective() function called *****\n");
    }

    private void displayHowToPlay() {
        System.out.println(
                "\n***** displayHowToPlay() function called *****\n");
    }

    private void displayDifficultyLevels() {
        System.out.println(
                "\n***** displayDifficultyLevels() function called *****\n");
    }

    private void viewPlayersInventory() {
        PlayerInventoryView piv = new PlayerInventoryView();
        piv.displayMenu();
    }
}
