/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

/**
 *
 * @author Connor Coale User AC
 */
public class Location {

    int r;
    int c;

    public Location() {

    }

    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setNewLocation(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void setNewLocation(Location l) {
        this.r = l.getR();
        this.c = l.getC();
    }

    public boolean isEqualTo(Location otherLocation) {
        if (otherLocation.getR() == this.r) {
            if (otherLocation.getC() == this.c) {
                return true;
            }
        }

        return false;
    }
}