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
public class Person implements Serializable {
    
    private boolean hasFinalPassKey;
    private String passKey;
    private boolean needsRescue;

    public Person() {
    }
    

    @Override
    public String toString() {
        return "Person{" + "hasFinalPassKey=" + hasFinalPassKey + ", passKey=" + passKey + ", needsRescue=" + needsRescue + '}';
    }
    

    public boolean isHasFinalPassKey() {
        return hasFinalPassKey;
    }

    public void setHasFinalPassKey(boolean hasFinalPassKey) {
        this.hasFinalPassKey = hasFinalPassKey;
    }

    public String getPassKey() {
        return passKey;
    }

    public void setPassKey(String passKey) {
        this.passKey = passKey;
    }

    public boolean isNeedsRescue() {
        return needsRescue;
    }

    public void setNeedsRescue(boolean needsRescue) {
        this.needsRescue = needsRescue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.hasFinalPassKey ? 1 : 0);
        hash = 47 * hash + Objects.hashCode(this.passKey);
        hash = 47 * hash + (this.needsRescue ? 1 : 0);
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
        final Person other = (Person) obj;
        if (this.hasFinalPassKey != other.hasFinalPassKey) {
            return false;
        }
        if (!Objects.equals(this.passKey, other.passKey)) {
            return false;
        }
        if (this.needsRescue != other.needsRescue) {
            return false;
        }
        return true;
    }
    
    
}
