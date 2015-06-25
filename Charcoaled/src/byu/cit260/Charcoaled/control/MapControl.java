/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import byui.cit260.Charcoaled.model.MapBuilding;

/**
 *
 * @author oscar
 */
public class MapControl {

    static MapBuilding createMap() {
       MapBuilding map = new MapBuilding(5 , 5);
       return map;
    }

    static void moveActorToStartingLocation(MapBuilding map) {
        return;
    }
    
}
