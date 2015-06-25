/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import byui.cit260.Charcoaled.model.Player;
import byui.cit260.Charcoaled.model.Game;
import Charcoaled.Charcoaled;
import byui.cit260.Charcoaled.model.InventoryItem;
import byui.cit260.Charcoaled.model.Items;
import byui.cit260.Charcoaled.model.MapBuilding;
import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author oscar
 */
public class GameControl {

    public static void createNewGame(Player player) {
        System.out.println(
                "\n***** createNewGame() stub function called *****\n");       
        
        Game game = new Game();
        Charcoaled.setCurrentGame(game);
        game.setPlayer(player);
        InventoryItem[] inventoryList = GameControl.createIventoryList();
        game.setInventory(inventoryList);
        
        MapBuilding map = MapControl.createMap();
        game.setMap(map);
        MapControl.moveActorToStartingLocation(map);
        
    }

    public static void startExistingGame(Player player) {
        System.out.println(
                "\n***** startExistingGame() stub function called *****\n");
    }

    public static void saveGame(Player player) {
        System.out.println(
                "\n***** saveGame() stub function called *****\n");
    }

    private static InventoryItem[] createIventoryList() {
        
        InventoryItem[] inventory = new InventoryItem[5];
        InventoryItem axe = new InventoryItem();
        axe.setInventoryType("Axe");
        axe.setQuantityInStock(0);
        axe.setMaxItemsInStock(5);
        
        InventoryItem rope = new InventoryItem();
        rope.setInventoryType("Rope");
        rope.setQuantityInStock(0);
        rope.setMaxItemsInStock(5);
        
        InventoryItem water = new InventoryItem();
        water.setInventoryType("Bucket of Water");
        water.setQuantityInStock(0);
        water.setMaxItemsInStock(5);
        
        InventoryItem fire = new InventoryItem();
        fire.setInventoryType("Fire Extinguisher");
        fire.setQuantityInStock(0);
        fire.setMaxItemsInStock(5);
        
        InventoryItem key = new InventoryItem();
        key.setInventoryType("Master Key");
        key.setQuantityInStock(0);
        key.setMaxItemsInStock(5);
        
        inventory[Items.Rope.ordinal()] = rope;
        inventory[Items.FireExtinguisher.ordinal()] = fire;
        inventory[Items.BucketOfWater.ordinal()] = water;
        inventory[Items.Axe.ordinal()] = axe;
        inventory[Items.MasterKey.ordinal()] = key;
        
        return inventory;        
        
    }

    public static InventoryItem[] getInventory() {
        
        return  Charcoaled.getCurrentGame().getInventory();                
    }        
}