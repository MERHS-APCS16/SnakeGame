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
public class FoodBlock extends Block {
        private SnakeWorld world;
    public FoodBlock(int r, int c) {
        location = new Location(r, c);
        color = Color.ORANGE;
        
    }

    public FoodBlock() {
        color = Color.ORANGE;
    }
    
    public FoodBlock(SnakeWorld s){
        world = s;
        color = Color.ORANGE;
    }
    public FoodBlock(Location loc){
        location = loc;
        color = Color.ORANGE;
    }
    
    
    
    public void generateNewLocation(Snake s) {
        //TODO: make sure that the newly generated FoodBlock will not interfere with the Snake's SnakeBlock(s)
        int boardHeight = world.getNumRows();
        int boardLength = world.getNumCols();
        boolean inSnake = false;
        Location prevLoc = location;
        int randR = (int) (Math.random() * boardHeight);
        int randC = (int) (Math.random() * boardLength);
        Location loc = new Location(randR, randC);
        for (int x = 0; x < s.getBlocks().size(); x++) {
            if (s.getBlocks().get(x).getLocation().isEqualTo(loc)) {
                inSnake = true;
            }
        }
        if (inSnake) {
            generateNewLocation(s);
        } else {
            location.setNewLocation(randR, randC);
        }
        world.setToFoodBlock(location);
        //world.setToBlock(prevLoc);

    }
}

