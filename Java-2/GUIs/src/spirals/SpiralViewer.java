package spirals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;

/**
 * Displays a spiral and provides a slider to control its radius.
 *
 * @todo Add a checkbox at the top of the GUI to toggle the spiral type between normal and nautilus
 * shell. Add a timer to animate the spiral and enable the slider to control the speed. Add another
 * slider to control the length of line segments used to render the spiral, making the curve appear
 * more or less smooth.
 *
 * @author Drue Coles
 */
public class SpiralViewer {
    
    private static int animationTime;
    private static Timer t;
    private static boolean increasing = true;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Everyone Loves Spirals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);

        // create spiral and place in center of frame
        final int INIT_RADIUS = 10;
        final SpiralComponent spiral = new SpiralComponent(INIT_RADIUS);
        frame.add(spiral, BorderLayout.CENTER);

        // slider for controling radius
        JSlider sizeSlider = new JSlider(1, 50, INIT_RADIUS);
        sizeSlider.setBackground(spiral.BG_COLOR);
        sizeSlider.setToolTipText("change the radius");
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
        sizeSlider.addChangeListener((ChangeEvent e) -> {
            spiral.setRadius(sizeSlider.getValue());
        });
        
        // slider for controling animation timing
        JSlider timerSlider = new JSlider(5, 150, 20);
        timerSlider.setBackground(spiral.BG_COLOR);
        timerSlider.addChangeListener((ChangeEvent e) -> {
            boolean wasRunning = t.isRunning();
            if (wasRunning) {
                t.stop();
            }
            t.setDelay(timerSlider.getValue());
            if (wasRunning) {
                t.start();
            }
        });
        timerSlider.setOrientation(JSlider.VERTICAL);
        timerSlider.setToolTipText("change the timing delay");
        timerSlider.setMajorTickSpacing(10);
        timerSlider.setPaintTicks(true);
        timerSlider.setPaintLabels(true);
        
        // add animation effect
        t = new Timer(timerSlider.getValue(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                final int MAX_RADIUS = 50;
                final int MIN_RADIUS = 5;
                int radius = spiral.getRadius();
                if (increasing) {
                    if (radius == MAX_RADIUS - 1) {
                        increasing = false;
                    }
                    spiral.setRadius(radius + 1);
                } else if (!increasing) {
                    if (radius == MIN_RADIUS + 1){
                        increasing = true;
                    }
                    spiral.setRadius(radius - 1);
                }
            }
        });
        
        // add click listener to frame to start animation
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (t.isRunning()) {
                    t.stop();
                    sizeSlider.setEnabled(true);
                } else {
                    t.start();
                    sizeSlider.setEnabled(false);
                }
            }
        });
        
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    frame.dispose();
                }
            }
        });
        
        // checkbox for toggling Nautilus shell
        JCheckBox nautilusBox = new JCheckBox("Toggle Nautilus Shell");
        nautilusBox.setBackground(spiral.BG_COLOR);
        nautilusBox.setSelected(false);
        nautilusBox.addActionListener((ActionEvent ae) -> {
            spiral.setNautilusShell(nautilusBox.isSelected());
        });

        // label associated with slider
        JLabel label = new JLabel("radius");
        label.setForeground(Color.PINK);

        // control panel containing slider and label
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(spiral.BG_COLOR);
        controlPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        controlPanel.add(sizeSlider);
        controlPanel.add(label);
        controlPanel.add(nautilusBox);
        frame.add(timerSlider, BorderLayout.EAST);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        
    }
}

