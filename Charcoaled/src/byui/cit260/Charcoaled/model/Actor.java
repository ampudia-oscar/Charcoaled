/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import java.io.Serializable;
import java.awt.Point;

/*
 * @author oscar
 */

public enum Actor implements Serializable {
    
    //class instance variables
    JohnDoe("Sargent Fir fighter"),
    JaneDoe("Caitan fighrer");

    private final String description;
    private final Point coordinates;

    Actor (String description){
        this.description = description;
        coordinates = new Point(1,1);
    }

    public String getDescription(){
        return description;
    }
    
    public Point getCoordinates() {
        return coordinates;
    }
}