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
        System.out.println("calcTrapeziumVol");
        double length = 15;
        double height = 10;
        double Base = 25;
        double base = 20;
        ObstacleControl instance = new ObstacleControl();
        double expResult = 3375;
        double result = instance.calcTrapeziumVol(length, height, Base, base);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
