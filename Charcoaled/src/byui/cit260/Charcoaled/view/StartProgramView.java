/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import byu.cit260.Charcoaled.control.ProgramControl;
import byui.cit260.Charcoaled.exceptions.ProgramControlException;
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
        Player player = null;
        try {
            player = ProgramControl.createPlayer(playerName);
        } catch (ProgramControlException ex) {
            System.out.println(ex.getMessage());
        }
        //DISPLAY a customized welcome message
        this.displayWelcomeMessage(player);
        //DISPLAY the main menu 
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayMenu();
    }

    private void displayBanner() {
 
         System.out.println(
"\n"
+"\n<<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>>"
+"\n ||    ____ _                               _          _   ||"
+"\n ||   / ___| |__   __ _ _ __ ___ ___   __ _| | ___  __| |  ||"
+"\n ||  | |   | '_ \\ / _` | '__/ __/ _ \\ / _` | |/ _ \\/ _` |  ||"
+"\n ||  | |___| | | | (_| | | | (_| (_) | (_| | |  __/ (_| |  ||"
+"\n ||   \\____|_| |_|\\__,_|_|  \\___\\___/ \\__,_|_|\\___|\\__,_|  ||"
+"\n ||                                                        ||"
+"\n<<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>>"
+"\n"
+"\n"        
+"\n                         …∞ WELCOME ∞…                        "
+"\n"
+"\n"
+"\n"
+"You play as a fireman/fire-woman. A large apartment complex\n"
+"is on fire and you are required to save the people or pets in\n"
+"the building before it burns down. There will be several rooms\n"
+"on each floor, and you have to use detective work to figure\n"
+"out what rooms the people are in.\n"
+"\n"
+"You will be required to overcome a number of obstacles by\n"
+"solving calculations of problems, or answering questions and\n"
+"riddles in order to unlock doors, resuscitate an unconscious\n"
+"person or to figure out if a room is too hot to enter. The\n"
+"game will be timed which will require you to work quickly to\n"
+"save everyone.\n"
+"\n   ,%,                                       _____[]_               "
+"\n   %%%,&&&,                     ,%%,       /        /\\              "
+"\n   %Y/%&&&&                     %%%%   ___/_____)__/ _\\__     ,%%,  "
+"\n ^^^||^&\\Y&^^^^^^^^^^^^^^^^^^^^^%Y/%^^/  \\     (  | /____/\\^^^%%%%^^"
+"\n   `    || _,..=xxxxxxxxxxxx,    ||   |(' |LI (.)I| | LI ||   %\\Y%  "
+"\n  -=      /L_Y.-\"\"\"\"\"\"\"\"\"`,-n-. `    *'---|__||___|_|____||_   ||   "
+"\n ________.--'[========]|L]J: []\\ __________*//*___________) )_______"
+"\n   _ _ _ |/ _ ''_ \" \" ||[ -_ 4 |  _  _  _  _  _  _  _  _  _  _  _  _"
+"\n         '-(_)-(_)----'v'-(_)--'                                    "
+"\n--------------------------------------------------------------------"
+"\n");

    }

    private String getPlayerName() {

        boolean valid = false;
        String playerName = null;
        Scanner keyboard = new Scanner(System.in);
        
        while(!valid) {        
            System.out.println("Enter the player's name below:");
            playerName = keyboard.nextLine();
            playerName = playerName.trim();
            
            if (playerName.length() < 2) {
                System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "           Invalid name - The name must not be blank            \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
                continue;
            }  
            break;
        }        
        return playerName;        
    }    
    
    public void displayWelcomeMessage(Player player){
        System.out.println(
  "\n∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "     Welcome to the game "+player.getName()+". We hope you have a lot of fun!\n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
    }
    
}
