/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Charcoaled;

import byui.cit260.Charcoaled.model.Player;

/**
 *
 * @author oscar
 */
public class Charcoaled {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("John Doe");
        playerOne.setBestTime(7.00);
        playerOne.setGender("Male");
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
}
