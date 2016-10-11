package face;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/*
 * Stores values of each body part of a Mii in classes that extend their
 * respective shapes.
 
 * @author John Gibson, Daniel Kilgallon
 */
public class Mii extends JComponent {

    private final MiiHead miiHead;
    private final MiiBody miiBody;
    private final MiiLeftArm miiLeftArm;
    private final MiiRightArm miiRightArm;
    private final MiiLeftHand miiLeftHand;
    private final MiiRightHand miiRightHand;
    private final MiiWaist miiWaist;
    private final MiiLeftLeg miiLeftLeg;
    private final MiiRightLeg miiRightLeg;
    private final MiiLeftFoot miiLeftFoot;
    private final MiiRightFoot miiRightFoot;

    private static int miiFrameWidth;
    private static int miiFrameHeight;
    private static int miiHeight;

    private Color favoriteColor;
    private static final Color BOTTOM_COLOR = Color.GRAY;

    private ImageIcon miiEye;
    private ImageIcon miiEyebrow;
    private ImageIcon miiNose;
    private ImageIcon miiMouth;
    private ImageIcon miiHair;

    private int miiEyeOffsetY = 65;
    private int miiEyebrowOffsetY = 50;
    private int miiNoseOffsetY = 95;
    private int miiMouthOffsetY = 145;

    private int miiEyeOffsetX = 0;
    private int miiEyebrowOffsetX = 0;
    private int miiNoseOffsetX = -105;
    private int miiMouthOffsetX = -100;

    private static final int BODY_OFFSET = 150;
    private static final int START_ARM_OFFSET_Y = 263;
    private static final int END_ARM_OFFSET_Y = 375;
    private static final int START_LEG_OFFSET_Y = 590;
    private static final int END_LEG_OFFSET_Y = 680;

