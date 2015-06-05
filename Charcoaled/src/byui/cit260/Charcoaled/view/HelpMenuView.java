/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import java.util.Scanner;

/**
 *
 * @author montchri
 */
public class HelpMenuView {

    public HelpMenuView() {
    }
    
    private final String MENU = "\n"
            +"\n---------"
            +"\n | Help Menu"
            +"\n --------"
            +"\n G - Game Objective"
            +"\n H - How to play"
            +"\n D - Difficulty levels"            
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
                this.displayGameObjective();
                break;
            case 'H':
                this.displayHowToPlay();
                break;
            case 'D':
                this.displayDifficultyLevels();
                break;         
            case 'E':
                return;
            default:
                System.out.println("\n** Invalid selection *** Please try again.");
        }        
    }

    private void displayGameObjective() {
        System.out.println("\n** display Game Objective stub function called **");
    }

    private void displayHowToPlay() {
        System.out.println("\n** display How to Play stub function called **");
    }

    private void displayDifficultyLevels() {
       System.out.println("\n** display Difficulty Levels stub function called **");
    }
}
