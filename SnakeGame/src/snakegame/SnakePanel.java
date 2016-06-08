/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeworld;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author konrad
 */
public class SnakePanel extends JPanel {

    private SnakeWorld world;
    int hight = 1000;
    int width = 1000;

    public SnakePanel(SnakeWorld wrd) {
        super();
        world = wrd;
        setPreferredSize(new Dimension(hight, width));
        setBackground(Color.WHITE);
        setFocusable(true); 
        requestFocus();
    }
    
    public void run(){
        world.refresh();
                //slow down the program so animation is visible
        try {
            Thread.sleep(10);
        }
        catch (Exception e) {
        }
        repaint();//"manually" calls paintComponent
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        //door 1

        }
    
    public void Draw (Graphics g) {   
        for (int r = 0; r < world; r++){
            for (int c = 0; c < world; c++){
                if(world.getGrid [r][c].equals null){
                    g.setColor(Color.WHITE);
                }
                else{
                   g.setColor((world.getGrid [r][c]).getColor ());
                }
                g.setColor(Color.RED);
                g.fillRect(bodyX, bodyY, bodyWidth, bodyHeight);
            }

        }
    }
}