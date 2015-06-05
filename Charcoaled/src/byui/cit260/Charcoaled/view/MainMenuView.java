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
    
    private final String MENU = "\n"
            +"\n---------"
            +"\n | Main Menu"
            +"\n --------"
            +"\n G - Start Existing Game"
            +"\n N - Start New Game"
            +"\n H - Get help on how to play the game"
            +"\n S - Save Game"
            +"\n E - Exit"
            +"\n --------";
    
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
            System.out.println("Select a value");
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.length() > 1) {
                System.out.println("Invalid value");
                continue;
            }  
            break;
        }        
        return input;        
    }

    private void doAction(char selection) {
        switch(selection){
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
                return;
            default:
                System.out.println("\n** Invalid selection *** Please try again.");
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
