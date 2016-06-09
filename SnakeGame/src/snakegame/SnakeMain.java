/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Ledyard
 */
public class SnakeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        JFrame frame = new JFrame();
        SnakeWorld world = new SnakeWorld(100, (100 / height) * width);
        world.init();

        SnakePanel panel = new SnakePanel(world);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        panel.run();
    }

}
