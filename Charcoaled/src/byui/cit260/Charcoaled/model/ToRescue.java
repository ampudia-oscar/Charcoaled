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
public class ToRescue implements Serializable {
    
    private String name;
    private String gender;
    private boolean needsRescue;
    private String type;

    public ToRescue() {
    }

    @Override
    public String toString() {
        return "ToRescue{" + "name=" + name + ", gender=" + gender + ", needsRescue=" + needsRescue + ", type=" + type + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.gender);
        hash = 83 * hash + (this.needsRescue ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.type);
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
        final ToRescue other = (ToRescue) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (this.needsRescue != other.needsRescue) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
      
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isNeedsRescue() {
        return needsRescue;
    }

    public void setNeedsRescue(boolean needsRescue) {
        this.needsRescue = needsRescue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setneedsRescue(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
