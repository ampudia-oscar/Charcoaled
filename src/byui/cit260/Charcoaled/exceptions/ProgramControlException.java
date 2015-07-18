/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.exceptions;

/**
 *
 * @author raquel
 */
public class ProgramControlException extends Exception {

    public ProgramControlException() {
    }

    public ProgramControlException(String string) {
        super(string);
    }

    public ProgramControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ProgramControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ProgramControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