    /**
     * Sets default values to each of the mii's components.
     * 
     * @param miiFaceImages standard face to set each component too
     */
    public Mii(ImageIcon[] miiFaceImages) {
        miiHeight = 150;
        miiEye = miiFaceImages[0];
        miiEyebrow = miiFaceImages[1];
        miiNose = miiFaceImages[2];
        miiMouth = miiFaceImages[3];
        miiHair = miiFaceImages[4];

        //we use constants just for easier placement of mii components
        miiFrameWidth = 850;
        miiFrameHeight = 950;
        miiHead = new MiiHead();
        miiBody = new MiiBody();
        miiLeftArm = new MiiLeftArm();
        miiRightArm = new MiiRightArm();
        miiLeftHand = new MiiLeftHand();
        miiRightHand = new MiiRightHand();
        miiWaist = new MiiWaist();
        miiLeftLeg = new MiiLeftLeg();
        miiRightLeg = new MiiRightLeg();
        miiLeftFoot = new MiiLeftFoot();
        miiRightFoot = new MiiRightFoot();
        favoriteColor = Color.RED;
        //calls each method once to position everything to the same size
        setWeight(100);
        setHeight(150);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));

        GradientPaint gp = new GradientPaint(miiFrameWidth / 2, 0, new Color(108, 196, 255), miiFrameWidth / 2, miiFrameHeight, new Color(218, 254, 244));

        //paints the background
        g2.setPaint(gp);
        g2.fillRect(0, 0, miiFrameWidth, miiFrameHeight);

        //body
        g2.setColor(favoriteColor);
        g2.fill(miiBody);

        //cuts the bottom of the body off with a 'clear' rectangle
        g2.setPaint(gp);
        g2.fillRect(miiFrameWidth / 2 - 250, miiFrameHeight / 2 - 25, 300, 300);

        //arms
        g2.setStroke(new BasicStroke(miiLeftArm.getStrokeSize()));
        g2.setColor(favoriteColor);
        g2.draw(miiLeftArm);

        g2.setStroke(new BasicStroke(miiRightArm.getStrokeSize()));
        g2.draw(miiRightArm);

        //hands
        g2.fill(miiLeftHand);

        g2.fill(miiRightHand);

        //waist
        g2.setColor(BOTTOM_COLOR);
        g2.fill(miiWaist);

        //legs
        g2.setStroke(new BasicStroke(miiLeftLeg.getStrokeSize()));
        g2.draw(miiLeftLeg);

        g2.setStroke(new BasicStroke(miiRightLeg.getStrokeSize()));
        g2.draw(miiRightLeg);

        //feet
        g2.fill(miiLeftFoot);

        g2.fill(miiRightFoot);

        //head
        g2.setColor(miiHead.skinColor);
        g2.fill(miiHead);

        g2.drawImage(miiHair.getImage(), 241, miiHeight - 25,
                miiHair.getIconWidth(), miiHair.getIconHeight(), null);

        g2.drawImage(miiEyebrow.getImage(), 340 - miiEyebrowOffsetX, miiHeight + miiEyebrowOffsetY,
                miiEyebrow.getIconWidth(), miiEyebrow.getIconHeight(), null);
        g2.drawImage(miiEyebrow.getImage(), 305 + miiEyebrowOffsetX, miiHeight + miiEyebrowOffsetY,
                -miiEyebrow.getIconWidth(), miiEyebrow.getIconHeight(), null);

        g2.drawImage(miiEye.getImage(), 340 - miiEyeOffsetX, miiHeight + miiEyeOffsetY,
                miiEye.getIconWidth(), miiEye.getIconHeight(), null);
        g2.drawImage(miiEye.getImage(), 305 + miiEyeOffsetX, miiHeight + miiEyeOffsetY,
                -miiEye.getIconWidth(), miiEye.getIconHeight(), null);

        g2.drawImage(miiNose.getImage(), (int) ((miiFrameWidth / 2) - (miiNose.getIconWidth() / 2)) + miiNoseOffsetX, miiHeight + miiNoseOffsetY,
                miiNose.getIconWidth(), miiNose.getIconHeight(), null);

        g2.drawImage(miiMouth.getImage(), (int) ((miiFrameWidth / 2) - (miiMouth.getIconWidth() / 2)) + miiMouthOffsetX, miiHeight + miiMouthOffsetY,
                miiMouth.getIconWidth(), miiMouth.getIconHeight(), null);
    }

    private class MiiHead extends Ellipse2D.Double {

        private Color skinColor;

        public MiiHead() {
            super(243, 130, 160, 180);
            skinColor = new Color(223, 197, 190);
        }

        public void setHeight(int height) {
            setFrame(x, height, width, this.height);
            repaint();
        }
    }

    private class MiiBody extends Ellipse2D.Double {

        public MiiBody() {
            super(425, 280, 100, 230);
        }

        public void setWeight(int weight) {
            x = (miiFrameWidth / 2) - (weight / 2) - 100;
            setFrame(x, y, weight, height);
            repaint();
        }

        public void setHeight(int height) {
            setFrame(x, height + BODY_OFFSET, width, this.height);
        }
    }

    private class MiiLeftArm extends Line2D.Double {

        private int weight;

        public MiiLeftArm() {
            super(449, 348, 382, 440);
        }

        public void setWeight(int weight) {
            this.weight = weight;
            x1 = miiFrameWidth / 2 - (weight / 2) - 60;
            x2 = miiFrameWidth / 2 - (weight / 2) - 145;
            setLine(x1, y1, x2, y2);
        }

        public void setHeight(int height) {
            y1 = miiFrameHeight / 2 - (miiFrameHeight - height) / 2;
            y2 = miiFrameHeight / 2 - (miiFrameHeight - height) / 2;
            setLine(x1, y1 + START_ARM_OFFSET_Y, x2, y2 + END_ARM_OFFSET_Y);
        }

        public int getStrokeSize() {
            return (int) (weight / 4.34);
        }
    }

    private class MiiRightArm extends Line2D.Double {

        private int weight;

        public MiiRightArm() {
            super(502, 328, 568, 440);
        }

        public void setWeight(int weight) {
            this.weight = weight;
            x1 = miiFrameWidth / 2 + (weight / 2) - 140;
            x2 = miiFrameWidth / 2 + (weight / 2) - 55;
            setLine(x1, y1, x2, y2);
        }

        public void setHeight(int height) {
            y1 = miiFrameHeight / 2 - (miiFrameHeight - height) / 2;
            y2 = miiFrameHeight / 2 - (miiFrameHeight - height) / 2;
            setLine(x1, y1 + START_ARM_OFFSET_Y, x2, y2 + END_ARM_OFFSET_Y);
        }

        public int getStrokeSize() {
            return (int) (weight / 4.34);
        }
    }

    private class MiiLeftHand extends Ellipse2D.Double {

        private int size;

        public MiiLeftHand() {
            super(miiLeftArm.getX2(), miiLeftArm.getY2(), 47, 47);
        }

        public void setWeight(int weight) {
            this.size = weight / 2;
            setFrame(miiLeftArm.getX2() - (size / 2), miiLeftArm.getY2() - (size / 2), size, size);
            repaint();
        }

        public void setHeight(int height) {
            setFrame(miiLeftArm.getX2() - (size / 2), miiLeftArm.getY2() - (size / 2), size, size);
            repaint();
        }
    }

    private class MiiRightHand extends Ellipse2D.Double {

        private int size;

        public MiiRightHand() {
            super(miiRightArm.getX2(), miiRightArm.getY2(), 47, 47);
        }

        public void setWeight(int weight) {
            this.size = weight / 2;
            setFrame(miiRightArm.getX2() - (size / 2), miiRightArm.getY2() - (size / 2), size, size);
        }

        public void setHeight(int height) {
            setFrame(miiRightArm.getX2() - (size / 2), miiRightArm.getY2() - (size / 2), size, size);
        }
    }

    private class MiiWaist extends Rectangle {

        public MiiWaist() {
            super(425, 450, 100, 70);
        }

        public void setWeight(int weight) {
            x = (miiFrameWidth / 2) - (weight / 2) - 100;

            setRect(x, y, weight, height);
            repaint();
        }

        public void setHeight(int height) {

        }
    }

    private class MiiLeftLeg extends Line2D.Double {

        private int weight;

        public MiiLeftLeg() {
            super(293, 492, 286, 609);
        }

        public void setWeight(int weight) {
            this.weight = weight;
            repaint();
        }

        public void setHeight(int height) {
            y1 = miiFrameHeight / 2 - (miiFrameHeight + height) / 2;
            y2 = miiFrameHeight / 2 - (miiFrameHeight + height) / 2;
            setLine(x1, y1 + START_LEG_OFFSET_Y, x2, y2 + END_LEG_OFFSET_Y);
        }

        public int getStrokeSize() {
            return (int) (weight / 4.34);
        }
    }

    private class MiiRightLeg extends Line2D.Double {

        private int weight;

        public MiiRightLeg() {
            super(358, 492, 364, 609);
        }

        public void setWeight(int weight) {
            this.weight = weight;
            repaint();
        }

        public void setHeight(int height) {
            y1 = miiFrameHeight / 2 - (miiFrameHeight + height) / 2;
            y2 = miiFrameHeight / 2 - (miiFrameHeight + height) / 2;
            setLine(x1, y1 + START_LEG_OFFSET_Y, x2, y2 + END_LEG_OFFSET_Y);
        }

        public int getStrokeSize() {
            return (int) (weight / 4.34);
        }
    }

    private class MiiLeftFoot extends Ellipse2D.Double {

        private int size;

        public MiiLeftFoot() {
            super(408, 615, 50, 50);
        }

        public void setWeight(int weight) {
            this.size = weight / 2;
            setFrame(miiLeftLeg.getX2() - (size / 2), miiLeftLeg.getY2() - (size / 2), size, size);
        }

        public void setHeight(int height) {
            setFrame(miiLeftLeg.getX2() - (size / 2), miiLeftLeg.getY2() - (size / 2), size, size);
        }
    }

    private class MiiRightFoot extends Ellipse2D.Double {

        private int size;

        public MiiRightFoot() {
            super(493, 615, 50, 50);
        }

        public void setWeight(int weight) {
            this.size = weight / 2;
            setFrame(miiRightLeg.getX2() - (size / 2), miiRightLeg.getY2() - (size / 2), size, size);
        }

        public void setHeight(int height) {
            setFrame(miiRightLeg.getX2() - (size / 2), miiRightLeg.getY2() - (size / 2), size, size);
        }
    }

    public void setWeight(int weight) {
        miiBody.setWeight(weight);
        miiLeftArm.setWeight(weight);
        miiRightArm.setWeight(weight);
        miiLeftHand.setWeight(weight);
        miiRightHand.setWeight(weight);
        miiWaist.setWeight(weight);
        miiLeftLeg.setWeight(weight);
        miiRightLeg.setWeight(weight);
        miiLeftFoot.setWeight(weight);
        miiRightFoot.setWeight(weight);
    }

    public void setHeight(int height) {
        miiHead.setHeight(height);
        miiBody.setHeight(height);
        miiLeftArm.setHeight(height);
        miiRightArm.setHeight(height);
        miiLeftHand.setHeight(height);
        miiRightHand.setHeight(height);
        miiLeftLeg.setHeight(height);
        miiRightLeg.setHeight(height);
        miiLeftFoot.setHeight(height);
        miiRightFoot.setHeight(height);
        miiHeight = height;
    }

    public void setSkinColor(Color skinColor) {
        miiHead.skinColor = skinColor;
        repaint();
    }

    public void setFavoriteColor(Color favoriteColor) {
        this.favoriteColor = favoriteColor;
        repaint();
    }

    public void setMiiEyes(ImageIcon miiEye) {
        this.miiEye = miiEye;
        repaint();
    }

    public void setMiiEyebrows(ImageIcon miiEyebrow) {
        this.miiEyebrow = miiEyebrow;
        repaint();
    }

    public void setMiiNose(ImageIcon miiNose) {
        this.miiNose = miiNose;
        repaint();
    }

    public void setMiiMouth(ImageIcon miiMouth) {
        this.miiMouth = miiMouth;
        repaint();
    }

    public void setMiiHair(ImageIcon miiHair) {
        this.miiHair = miiHair;
        repaint();
    }

    public void setMiiEyeOffsetY(int miiEyeOffsetY) {
        this.miiEyeOffsetY = miiEyeOffsetY;
        repaint();
    }

    public void setMiiEyebrowOffsetY(int miiEyebrowOffsetY) {
        this.miiEyebrowOffsetY = miiEyebrowOffsetY;
        repaint();
    }

    public void setMiiNoseOffsetY(int miiNoseOffsetY) {
        this.miiNoseOffsetY = miiNoseOffsetY;
        repaint();
    }

    public void setMiiMouthOffsetY(int miiMouthOffsetY) {
        this.miiMouthOffsetY = miiMouthOffsetY;
        repaint();
    }

    public void setMiiEyeOffsetX(int miiEyeOffsetX) {
        this.miiEyeOffsetX = miiEyeOffsetX;
        repaint();
    }

    public void setMiiEyebrowOffsetX(int miiEyebrowOffsetX) {
        this.miiEyebrowOffsetX = miiEyebrowOffsetX;
        repaint();
    }

    public void setMiiNoseOffsetX(int miiNoseOffsetX) {
        this.miiNoseOffsetX = miiNoseOffsetX;
        repaint();
    }

    public void setMiiMouthOffsetX(int miiMouthOffsetX) {
        this.miiMouthOffsetX = miiMouthOffsetX;
        repaint();
    }
}