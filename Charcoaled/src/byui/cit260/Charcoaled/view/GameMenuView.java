/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.view;

import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class GameMenuView {

    public GameMenuView() {
    }
    
    private final String MENU = 
            "________________                  \n" +
            "   GAME MENU     \\_________________\n" +
            "                                   \n" +
            " W - Move up the stairs            \n" +
            " A - Move to the door to the left  \n" +
            " S - Move down the stairs          \n" +
            " D - Move to the door to the right \n" +
            " G - Enter Door                    \n" +
            " V - View Items                    \n" +
            " R - Drop/Remove Items             \n" +
            " P - Pause                         \n" +
            " X - Save Game                     \n" +
            " E - Exit                          \n" +
           "____________________________________";
    
    void displayMenu(){
        
        char selection = ' ';
        do{
            System.out.println(MENU);
            
            String input = this.getInput();
            selection = input.charAt(0);
            
            this.doAction(selection);
        }while(selection !='E');
        
    }
    
    private String getInput() {

        boolean valid = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        
        while(!valid) {        
            System.out.println("\nSelect a value");
            input = keyboard.nextLine();
            input = input.trim();
            input = input.toUpperCase();
            
            if (input.length() > 1) {
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

    private void doAction(char selection) {
        switch(selection){
            case 'W':  
                this.moveUp();
                break;
            case 'A':    
                this.moveLeft();
                break;
            case 'S':
                this.moveDown();
                break;         
            case 'D':
                this.moveRight();
                break; 
            case 'G':
                this.enterDoor();
                break; 
             case 'V':
                this.viewItems();
                break; 
            case 'R':
                this.dropItems();
                break; 
            case 'P':
                this.pauseGame();
                break; 
            case 'X':
                this.saveGame();
                break; 
           case 'E':
                return;
            default:
                System.out.println(
  "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ WARNING! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
+ "             Invalid selection - Please, try again.             \n"
+ "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n\n");
        }        
    }

    private void moveUp() {
        System.out.println(
                "\n***** moveUp() function called *****\n");
    }

    private void moveLeft() {
        System.out.println(
                "\n***** moveLeft() function called *****\n");
    }

    private void moveDown() {
       System.out.println(
               "\n***** moveDown() function called *****\n");
    }
    private void moveRight() {
       System.out.println(
               "\n***** moveRight() function called *****\n");
    }
    private void enterDoor() {
       System.out.println(
               "\n***** enterDoor() function called *****\n");
    }
    private void viewItems() {
       System.out.println(
               "\n***** viewItems() function called *****\n");
    }
    private void dropItems() {
       System.out.println(
               "\n***** dropItems() function called *****\n");
    }
    private void pauseGame() {
       System.out.println(
               "\n***** pauseGame() function called *****\n");
    }
    private void saveGame() {
       System.out.println(
               "\n***** saveGame() function called *****\n");
    }
}