/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.exceptions;

/**
 *
 * @author raquel and oscar
 */
public class ObstacleControlException extends Exception {

    public ObstacleControlException() {
    }

    public ObstacleControlException(String string) {
        super(string);
    }

    public ObstacleControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ObstacleControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ObstacleControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }    
}