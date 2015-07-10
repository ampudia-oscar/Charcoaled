/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import Charcoaled.Charcoaled;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Oscar and Raquel
 */
public abstract class View implements ViewInterface {

    private String promptMessage;
    protected final BufferedReader keyboard = Charcoaled.getInFile();
    protected final PrintWriter console = Charcoaled.getOutFile();

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
            
            this.console.println(this.promptMessage);
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

        try {
            while (!valid) {
                this.console.println("\nSelect a value");
                //input = keyboard.nextLine();
                input = this.keyboard.readLine();
                input = input.trim();

                if (input.length() < 1) {
                    this.console.println(
                            "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                            + "               Invalid value - Please, try again.               \n"
                            + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
                    continue;
                }
                break;
            }
        } catch (Exception e) {            
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());            
        }
        return input;
    }
}