/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oscar
 */
public class ObstacleControlTest {
    
    public ObstacleControlTest() {
    }

    /**
     * Test of calcPyramidVol method, of class ObstacleControl.
     */
    @Test
    public void testCalcPyramidVol() {
        System.out.println("calcPyramidVol");
        double length = 9;
        double width = 22;
        double height = 23;
        ObstacleControl instance = new ObstacleControl();
        double expResult = 1518.0;
        double result = instance.calcPyramidVol(length, width, height);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calcTrapeziumVol method, of class ObstacleControl.
     */
    @Test
    public void testCalcTrapeziumVol() {
        
//Test Case #1
        System.out.println("calcTrapeziumVol");
        double length = 12;
        double height = 6;
        double Base = 4;
        double base = 2;
        ObstacleControl instance = new ObstacleControl();
        double expResult = 216;
        double result = instance.calcTrapeziumVol(length, height, Base, base);
        assertEquals(expResult, result, 0.0);
        
        
        //Test Case #2
        length = -10;
        height = 12;
        Base = 15;
        base = -3;
        expResult = -1;
        result = instance.calcTrapeziumVol(length, height, Base, base);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
