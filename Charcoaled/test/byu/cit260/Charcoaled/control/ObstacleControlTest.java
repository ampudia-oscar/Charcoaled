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
        
        // Test Case #1
        double length = 9;
        double width = 22;
        double height = 23;
        ObstacleControl instance = new ObstacleControl();
        double expResult = 1518;
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
        
        
        //Test Case #3
        length = 20;
        height = -8;
        Base = -25;
        base = 18;
        expResult = -1;
        result = instance.calcTrapeziumVol(length, height, Base, base);
        assertEquals(expResult, result, 0.0);
        
        
        //Test Case #4
        length = 5;
        height = 28;
        Base = 12;
        base = 0;
        expResult = -1;
        result = instance.calcTrapeziumVol(length, height, Base, base);
        assertEquals(expResult, result, 0.0);
        
        
          //Test Case #5
        length = 1;
        height = 10;
        Base = 15;
        base = 14;
        expResult = 145;
        result = instance.calcTrapeziumVol(length, height, Base, base);
        assertEquals(expResult, result, 0.0);
        
        
         //Test Case #6
        length = 5;
        height = 15;
        Base = 10;
        base = 1;
        expResult = 412.5;
        result = instance.calcTrapeziumVol(length, height, Base, base);
        assertEquals(expResult, result, 0.0);
        
        
        //Test Case #7
        length = 15;
        height = 10;
        Base = 25;
        base = 20;
        expResult = 3375 ;
        result = instance.calcTrapeziumVol(length, height, Base, base);
        assertEquals(expResult, result, 0.0);
        
        
        //Test Case #8
        length = 5;
        height = 25;
        Base = 20;
        base = 15;
        expResult = 2187.5 ;
        result = instance.calcTrapeziumVol(length, height, Base, base);
        assertEquals(expResult, result, 0.0);
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
     /**
     * Test of calcKiteArea method, of class ObstacleControl.
     */
    @Test
    public void calcKiteArea() {
        System.out.println("calcKiteArea");
        
        // Test Case #1
        double base = 9;
        double side= 16;
        ObstacleControl instance = new ObstacleControl();
        double expResult = 72;
        double result = instance.calcKiteArea(base, side);
        assertEquals(expResult, result, 0.0);
        
        
        // Test Case #2
        base = -3;
        side= 25;
        expResult = -1;
        result = instance.calcKiteArea(base, side);
        assertEquals(expResult, result, 0.0);
        
        
        // Test Case #3
        base = 20;
        side= -35;
        expResult = -1;
        result = instance.calcKiteArea(base, side);
        assertEquals(expResult, result, 0.0);
        
        
        // Test Case #4
        base = 19;
        side= 35;
        expResult = -1;
        result = instance.calcKiteArea(base, side);
        assertEquals(expResult, result, 0.0);
        
        
        // Test Case #5
        base = 1;
        side= 5;
        expResult = 2.5;
        result = instance.calcKiteArea(base, side);
        assertEquals(expResult, result, 0.0);
        
        
        // Test Case #6
        base = 10;
        side= 1;
        expResult = 5;
        result = instance.calcKiteArea(base, side);
        assertEquals(expResult, result, 0.0);
        
        
        // Test Case #7
        base = 20;
        side= 10;
        expResult = 100;
        result = instance.calcKiteArea(base, side);
        assertEquals(expResult, result, 0.0);
        
        
        // Test Case #8
        base = 5;
        side= 30;
        expResult = 75;
        result = instance.calcKiteArea(base, side);
        assertEquals(expResult, result, 0.0);
        
        
}
        /**
        * Test of calcHoursToSeconds method, of class ObstacleControl.
        */
         @Test
        public void calcHoursToSeconds() {
        System.out.println("calcHoursToSeconds");
        
        // Test Case #1
        double hours = 45;
        ObstacleControl instance = new ObstacleControl();
        double expResult = 162000;
        double result = instance.calcHoursToSeconds(hours);
        assertEquals(expResult, result, 0.0);
        
        
        // Test Case #2
        hours = -17;
        expResult = -1;
         result = instance.calcHoursToSeconds(hours);
        assertEquals(expResult, result, 0.0);
        
        
         // Test Case #3
        hours = -35;
        expResult = -1;
         result = instance.calcHoursToSeconds(hours);
        assertEquals(expResult, result, 0.0);
        
        
         // Test Case #4
        hours = 0;
        expResult = -1;
         result = instance.calcHoursToSeconds(hours);
        assertEquals(expResult, result, 0.0);
        
        
        // Test Case #5
        hours = 1;
        expResult = 3600;
         result = instance.calcHoursToSeconds(hours);
        assertEquals(expResult, result, 0.0);
        
        
         // Test Case #6
        hours = 47;
        expResult = 169200;
         result = instance.calcHoursToSeconds(hours);
        assertEquals(expResult, result, 0.0);
        }
}
        
        
        
        
        
