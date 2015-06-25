/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author raquel
 */
public enum Items implements Serializable {
    
    Rope("Rope dewscription"),
    FireExtinguisher("Fire extinguisher description"),
    Axe("Axe description"),
    Bucketofwater("etc etc"),
    Masterkey("etc etc etc");
    
    
    private final String description;

    Items (String description){
        this.description = description; 
    }

    public String getDescription(){
        return description;
    }
    
}
