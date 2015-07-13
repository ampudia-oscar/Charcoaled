/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import Charcoaled.Charcoaled;
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

    static MapBuilding createMap() throws MapControlException {

        MapBuilding map = new MapBuilding(5, 5, 2);
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
            return "You have rescued the person! This person has a passkey and it IS: " + person.getPassKey();
        return "You have rescued the person! This person does not have a Pass Key, Sorry";
    }

    public static Room[][] getAllRooms() {

        //return GameControl.getMap().getRooms();        
        Game game = Charcoaled.getCurrentGame();
        MapBuilding map = game.getMap();
        return map.getRooms();
    }

    public static void setRoomVisited(Room room) {
        room.setVisited(true);
    }

    static void moveActorToStartingLocation(MapBuilding map) {
    }
}
