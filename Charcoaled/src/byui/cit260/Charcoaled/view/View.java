/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import java.util.Scanner;

/**
 *
 * @author Oscar and Raquel
 */
public abstract class View implements ViewInterface {

    private String promptMessage;

    public View(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    @Override
    public void displayMenu() {
        char selection = ' ';
        do {
            System.out.println(this.promptMessage);
            String input = this.getInput();
            input = input.toUpperCase();
            selection = input.charAt(0);

            this.doAction(selection);
        } while (selection != 'E');
    }

    @Override
    public String getInput() {

        boolean valid = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);

        while (!valid) {
            System.out.println("\nSelect a value");
            input = keyboard.nextLine();
            input = input.trim();

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
}
