/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import java.io.Serializable;

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
}
