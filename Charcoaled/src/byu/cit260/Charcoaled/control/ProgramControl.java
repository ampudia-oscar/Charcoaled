/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import Charcoaled.Charcoaled;
import byui.cit260.Charcoaled.model.Player;

/**
 *
 * @author oscar and raquel
 */
public class ProgramControl {

    public static Player createPlayer(String playerName) {
        if (playerName == null){
            return null;
        }
        
        Player player = new Player();
        player.setName(playerName);
        
        Charcoaled.setPlayer(player);
        return player;
        
       //System.out.println("\n ** Create player function called **");
       //return null;
    }
    
}
