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
public class InventoryItem implements Serializable {

    private String inventoryType;
    private int quantityInStock;
    private int maxItemsInStock;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.inventoryType);
        hash = 97 * hash + this.quantityInStock;
        hash = 97 * hash + this.maxItemsInStock;
        return hash;
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "inventoryType=" + inventoryType + ", quantityInStock=" + quantityInStock + ", maxItemsInStock=" + maxItemsInStock + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InventoryItem other = (InventoryItem) obj;
        if (!Objects.equals(this.inventoryType, other.inventoryType)) {
            return false;
        }
        if (this.quantityInStock != other.quantityInStock) {
            return false;
        }
        if (this.maxItemsInStock != other.maxItemsInStock) {
            return false;
        }
        return true;
    }

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
