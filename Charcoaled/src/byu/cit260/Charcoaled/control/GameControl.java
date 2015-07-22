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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * @author oscar
 */
public class GameControl {
        
    public static void createNewGame(Player player) throws GameControlException, MapControlException {
           
        Game game = new Game();
        int finalKey = (int) (Math.random() * 1000000000);
        finalKey = 100;
        String finalKeyString = Integer.toString(finalKey);
        game.setGameFinalKey(finalKeyString);
        game.setPlayerPosition(new Point(0, 0));
        Charcoaled.setCurrentGame(game);
        game.setPlayer(player);
        InventoryItem[] inventoryList = InventoryControl.createPlayerInventory();
        GameControl.setGameInventory(inventoryList);
        MapBuilding map = MapControl.createMap(1,1);
        //map = null;
        game.setMap(map);
        MapControl.moveActorToStartingLocation(map);
    }
    
    public static String gamefinalKey () throws GameControlException {        
        
        Game game = getCurrentGame();
        String finalKey = game.getGameFinalKey();
        return finalKey;        
    }

    public static void getSavedGame(String filePath) throws GameControlException {
        
        Game game = null;

        try (FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            game = (Game) input.readObject();
        } catch (FileNotFoundException e) {
            throw new GameControlException(e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            throw new GameControlException(e.getMessage());
        }
        Charcoaled.setCurrentGame(game);
    }

    public static void saveGame(Game game, String filePath) throws GameControlException {
        
        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            output.writeObject(game);
        } catch (IOException e) {
            throw new GameControlException(e.getMessage());
        }
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
