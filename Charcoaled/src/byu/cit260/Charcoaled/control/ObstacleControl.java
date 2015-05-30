/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

/**
 *
 * @author oscar
 */
public class ObstacleControl {
    public double calcPyramidVol(double length, double width, double height){
        if (length < 1 || length > 25) {
        return -1;
        }
        
        if (width < 1 || width > 25) {
        return -1;
        }
        
        if (height < 1 || height > 25) {
        return -1;
        }
        
        double volume = (length * width * height)/3;
        return volume;
    }
    
    public double calcTrapeziumVol (double length, double height, double Base, double base){
        if (length < 1 || height < 1 || Base < 1 || base < 1){
        return -1;
        }

        if (length > 25 || height > 25 || Base > 25 || base > 24){
        return -1;
        }
    
        double volume = length * height * ((Base + base)/2);
        return volume;
        
    
    }
    public double calcKiteArea (double side, double base) {
        if (base < 1 || side < 1){
        return -1;
        }
        if (base > 20 || side > 30){
        return -1;
        }
    
        double area = (base * side) / 2;
        return area;
    }
    
    
    public double calcHoursToSeconds( double hours){
        if (hours < 1){
        return -1;
                }

        if (hours > 50){
        return -1;
        }
        
        double seconds = hours * 3600;
        return seconds;
        
    }
    
}
