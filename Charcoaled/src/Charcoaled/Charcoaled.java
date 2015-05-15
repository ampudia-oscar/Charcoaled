/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Charcoaled;

import byui.cit260.Charcoaled.model.Actor;
import byui.cit260.Charcoaled.model.Game;
import byui.cit260.Charcoaled.model.Inventory;
import byui.cit260.Charcoaled.model.Player;
import byui.cit260.Charcoaled.model.Room;

/**
 *
 * @author oscar
 */
public class Charcoaled {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Player.java
        Player playerOne = new Player();
        
        playerOne.setName("John Doe");
        playerOne.setBestTime(1800);
        playerOne.setGender("Male");
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        //Game.java
        Game gameOne = new Game();
        
        gameOne.setTotalTime(1800);
        gameOne.setRemainingTime(1800);
        
        String gameInfo = gameOne.toString();
        System.out.println(gameInfo);
        
        //Actor.java
        Actor actorOne = new Actor();
        
        actorOne.setName("Raquel");
        actorOne.setScore(100);
        actorOne.setRow(1);
        actorOne.setColumn(1);
        
        String actorInfo = actorOne.toString();
        System.out.println(actorInfo);
        
        //Room.java
        Room roomOne = new Room();
        
        roomOne.setCoordinates(321);
        roomOne.setStatus("Closed");
        
        String roomInfo = roomOne.toString();
        System.out.println(roomInfo);
        
        //Inventory.java
        
        Inventory inventoryOne = new Inventory();
        
        inventoryOne.setName("Axe");
        inventoryOne.setType("Tool");
        inventoryOne.setDescription("Firefighter Axe");
        inventoryOne.setTotalItems(1);
        inventoryOne.setMaxItems(1);
        
        String inventoryInfo = inventoryOne.toString();
        System.out.println(inventoryInfo);
    }
    
}
