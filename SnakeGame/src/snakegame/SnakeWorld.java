/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;
import java.util.ArrayList;
/**
 *
 * @author Connor Coale User AC
 */
public class SnakeWorld {

    private Block[][] world;
    private Snake snake;
    private int score;
    private FoodBlock food;

    public SnakeWorld(int numRows, int numCols) {
        world = new Block[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                world[row][col] = new Block(row, col);
            }
        }
    }
    public void foodEaten(){
        this.food.generateNewLocation(snake);
    }
    
    public int getNumCols(){
        return world[0].length;
    }
    
    public int getNumRows(){
        return world.length;
    }
    
    public String getBlockType(Location loc){
        if (world[loc.getR()][loc.getC()] instanceof FoodBlock){
            return "FoodBlock";
        } else if (world[loc.getR()][loc.getC()] instanceof SnakeBlock){
            return "SnakeBlock";
        }
        return "Block";
    }
    public void setToBlock(Location loc){
        int r = loc.getR();
        int c = loc.getC();
        world[r][c] = new Block(loc);
    }
    public void setToSnakeBlock(Location loc){
        world[loc.getR()][loc.getC()] = new SnakeBlock(loc);
    }
    public Snake getSnake(){
        return snake;
    }
    
    public void init() {
        int randRow;
        int randCol;
        SnakeBlock s;
        randRow = (int)(Math.random() * world.length);
        randCol = (int)(Math.random() * world[0].length);
        s = new SnakeBlock(randRow, randCol);
        ArrayList<SnakeBlock> list = new ArrayList<>();
        list.add(s);
        int randDirection = (int)(Math.random() * 4 + 1);
        snake = new Snake(list, randDirection, this);
        score = 0;
        food = new FoodBlock(this);
    }
    public void refresh(){
        snake.moveSnake();
    }

}

