/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.Charcoaled.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author oscar
 */
public class Game implements Serializable {

    //class instance variables
    private double totalTime;
    private double remainingTime;
    private Player player;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.remainingTime) ^ (Double.doubleToLongBits(this.remainingTime) >>> 32));
        hash = 19 * hash + Objects.hashCode(this.player);
        hash = 19 * hash + Arrays.deepHashCode(this.inventory);
        hash = 19 * hash + Objects.hashCode(this.map);
        hash = 19 * hash + Objects.hashCode(this.playerPosition);
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
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.remainingTime) != Double.doubleToLongBits(other.remainingTime)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inventory, other.inventory)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.playerPosition, other.playerPosition)) {
            return false;
        }
        return true;
    }
    private InventoryItem[] inventory;
    private MapBuilding map;

    @Override
    public String toString() {
        return "Game{" + "totalTime=" + totalTime + ", remainingTime=" + remainingTime + ", player=" + player + ", inventory=" + inventory + ", map=" + map + ", playerPosition=" + playerPosition + '}';
    }
    private Point playerPosition;

    public Point getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Point playerPosition) {
        this.playerPosition = playerPosition;
    }

    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }

    public MapBuilding getMap() {
        return map;
    }

    public void setMap(MapBuilding map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game() {
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(double remainingTime) {
        this.remainingTime = remainingTime;
    }
}