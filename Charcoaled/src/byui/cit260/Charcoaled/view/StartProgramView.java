/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import byu.cit260.Charcoaled.control.ProgramControl;
import byui.cit260.Charcoaled.model.Player;
import java.util.Scanner;

/**
 *
 * @author Oscar and Raquel
 */
public class StartProgramView {
    
    public void startProgram(){
    
    
    //Display the banner screen
        this.displayBanner();
    //Get the players name
        String playerName = this.getPlayerName();
        
    //Create a new player
        
        Player player = ProgramControl.createPlayer(playerName);
    //DISPLAY a customized welcome message
        this.displayWelcomeMessage(player);
    //DISPLAY the main menu 
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayMenu();
    }

    private void displayBanner() {
 
         System.out.println("\n\n*****************************");
         System.out.println("You play as a fireman/fire-woman. A large apartment"
                 + "\n* complex is on fire and you are required to "
                 + "\n* save the people or pets in the building before it burns down. "
                 + "\n* There will be several rooms on each floor, and you have to use "
                 + "\n* detective work to figure out what rooms the people are in");
        
         System.out.println("You will be required to overcome a number of obstacles by solving"
            + "\n* calculations of problems, or answering questions and riddles in "
            + "\n* order to unlock doors, resuscitate an unconscious person or to "
            + "\n* figure out if a room is too hot to enter. The game will be timed "
            + "\n* which will require you to work quickly to save everyone." );

    }

    private String getPlayerName() {

        boolean valid = false;
        String playerName = null;
        Scanner keyboard = new Scanner(System.in);
        
        while(!valid) {        
            System.out.println("Enter the player's name below");
            playerName = keyboard.nextLine();
            playerName = playerName.trim();
            
            if (playerName.length() < 2) {
                System.out.println("Invalid name - the name must not be blank");
                continue;
            }  
            break;
        }        
        return playerName;        
    }    
    
    public void displayWelcomeMessage(Player player){
        System.out.println("\n\n========================================");
        System.out.println("\tWelcome to the game "+player.getName());
        System.out.println("\tWe hope you have a lot of fun!");
        System.out.println("========================================");
    }
    
}
