package exam3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author John Gibson
 * @version Apr 13, 2016
 */
public class TwoColorChooser extends JFrame {
    private static final int SLIDER_PATCH_SIZE = 25;
    private static final int COLOR_PATCH_SIZE = 100;
    private Patch activePatch;
    
    public TwoColorChooser() {
        Patch rPatch = new Patch(SLIDER_PATCH_SIZE, Color.RED);
        Patch gPatch = new Patch(SLIDER_PATCH_SIZE, Color.GREEN);
        Patch bPatch = new Patch(SLIDER_PATCH_SIZE, Color.BLUE);
        Patch color1 = new Patch(COLOR_PATCH_SIZE, Color.CYAN);
        Patch color2 = new Patch(COLOR_PATCH_SIZE, Color.MAGENTA);
        JSlider rSlider = new JSlider(0, 255, color1.getColor().getRed());
        JSlider gSlider = new JSlider(0, 255, color1.getColor().getGreen());
        JSlider bSlider = new JSlider(0, 255, color1.getColor().getBlue());
        JRadioButton c1Button = new JRadioButton("Color 1");
        JRadioButton c2Button = new JRadioButton("Color 2");
        JButton okButton = new JButton("OK");
        
        
        activePatch = color1;
        setTitle("Two Color Chooser");
        setLayout(new FlowLayout());
        
        // listeners
            // sliders
            class sliderListener implements ChangeListener {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (e.getSource() == rSlider) {
                        activePatch.setColor(rSlider.getValue(), gSlider.getValue(), bSlider.getValue());
                    }
                    if (e.getSource() == gSlider) {
                        activePatch.setColor(rSlider.getValue(), gSlider.getValue(), bSlider.getValue());
                    }
                    if (e.getSource() == bSlider) {
                        activePatch.setColor(rSlider.getValue(), gSlider.getValue(), bSlider.getValue());
                    }
                }
            }
            rSlider.addChangeListener(new sliderListener());
            gSlider.addChangeListener(new sliderListener());
            bSlider.addChangeListener(new sliderListener());
            
            // radio buttons
            c1Button.addActionListener((ActionEvent e) -> {
                activePatch = color1;
                c2Button.setSelected(false);
                Color c1 = color1.getColor();
                rSlider.setValue(c1.getRed());
                gSlider.setValue(c1.getGreen());
                bSlider.setValue(c1.getBlue());
        });
            c2Button.addActionListener((ActionEvent e) -> {
                activePatch = color2;
                c1Button.setSelected(false);
                Color c2 = color2.getColor();
                rSlider.setValue(c2.getRed());
                gSlider.setValue(c2.getGreen());
                bSlider.setValue(c2.getBlue());
        });
            
            // OK button
            okButton.addActionListener((ActionEvent e) -> {
                dispose();
        });
        
        JPanel sliderPanel = new JPanel();
            sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));
            JPanel rSliderPanel = new JPanel();
                rSliderPanel.setLayout(new FlowLayout());
                rSliderPanel.add(rSlider);
                rSliderPanel.add(rPatch);
            JPanel gSliderPanel = new JPanel();
                rSliderPanel.setLayout(new FlowLayout());
                gSliderPanel.add(gSlider);
                gSliderPanel.add(gPatch);
            JPanel bSliderPanel = new JPanel();
                rSliderPanel.setLayout(new FlowLayout());
                bSliderPanel.add(bSlider);
                bSliderPanel.add(bPatch);
        sliderPanel.add(rSliderPanel);
        sliderPanel.add(gSliderPanel);
        sliderPanel.add(bSliderPanel);
        add(sliderPanel);
            
        add(color1, BorderLayout.CENTER);
        add(color2, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(c1Button, BorderLayout.NORTH);
        buttonPanel.add(c2Button, BorderLayout.CENTER);
        buttonPanel.add(okButton, BorderLayout.SOUTH);
        c1Button.setSelected(true);
        add(buttonPanel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        TwoColorChooser twc = new TwoColorChooser();
    }
}