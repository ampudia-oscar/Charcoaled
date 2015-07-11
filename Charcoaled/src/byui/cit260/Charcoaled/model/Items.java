/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import java.io.Serializable;

/**
 * @author raquel
 */
public enum Items implements Serializable {

    Rope("Rope"),
    Fire("Fire Extinguisher"),
    Axe("Axe description"),
    Water("Bucket of Water"),
    MasterKey("Master Key");

    private final String description;

    Items(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}