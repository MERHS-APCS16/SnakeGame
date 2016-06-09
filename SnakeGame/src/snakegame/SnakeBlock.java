/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;

/**
 *
 * @author Connor Coale User AC
 */
public class SnakeBlock extends Block{
    
    
    
    public SnakeBlock(int r, int c){
        location = new Location(r, c);
        color = Color.BLUE;
    }
    public SnakeBlock(Location loc){
        location = loc;
        color = Color.BLUE;
    }
    public SnakeBlock(SnakeBlock s){
        location = s.getLocation();
        color = Color.BLUE;
}
    public String toString(){
        String s;
        s = "Row: " + this.location.getR() + " \nColumn: " + this.location.getC();
        return s;
        
        
    }
}

