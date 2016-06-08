/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;
import java.awt.Color;
/**
 *
 * @author shawa1
 */
public class Block {
    Color color;
    Location location;

    public Block() {
        location = new Location();
        color = Color.RED;
    }
    public Block(Location loc){
        location = loc;
        color = Color.RED;
    }
    public Block(int r, int c) {
        location = new Location(r, c);
        color = Color.RED;
    }

    public int getR() {
        return location.getR();
    }

    public int getC() {
        return location.getC();
    }
    
    public Location getLocation(){
        return location;
    }
    
    //moves the block to a diferent location on the grid given a row and column value. 
    public void moveBlock(int newR, int newC) {
        location.setNewLocation(newR, newC);
    }
    
    public void moveBlock(Location loc){
        location.setNewLocation(loc);
}
    //returns a Location object which has the Location in the direction up (1), right (2), down (3), left (4). The default case returns the 
    //Block's current location
    public Location getNextLocationInDirection(int d){ //d = direction
        switch (d){
            case 1:
                return new Location(this.getR() - 1, this.getC());
                
            case 2:
                return new Location(this.getR(), this.getC() + 1);
                
            case 3: 
                return new Location(this.getR() + 1, this.getC());
                
            case 4:
                return new Location(this.getR(), this.getC() -1);
                
            default: return this.location;
        }
    }
}

