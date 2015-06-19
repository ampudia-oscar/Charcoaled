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
 * @author Raquel
 */
public class ObstacleControlTest2 {
    
    public ObstacleControlTest2() {
    }

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