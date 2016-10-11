/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import javax.swing.*;

/**
 *
 * @author John Gibson
 */
public class MyFrame {
    public static void main(String[] args) {
        JFrame frame;
        frame = new JFrame("Self Portrait");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ResizableFaceComponent());
        frame.setVisible(true);
        
        frame.setResizable(true);
        frame.setAlwaysOnTop(true);
    }
}