package life;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author John Gibson
 * @version Apr 18, 2016
 */
public class LifeViewer extends JFrame {

    private final LifeComponent life;
    
    /**
     * Creates a new Life world and sets up widgets for controlling and observing it. 
     */
    public LifeViewer(int size) {
        life = new LifeComponent(size);
        life.setBorder(new EtchedBorder());
        init();
        
        JMenuBar mBar = new JMenuBar();
        setJMenuBar(mBar);
        mBar.add(getMenu());
    }
    
    /**
     * Sets up control panels and menu bar.
     */
    private void init() {
        add(life, BorderLayout.CENTER);
        add(updateLifePanel(), BorderLayout.NORTH);
        add(randomizingPanel(), BorderLayout.SOUTH);
        add(speedPanel(), BorderLayout.EAST);
    }
    
    /**
     * Returns a panel with widgets for randomizing the world. 
     */
    private JPanel randomizingPanel() {
        // top-level panel with (1) a nested panel with a button and (2) a slider, and (3)
        // a label.
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Randomize Population"));
        
        // add button to top-level panel
        JPanel innerPanel = new JPanel();
        JButton button = new JButton("Populate");
        innerPanel.add(button);
        
        // add slider and label to top-level panel
        JSlider slider = new JSlider(0, 1000);
        JLabel label = new JLabel("Probability of life: " + getPosition(slider) + "%");
        
        panel.add(innerPanel);
        panel.add(slider);
        panel.add(label);
        
        // When slider changes, update label
        slider.addChangeListener(ce -> {
            label.setText("Probability of life: " + getPosition(slider) + "%");
        });
        
        button.addActionListener((ae) -> {
            life.randomize(getPosition(slider) / 100.0);
        });
        
        return panel;
    }
    
    /**
     * Returns a panel with radio buttons for controlling update speed. 
     */
    private JPanel speedPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Speed"));
        panel.setLayout(new GridLayout(4, 1));
        
        final JRadioButton slowButton = new JRadioButton("Slow");
        final JRadioButton mediumButton = new JRadioButton("Medium");
        final JRadioButton fastButton = new JRadioButton("Fast");
        mediumButton.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(slowButton);
        group.add(mediumButton);
        group.add(fastButton);
        
        JSlider speedSlider = new JSlider(0, 500, 200);
        speedSlider.addChangeListener(ce -> life.setDelay(speedSlider.getValue()));
        
        panel.add(slowButton);
        panel.add(mediumButton);
        panel.add(fastButton);
        panel.add(speedSlider);
        
        slowButton.addActionListener(e -> life.setDelay(LifeComponent.SLOW));
        mediumButton.addActionListener(e -> life.setDelay(LifeComponent.MEDIUM));
        fastButton.addActionListener(e -> life.setDelay(LifeComponent.FAST));
        
        return panel;
    }
    
    /**
     * The position of the slider expressed as an integer percentage. 
     */
    private int getPosition(JSlider slider) {
        int val = slider.getValue();
        int max = slider.getMaximum();
        float prob = (float) val / max;
        return (int) (100 * prob);
    }
    
    private JPanel updateLifePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(7, 0, 7, 0));
        final JButton stepButton = new JButton("Step");
        final JButton runButton = new JButton("Run");
        final JButton stopButton = new JButton("Stop");
        final JButton clearButton = new JButton("Clear");
        panel.add(stepButton);
        panel.add(runButton);
        panel.add(stopButton);
        panel.add(clearButton);
        
        stepButton.addActionListener((ActionEvent e) -> life.step());
        stopButton.addActionListener((ActionEvent e) -> life.stop());
        runButton.addActionListener((ActionEvent e) -> life.run());
        clearButton.addActionListener((ActionEvent e) -> life.clear());
        
        return panel;
    }
    
    /**
     * Returns a dropdown menu. 
     */
    private JMenu getMenu() {
        JMenu menu = new JMenu("Eden");
        JMenuItem[] items = {
            new JMenuItem("Glider"),
            new JMenuItem("Exploder"),
            new JMenuItem("Tumbler")
        };
        for (JMenuItem menuItem : items) {
            menu.add(menuItem);
        }
        
        items[0].addActionListener((ActionEvent e) -> { // glider
            life.clear();
            int x1 = 2;
            int y1 = 2;
            life.toggle(x1, y1);
            life.toggle(x1 + 1, y1 + 1);
            life.toggle(x1 + 2, y1 - 1);
            life.toggle(x1 + 2, y1);
            life.toggle(x1 + 2, y1 + 1);            
        });
        
        ActionListener listener = (ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Not supported yet.");            
        };
        items[1].addActionListener(listener);
        items[2].addActionListener(listener);
        
        return menu;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LifeViewer viewer = new LifeViewer(50);
        viewer.setTitle("GameOfLife");
        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewer.setSize(700, 703);
        viewer.setVisible(true);
        viewer.setLocationRelativeTo(null);
    }

}