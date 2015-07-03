/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import byui.cit260.Charcoaled.exceptions.ObstacleControlException;
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
    public void ca() throws ObstacleControlException {
        //Test Case 1
        int a = 11;
        int b = 21;
        int c = 16;
        int height = 23;
        ObstacleControl instance = new ObstacleControl();
        double expResult = 96.65;
        double result = instance.calcTrianglePrismArea(a, b, c, height);
        assertEquals(expResult, result, 0.01);
        }    
}