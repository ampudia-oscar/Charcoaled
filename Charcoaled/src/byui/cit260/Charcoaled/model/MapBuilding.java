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
 * @author Raquel
 */
public class MapBuilding implements Serializable{ 
    
    private int rowCount;
    private int columnCount;

    public MapBuilding() {
    }

    
    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.rowCount;
        hash = 37 * hash + this.columnCount;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MapBuilding other = (MapBuilding) obj;
        if (this.rowCount != other.rowCount) {
            return false;
        }
        if (this.columnCount != other.columnCount) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "MapBuilding{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + '}';
    }
    
    
}
