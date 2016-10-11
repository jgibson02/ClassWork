/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agar;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 *
 * @author John
 */
public class Player extends Rectangle {
    public int size; // the width of the bounding box
    private int posX;
    private int posY;
    private Color color;
    private static Random rand = new Random();
    
    private static final int INIT_SIZE = 25;
    
    public Player() {
        size = INIT_SIZE;
        posX = 0;
        posY = 0;
        color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }
    
    public void kill() {
        
    }
    
    public Ellipse2D.Double getInscribedCircle() {
        int radius = size/2;
        return new Ellipse2D.Double(posX - radius, posY - radius, size, size);
    }
    
}
