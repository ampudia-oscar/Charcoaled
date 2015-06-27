/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import byui.cit260.Charcoaled.model.MapBuilding;
import byui.cit260.Charcoaled.model.Room;

/**
 *
 * @author oscar
 */
public class MapControl {

    static MapBuilding createMap() {
       MapBuilding map = new MapBuilding(5 , 5);
       return map;
    }
    
    public static Room getCurrentRoom(int x, int y)
    {
       MapBuilding map = GameControl.getMap();
       Room[][] rooms = map.getRooms();
       Room room = rooms[x][y];
       return room;
    }
    
    public static Room[][] getAllRooms() {
        
        return GameControl.getMap().getRooms();        
    }
    
    public static void setRoomVisited (Room room)
    {
        room.setVisited(true);        
    }
    

    static void moveActorToStartingLocation(MapBuilding map) {
        return;
    }    
}
