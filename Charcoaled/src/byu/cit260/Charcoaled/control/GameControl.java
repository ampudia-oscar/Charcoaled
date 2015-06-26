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
import byui.cit260.Charcoaled.model.MapBuilding;
import java.awt.Point;

 /*
 * @author oscar
 */
public class GameControl {
    

    public static void createNewGame(Player player) {
        System.out.println(
                "\n***** createNewGame() stub function called *****\n");     
        Game game = new Game();
        game.setPlayerPosition(new Point(1,1));
        Charcoaled.setCurrentGame(game);
        game.setPlayer(player);
        InventoryItem[] inventoryList = InventoryControl.createPlayerInventory();
        GameControl.setGameInventory(inventoryList);        
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
    
    public static Game getCurrentGame()
    {
        Game game = Charcoaled.getCurrentGame();
        return game;
    }

    public static void setGameInventory(InventoryItem[] inventory) {
        Game game = GameControl.getCurrentGame();
        game.setInventory(inventory);           
    }        
    
    public static MapBuilding getMap (){
        Game game = Charcoaled.getCurrentGame();
        MapBuilding map = game.getMap();
        return map;
    }
}