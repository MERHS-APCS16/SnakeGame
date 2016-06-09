/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author konrad
 */
public class SnakePanel extends JPanel implements KeyListener{

    private SnakeWorld world;
    int height =(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    

    public SnakePanel(SnakeWorld wrd) {
        super();
        world = wrd;
        setPreferredSize(new Dimension(height, width));
        setBackground(Color.GREEN);
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    public void run() {
        while (true) {
            
            world.refresh();
            //slow down the program so animation is visible
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            repaint();//"manually" calls paintComponent
            int numBlocks = world.getSnake().getBlocks().size();
            System.out.println("Num Blocks: " + numBlocks);
            for (int x = 0; x < numBlocks; x++){
                //System.out.println(world.getSnake().getBlocks().get(x).toString());
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Draw(g);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == (KeyEvent.VK_S)) {

            world.getSnake().setDirection(2);
            //System.out.println("Down arrow pressed") ;
        }
        if (e.getKeyCode() == (KeyEvent.VK_W)) {

            world.getSnake().setDirection(4);
            //System.out.println("Down arrow pressed") ;
        }
        if (e.getKeyCode() == (KeyEvent.VK_D)) {

            world.getSnake().setDirection(3);
            //System.out.println("Down arrow pressed") ;
        }
        if (e.getKeyCode() == (KeyEvent.VK_A)) {

            world.getSnake().setDirection(1);
            //System.out.println("Down arrow pressed") ;
        }
        repaint();

    }
    @Override
    public void keyTyped(KeyEvent e) {
        //not used   
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //not used
    }

    public void Draw(Graphics g) {
        for (int r = 0; r < world.getWorld().length; r++) {
            for (int c = 0; c < (world.getWorld())[0].length; c++) {

                if (world.getBlockType(new Location(r, c)).equals("Block")) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor((world.getWorld()[r][c]).color);
                }

                int blockHight = (height) / (world.getWorld().length);
                int blockWidth = (width) / (world.getWorld()[0].length);

                g.fillRect((r * blockWidth), (c * blockHight), blockWidth, blockHight);
            }

        }
    }
}
