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
 * @author oscar
 */
public class InventoryItem implements Serializable{
    
    private String inventoryType;
    private int quantityInStock;
    private int maxItemsInStock;

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getMaxItemsInStock() {
        return maxItemsInStock;
    }

    public void setMaxItemsInStock(int maxItemsInStock) {
        this.maxItemsInStock = maxItemsInStock;
    }    
}