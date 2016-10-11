package gradients;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Displays a color gradient and provides buttons for specifying the gradient type.
 * @author John Gibson
 * @version Mar 30, 2016
 */
public class GradientViewer {
    
    private static Color start = Color.RED;
    private static Color end = Color.ORANGE;
    
    public static void disableStyling(JButton b) {
            b.setFocusPainted(false);
            b.setContentAreaFilled(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gradient Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        start = JColorChooser.showDialog(null, "Starting color", Color.RED);
        end = JColorChooser.showDialog(null, "Ending color", Color.ORANGE);
        
        GradientComponent component = new GradientComponent(start, end);
        
        // buttons for specifying gradient type
        JButton linearButton = new JButton("Linear");
        JButton radialButton = new JButton("Radial");
        JButton solidButton = new JButton("Solid");
        
        // disable swing styling on buttons
        disableStyling(linearButton);
        disableStyling(radialButton);
        disableStyling(solidButton);
        
        // add action listeners to buttons
        ActionListener buttonListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton src = (JButton) e.getSource();
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