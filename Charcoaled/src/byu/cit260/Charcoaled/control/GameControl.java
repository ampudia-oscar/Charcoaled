/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import byui.cit260.Charcoaled.model.Player;
import byui.cit260.Charcoaled.model.Game;
import Charcoaled.Charcoaled;
import byui.cit260.Charcoaled.exceptions.GameControlException;
import byui.cit260.Charcoaled.exceptions.MapControlException;
import byui.cit260.Charcoaled.model.InventoryItem;
import byui.cit260.Charcoaled.model.MapBuilding;
import java.awt.Point;
import java.io.PrintWriter;

/*
 * @author oscar
 */
public class GameControl {
        
    public static void createNewGame(Player player) throws GameControlException, MapControlException {
           
        Game game = new Game();
        game.setPlayerPosition(new Point(0, 0));
        Charcoaled.setCurrentGame(game);
        game.setPlayer(player);
        InventoryItem[] inventoryList = InventoryControl.createPlayerInventory();
        GameControl.setGameInventory(inventoryList);
        MapBuilding map = MapControl.createMap();
        //map = null;
        game.setMap(map);
        MapControl.moveActorToStartingLocation(map);

    }

    public static void startExistingGame(Player player) {
        System.out.println( "\n***** startExistingGame() stub function called *****\n");
        
    }

    public static void saveGame(Player player) {
        System.out.println( "\n***** saveGame() stub function called *****\n");
    }

    public static Game getCurrentGame() throws GameControlException {
        Game game = Charcoaled.getCurrentGame();

        if (game == null) {
            throw new GameControlException(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "  Player was NULL :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }

        return game;
    }

    public static void setGameInventory(InventoryItem[] inventory) throws GameControlException {
        Game game = GameControl.getCurrentGame();

        if (game == null) {
            throw new GameControlException(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "  Player was NULL :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }

        game.setInventory(inventory);
    }

    public static MapBuilding getMap() throws GameControlException {
        Game game = Charcoaled.getCurrentGame();

        if (game == null) {
            throw new GameControlException(
                      "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "  Player was NULL :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }

        MapBuilding map = game.getMap();
        return map;
    }
}
