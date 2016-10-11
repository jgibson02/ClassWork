package gradients;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Displays a color gradient and provides buttons for specifying the gradient type.
 * @author John Gibson
 * @version Mar 30, 2016
 */
public class GradientViewerCustom {
    
    private static Color start = Color.RED;
    private static Color end = Color.ORANGE;
    private static final JFrame frame = new JFrame("Gradient Viewer");
    
    public static void disableStyling(JButton b) {
            b.setFocusPainted(false);
            b.setContentAreaFilled(false);
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        
        start = JColorChooser.showDialog(null, "Starting color", Color.RED);
        end = JColorChooser.showDialog(null, "Ending color", Color.ORANGE);
        
        GradientComponent component = new GradientComponent(start, end);
        component.setBorder(new EtchedBorder());
        
        // buttons for specifying gradient type
        ButtonGroup bGroup = new ButtonGroup();
        JRadioButton linearButton = new JRadioButton("Linear");
        JRadioButton radialButton = new JRadioButton("Radial");
        JRadioButton solidButton = new JRadioButton("Solid");
        bGroup.add(linearButton);
        bGroup.add(radialButton);
        bGroup.add(solidButton);
        linearButton.setSelected(true);
        
        /*// disable swing styling on buttons
        disableStyling(linearButton);
        disableStyling(radialButton);
        disableStyling(solidButton); */
        
        // add action listeners to buttons
        ActionListener buttonListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton src = (JRadioButton) e.getSource();
                if (src == linearButton) {
                    component.setLinearGradient();
                }
                if (src == radialButton) {
                    component.setRadialGradient();
                }
                if (src == solidButton) {
                    component.setNoGradient();
                }
            }
            
        };
        
        linearButton.addActionListener(buttonListener);
        radialButton.addActionListener(buttonListener);
        solidButton.addActionListener(buttonListener);
        
        // a panel with two sliders for controlling color distributions
        JPanel sliderPanel = new JPanel();
        TitledBorder border = new TitledBorder(new EtchedBorder(), "Color Distributions");
        sliderPanel.setBorder(border);
        JSlider slider1 = new JSlider(0, 100, (int) component.getFraction1());
        JSlider slider2 = new JSlider(0, 100, (int) component.getFraction2());
        ChangeListener sliderListener = (ChangeEvent e) -> {
            // first fraction indicates how far along the gradient the starting color
            // should appear
            float first = (float) slider1.getValue()/slider1.getMaximum();
            
            // second fraction indicates how far along the remaining space the ending
            // color appears
            float remaining = 1.0f - first;
            float frac = (float) slider2.getValue() / slider2.getMaximum();
            float second = first + frac * remaining;
            
            if (first < second) {
                component.setDistributionFractions(first, second);
            }
            frame.setVisible(true);
        };
        slider1.addChangeListener(sliderListener);
        slider2.addChangeListener(sliderListener);
        sliderPanel.add(slider1);
        sliderPanel.add(slider2);
        frame.add(sliderPanel, BorderLayout.SOUTH);
        
        // add menu to JFrame
        JMenuBar menuBar = new JMenuBar();
        JMenu colorMenu = new JMenu("Colors");
        JMenuItem swapColors = new JMenuItem("Swap Colors");
        JMenuItem invertColors = new JMenuItem("Invert Colors");
        swapColors.addActionListener((ActionEvent e) -> {
            component.swapColors();
        });
        invertColors.addActionListener((ActionEvent e) -> {
            component.invertColors();
        });
        colorMenu.add(invertColors);
        menuBar.add(swapColors);
        menuBar.add(invertColors);
        frame.setJMenuBar(menuBar);
        
        // put buttons in a container with a border
        JPanel panel = new JPanel();
        
        EtchedBorder eBorder = new EtchedBorder();
        TitledBorder tBorder = new TitledBorder(eBorder, "Gradient Type");
        panel.setBorder(tBorder);
        panel.add(linearButton);
        panel.add(radialButton);
        panel.add(solidButton);
        
        frame.add(panel, BorderLayout.NORTH);
        frame.add(component, BorderLayout.CENTER);
        
        frame.setVisible(true);
        
        frame.repaint();
    }

}