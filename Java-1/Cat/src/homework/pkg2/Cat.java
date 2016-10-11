package homework.pkg2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * This program draws a variety of shapes and lines to create a cat version of 
 * the Android mascot (Bugdroid)
 * 
* @author John Gibson
 */
public class Cat extends JComponent {
    
    InputStream input;
    Font androidFont;
    
    public static void main(String[] args) {
        JFrame frame;
        frame = new JFrame("Catdroid");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Cat());
        frame.setVisible(true);
        frame.setResizable(true);
    }
    
    
    
    @Override
    public void paintComponent (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        // antialiasing
        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON));
        
        //create dimension variables
        int w = getWidth();
        int h = getHeight();
        
        //translate origin
        g2.translate(w/2, h/2);
        
        //create "Android green" colors
        Color androidGreen = new Color(164, 198, 57);
        Color androidGreenDarker = new Color(138, 165, 48);
        
        //fill background
        Color bgColor = new Color(240, 240, 240);
        g2.setColor(bgColor);
        g2.fill(new Rectangle(-w/2, -h/2, w, h));
        
        //set body measurements
        final int BODY_WIDTH = 256;
        final int BODY_CIRCLE_DIAMETER = 50;
        final int BODY_MOUTH_MARGIN = 10;
        final int HEAD_HEIGHT = 118;
        final int EYE_DIAMETER = 22;
        final int BODY_ARM_MARGIN = 11;
        final int ARM_WIDTH = 57;
        final int LEG_WIDTH = ARM_WIDTH;
        
        //tail
        g2.setColor(androidGreenDarker);
        g2.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        Arc2D.Double tailBeginning = new Arc2D.Double( -150, -40, 140, 100, -20, -145, 
                Arc2D.OPEN);
        Point2D tailBeginningEnd = tailBeginning.getEndPoint();
        Arc2D.Double tailEnding = new Arc2D.Double(tailBeginningEnd.getX() -100, 
                tailBeginningEnd.getY() - 20, 100, 50, 0, 150, Arc2D.OPEN);
        g2.draw(tailBeginning);
        g2.draw(tailEnding);
        
        //ears
        g2.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.fillPolygon(new int[] {-BODY_WIDTH/2 + 30, -BODY_WIDTH/2 + 30, -BODY_WIDTH/2 
                + 120}, new int[] {-200, -260, -200}, 3);
        g2.fillPolygon(new int[] {BODY_WIDTH/2 - 30, BODY_WIDTH/2 - 30, 
            BODY_WIDTH/2 - 120}, new int[] {-200, -260, -200}, 3);
        g2.setColor(androidGreen);
        g2.drawPolygon(new int[] {-BODY_WIDTH/2 + 30, -BODY_WIDTH/2 + 30, 
            -BODY_WIDTH/2 + 120}, new int[] {-200, -260, -200}, 3);
        g2.drawPolygon(new int[] {BODY_WIDTH/2 - 30, BODY_WIDTH/2 - 30, 
            BODY_WIDTH/2 - 120}, new int[] {-200, -260, -200}, 3);
        
        //head
        g2.setColor(androidGreen);
        Ellipse2D.Double head = new Ellipse2D.Double(-BODY_WIDTH/2, -120 - 
                (BODY_MOUTH_MARGIN + HEAD_HEIGHT), BODY_WIDTH, HEAD_HEIGHT * 2);
        g2.fill(head);
        
        //whiskers
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setColor(androidGreenDarker);
        Point2D.Double leftJoint = new Point2D.Double(-30, -160);
        Point2D.Double rightJoint = new Point2D.Double(30, -160);
        Line2D.Double leftTop = new Line2D.Double(new Point2D.Double(-100, -175), 
                leftJoint);
        Line2D.Double leftMiddle = new Line2D.Double(new Point2D.Double(-100, -160), 
                leftJoint);
        Line2D.Double leftBottom = new Line2D.Double(new Point2D.Double(-100, -145), 
                leftJoint);
        Line2D.Double rightTop = new Line2D.Double(new Point2D.Double(100, -175), 
                rightJoint);
        Line2D.Double rightMiddle = new Line2D.Double(new Point2D.Double(100, -160), 
                rightJoint);
        Line2D.Double rightBottom = new Line2D.Double(new Point2D.Double(100, -145), 
                rightJoint); 
        g2.draw(leftTop);
        g2.draw(leftMiddle);
        g2.draw(leftBottom);
        g2.draw(rightTop);
        g2.draw(rightMiddle);
        g2.draw(rightBottom);
        
        //mouth
        Arc2D.Double leftNostril = new Arc2D.Double(-20, -153,20,10,0, -180, Arc2D.OPEN);
        Arc2D.Double rightNostril = new Arc2D.Double(0, -153,20,10,0, -180, Arc2D.OPEN);
        g2.draw(leftNostril);
        g2.draw(rightNostril);
        
        // Nose
        g2.drawPolygon(new int[] {-10, 0, 10}, new int[] {-170, -160, -170}, 3);
        
        // Eyes
        g2.setColor(bgColor);
        Ellipse2D.Double leftEye = new Ellipse2D.Double(-BODY_WIDTH/2 + 70, -210, 
                EYE_DIAMETER, EYE_DIAMETER);
        g2.fill(leftEye);
        
        Ellipse2D.Double rightEye = new Ellipse2D.Double(BODY_WIDTH/2 - 70 - EYE_DIAMETER,
                -210, EYE_DIAMETER, EYE_DIAMETER);
        g2.fill(rightEye);
        
        // Head and body margin
        g2.setColor(bgColor);
        g2.fill(new Rectangle(-BODY_WIDTH/2, -130, BODY_WIDTH, 10));
        
        // Body      
        g2.setColor(androidGreen);
        Rectangle mainBodyRectangle = new Rectangle(-BODY_WIDTH/2, -120, BODY_WIDTH, 186);
        g2.fill(mainBodyRectangle);
        
        Rectangle lowerBodyRectangle = new Rectangle(-BODY_WIDTH/2 + 
                BODY_CIRCLE_DIAMETER/2, 66, BODY_WIDTH - BODY_CIRCLE_DIAMETER, 
                BODY_CIRCLE_DIAMETER/2);
        g2.fill(lowerBodyRectangle);
        
        Ellipse2D.Double bottomLeftBodyCircle = new Ellipse2D.Double(-BODY_WIDTH/2, 
                66 - BODY_CIRCLE_DIAMETER/2, BODY_CIRCLE_DIAMETER, BODY_CIRCLE_DIAMETER);
        g2.fill(bottomLeftBodyCircle);
      
        Ellipse2D.Double bottomRightBodyCircle = new Ellipse2D.Double(BODY_WIDTH/2 - 
                BODY_CIRCLE_DIAMETER, 66 - BODY_CIRCLE_DIAMETER/2, BODY_CIRCLE_DIAMETER, 
                BODY_CIRCLE_DIAMETER);
        g2.fill(bottomRightBodyCircle);
        
        // Left arm
        g2.setColor(androidGreen);
        Ellipse2D.Double leftArmTopCircle = new Ellipse2D.Double(-BODY_WIDTH/2 - 
                BODY_ARM_MARGIN - ARM_WIDTH, -127, ARM_WIDTH, ARM_WIDTH);
        g2.fill(leftArmTopCircle);
        Rectangle leftArmRectangle = new Rectangle(-BODY_WIDTH/2 - BODY_ARM_MARGIN - ARM_WIDTH, -127 + 
                ARM_WIDTH/2, ARM_WIDTH, 120);
        g2.fill(leftArmRectangle);
        Ellipse2D.Double leftArmBottomCircle = new Ellipse2D.Double(-BODY_WIDTH/2 - 
                BODY_ARM_MARGIN - ARM_WIDTH, -7, ARM_WIDTH, ARM_WIDTH);
        g2.fill(leftArmBottomCircle);
        
        // Right arm
        Ellipse2D.Double rightArmTopCircle = new Ellipse2D.Double(BODY_WIDTH/2 + 
                BODY_ARM_MARGIN, -127, ARM_WIDTH, ARM_WIDTH);
        g2.fill(rightArmTopCircle);
        g2.fill(new Rectangle(BODY_WIDTH/2 + BODY_ARM_MARGIN, -127 + ARM_WIDTH/2, 
                ARM_WIDTH, 120));
        Ellipse2D.Double rightArmBottomCircle = new Ellipse2D.Double(BODY_WIDTH/2 + 
                BODY_ARM_MARGIN, -7, ARM_WIDTH, ARM_WIDTH);
        g2.fill(rightArmBottomCircle);
        
        // Left leg
        g2.fill(new Rectangle(-BODY_WIDTH/2 + 50, 66 + BODY_CIRCLE_DIAMETER/2, LEG_WIDTH, 
                66));
        Ellipse2D.Double leftLegCircle = new Ellipse2D.Double(-BODY_WIDTH/2 + 50, 132, 
                LEG_WIDTH, LEG_WIDTH);
        g2.fill(leftLegCircle);
        
        // Right leg
        g2.fill(new Rectangle(BODY_WIDTH/2 - 50 - LEG_WIDTH, 66 + BODY_CIRCLE_DIAMETER/2, 
                LEG_WIDTH, 66));
        Ellipse2D.Double rightLegCircle = new Ellipse2D.Double(BODY_WIDTH/2 - 50 - 
                LEG_WIDTH, 132, LEG_WIDTH, LEG_WIDTH);
        g2.fill(rightLegCircle);
        
        // Text
        g2.setColor(new Color(80, 80, 80));
            //import custom font family
            input = Cat.class.getResourceAsStream("and_black.ttf");
            try {
                androidFont = Font.createFont(Font.TRUETYPE_FONT, input);
            } catch (FontFormatException | IOException ex) {
                Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
            }
        androidFont = androidFont.deriveFont(Font.BOLD, 80);
        g2.setFont(androidFont);
        FontMetrics fontMet = g2.getFontMetrics();
        Rectangle2D r1 = fontMet.getStringBounds("catdroid", g2);
        g2.drawString("catdroid", (int) -r1.getWidth()/2, 285); //centers vertically and 
            //horizontally (-h/2 + ((int) leftLegCircle.getY() - LEG_WIDTH/2))/2)
        
        // Corners
        final int TRIANGLE_SIDE_LENGTH = 100;
        Color blue = new Color(58, 124, 236);
        Color red = new Color(227, 62, 43);
        Color yellow = new Color(241, 181, 0);
        Color green = new Color(43, 161, 75);
        
        g2.setColor(blue);
        g2.fillPolygon(new int[] {-w/2, -w/2 + TRIANGLE_SIDE_LENGTH, -w/2}, new int[] 
        {-h/2, -h/2, -h/2 + TRIANGLE_SIDE_LENGTH}, 3);
        
        g2.setColor(red);
        g2.fillPolygon(new int[] {w/2, w/2 - TRIANGLE_SIDE_LENGTH, w/2}, new int[] 
        {-h/2, -h/2, -h/2 + TRIANGLE_SIDE_LENGTH}, 3);
        
        g2.setColor(yellow);
        g2.fillPolygon(new int[] {-w/2, -w/2 + TRIANGLE_SIDE_LENGTH, -w/2}, new int[] 
        {h/2, h/2, h/2 - TRIANGLE_SIDE_LENGTH}, 3);
        
        g2.setColor(green);
        g2.fillPolygon(new int[] {w/2, w/2 - TRIANGLE_SIDE_LENGTH, w/2}, new int[] 
        {h/2, h/2, h/2 - TRIANGLE_SIDE_LENGTH}, 3);
        /*
        // animated arm
        class TimerListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            AffineTransform t = new AffineTransform();
            t.translate(-BODY_WIDTH/2 - BODY_ARM_MARGIN - ARM_WIDTH, -127 + 
                ARM_WIDTH/2);        
            t.rotate(object.getBody().getAngle());
            g.transform(t);
            g.fillRect((int)-(object.width), (int)-(object.height), (int)(object.width*2), (int)(object.height*2));
            try{
                g.transform(t.createInverse());
            }catch(NoninvertibleTransformException e){
                //...
            }
        }
    }
            */
    }
}