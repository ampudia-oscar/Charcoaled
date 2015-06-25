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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
