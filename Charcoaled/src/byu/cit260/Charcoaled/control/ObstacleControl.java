/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byu.cit260.Charcoaled.control;

import byui.cit260.Charcoaled.exceptions.ObstacleControlException;

/**
 *
 * @author oscar
 */
public class ObstacleControl {

    public int calcPyramidVol(int length, int width, int height) throws ObstacleControlException {
        if (length < 1 || length > 25) {
            throw new ObstacleControlException(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "The lenght is less than 1 OR more than 25 :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }

        if (width < 1 || width > 25) {
            throw new ObstacleControlException(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "The width is less than 1 OR more than 25 :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }

        if (height < 1 || height > 25) {
            throw new ObstacleControlException(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "The height is less than 1 OR more than 25 :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }

        double volume2 = length * width * height / 3;
        volume2 = Math.ceil(volume2);
        int volume = (int) volume2;

        return volume;
    }

    public int calcTrapeziumVol(int length, int height, int Base, int base) throws ObstacleControlException {
        if (length < 1 || height < 1 || Base < 1 || base < 1) {
            throw new ObstacleControlException(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "The length OR the height OR the Base OR the base are less than 1  :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }

        if (length > 25 || height > 25 || Base > 25 || base > 24) {
            throw new ObstacleControlException(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "The length OR the height OR the Base OR are more than 25 OR the base more than 24 :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }

        double volume2 = length * height * ((Base + base) / 2);
        volume2 = Math.ceil(volume2);
        int volume = (int) volume2;
        return volume;
    }

    public int calcTrianglePrismArea(double a, double b, double c, double height) throws ObstacleControlException {
        if (a < 1 || b < 1 || c < 1 || height < 1) {
            throw new ObstacleControlException(
                     "One of the Sides of the Prism is less than 1\n");
        }

        if ((a + c) < b) {
            throw new ObstacleControlException(
                    "The sum of A + C is less than B\n");
        }
        if ((a + b) < c) {
            throw new ObstacleControlException(
                    "The sum of A + B is less than C\n");
        }
        if ((b + c) < a) {
            throw new ObstacleControlException(
                     "The sum of B + C is less than A\n");
        }

        double s = (a + b + c) / 2;
        double Ab = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        double Area2 = 2 * Ab + (height * (a + b + c));
        Area2 = Math.ceil(Area2);
        int Area = (int) Area2;
        return Area;
    }

    public int calcKiteArea(int side, int base) throws ObstacleControlException {
        if (base < 1 || side < 1) {
            throw new ObstacleControlException(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "The base OR the side is less than 1 :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }
        if (base > 20 || side > 30) {
            throw new ObstacleControlException(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "The base is more than 20 OR the side is more than 30 :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }
        double area2 = (base * side) / 2;
        area2 = Math.ceil(area2);
        int area = (int) area2;
        return area;
    }

    public int calcHoursToSeconds(int hours) throws ObstacleControlException {
        if (hours < 1) {
            throw new ObstacleControlException(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "The hours are less than 1 :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }

        if (hours > 50) {
            throw new ObstacleControlException(
                    "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞ [ EXCEPTION! ] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n"
                    + "The hours are more than 50 :\n"
                    + "∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞[ END EXCEPTION!] ∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞\n");
        }

        int seconds = hours * 3600;
        return seconds;
    }
}
