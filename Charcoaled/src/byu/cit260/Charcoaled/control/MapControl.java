/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import Charcoaled.Charcoaled;
import byui.cit260.Charcoaled.exceptions.GameControlException;
import byui.cit260.Charcoaled.exceptions.MapControlException;
import byui.cit260.Charcoaled.model.Game;
import byui.cit260.Charcoaled.model.MapBuilding;
import byui.cit260.Charcoaled.model.Person;
import byui.cit260.Charcoaled.model.Room;

/**
 *
 * @author oscar
 */
public class MapControl {

    public static int getRowCount() throws GameControlException {        
        return GameControl.getMap().getRowCount();
    }
    
    public static int getColumnCount() throws GameControlException {        
        return GameControl.getMap().getColumnCount();
    }
    
    static MapBuilding createMap(int x, int y) throws MapControlException {

        MapBuilding map = new MapBuilding(x, y);
        //MapBuilding map = null;
        if (map == null) {
            throw new MapControlException("Creation of Map failed!");
        }
        return map;
    }

    public static Room getCurrentRoom(int x, int y) {
        Game game = Charcoaled.getCurrentGame();
        MapBuilding map = game.getMap();
        //MapBuilding map = GameControl.getMap();
        Room[][] rooms = map.getRooms();
        Room room = rooms[x][y];
        return room;
    }
    
    public static String setPersonAsRescued(Room room, int x) {
        
        Person[] persons = room.getPersonsToRescue();
        Person person = persons[x];
        person.setNeedsRescue(false);
        if (person.isHasFinalPassKey())
            return "You have rescued the person! This person has the FINAL password and it IS: " + person.getPassKey();
        return "You have rescued the person! This person does not have a Pass Key, Sorry";
    }

    public static Room[][] getAllRooms() throws MapControlException  {

        //return GameControl.getMap().getRooms();        
        try {
            Game game = Charcoaled.getCurrentGame();
            MapBuilding map = game.getMap();
            return map.getRooms();
        } catch (Exception e) {
            throw new MapControlException(e.getMessage());
        }
    }

    public static void setRoomVisited(Room room) {
        room.setVisited(true);
    }

    static void moveActorToStartingLocation(MapBuilding map) {
    }

    public static boolean allPersonRescued() throws MapControlException, GameControlException {
        
        Room[][] allRooms = MapControl.getAllRooms();
        int row = 0;
        row = GameControl.getMap().getRowCount();
        int column = 0;
        column = GameControl.getMap().getColumnCount();

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                Room room = allRooms[x][y];

                Person[] persons = room.getPersonsToRescue();

                if (persons == null) {
                    continue;
                }

                for (Person person : persons) {
                    boolean needsRescue = person.isNeedsRescue();
                    if (needsRescue) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
