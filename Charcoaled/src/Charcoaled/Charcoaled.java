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
import byui.cit260.Charcoaled.model.MapBuilding;
import byui.cit260.Charcoaled.model.Person;
import byui.cit260.Charcoaled.model.ToRescue;
import byui.cit260.Charcoaled.model.Obstacles;
import byui.cit260.Charcoaled.model.Items;
import byui.cit260.Charcoaled.view.StartProgramView;


/**
 *
 * @author oscar
 */
public class Charcoaled {
    

    /**
     * @param args the command line arguments
     */
    private static Player player = null;

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Charcoaled.player = player;
    }
    
    public static void main(String[] args) {
        
        StartProgramView spv = new StartProgramView();
        spv.startProgram();
         
        
     /*   
        //MapBuilding.java
        MapBuilding map = new MapBuilding();
        map.setRowCount(5);
        map.setColumnCount(10);
        String mapInfo = map.toString();
        System.out.println(mapInfo);
        
        //Obstacles.java
        Obstacles obstacles = new Obstacles();
        obstacles.setName("calculation");
        obstacles.setType("riddles");
        String obstaclesInfo = obstacles.toString();
        System.out.println(obstaclesInfo);

        
       //Items.java
        Items axe1 = new Items();
        axe1.setName("axe");
        axe1.setType ("axe");
        axe1.setUsed(false);
        String axe1Info = axe1.toString();
        System.out.println(axe1Info);
        
        
        //Person.java
        Person person = new Person();
        person.setHasFinalPassKey(true);
        person.setNeedsRescue(true);
        person.setPassKey("key");
        String personInfo = person.toString();
        System.out.println(personInfo);
        
        //ToRescue.java
        ToRescue rescue = new ToRescue();
        rescue.setName("raquel");
        rescue.setGender("female");
        rescue.setNeedsRescue(true);
      
        String toRescueInfo = rescue.toString();
        System.out.println(toRescueInfo);
               
     
        
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
        
        roomOne.setRow(5);
        roomOne.setColumn(5);
        roomOne.setVisited(true);
        roomOne.setAmountRemaining(24);
        
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
    */
    }
    
}
