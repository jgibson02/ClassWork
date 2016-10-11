package colorlist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;

/**
 * Contains a panel and displays a list of color names for selecting the background color of the 
 * panel.
 * 
 * @author Drue Coles
 */
public class ColorList extends JFrame {

    private final JList<String> listOfColors;

    private final String[] names = {
        "Dusty Rose", "Firebrick", "Goldenrod", "Midnight Blue", "Orchid", "Papaya Whip", "Quartz",
        "Salmon", "Sea Green", "Siena", "Slate Gray", "Thistle", "Violet", "Wheat",};

    private final Color[] colors = {
        new Color(133, 99, 99), // Dusty Rose
        new Color(178, 34, 34), // Firebrick
        new Color(219, 219, 112), // Goldenrod
        new Color(47, 47, 79), // Midnight Blue
        new Color(218, 112, 214), // Orchid
        new Color(255, 239, 213), // Papaya Whip
        new Color(217, 217, 243), // Quartz
        new Color(250, 128, 114), // Salmon
        new Color(35, 142, 104), // Sea Green
        new Color(160, 82, 45), // Siena
        new Color(112, 128, 144), // Slate Gray
        new Color(216, 191, 216), // Thistle
        new Color(79, 47, 79), // Violet
        new Color(216, 216, 191) // Wheat
    };
    
    private final JPanel panel;
       
    /**
     * Creates list and registers list selection handler.
     */
    public ColorList() {
        super("Color List");
        listOfColors = new JList<>(names);
        listOfColors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        panel = new JPanel();  
        initPanel();         
        
        // select initial background color at random
        Random rand = new Random();
        int k = rand.nextInt(colors.length);
        listOfColors.setSelectedIndex(k);
        updateColors(k);
        
        listOfColors.addListSelectionListener((ListSelectionEvent e) -> {
            updateColors(listOfColors.getSelectedIndex());
        });           
    }
    
    /**
     * Helper method invoked from constructor.
     */
    private void initPanel() {
                  
        panel.add(new JScrollPane(listOfColors));       
        add(panel, BorderLayout.CENTER); 
    }
    
    /**
     * Updates the background of the panel and the color of the matte border. For dark colors, the
     * border will be slightly lighter, and for bright colors it will be slightly darker.
     * 
     * @param i the index of the color to use for the background
     */
    private void updateColors(int i) {
        panel.setBackground(colors[i]);     
        
        // A dark color has sum of RGB components less than 3 * 128 = 384.        
        int sum = colors[i].getRed() + colors[i].getGreen() + colors[i].getBlue();
        Color c = sum < 384 ? colors[i].brighter() : colors[i].darker();
        panel.setBorder(new MatteBorder(10, 10, 10, 10, c));        
    }
    
    public static void main(String[] args) {
        JFrame frame = new ColorList();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }
}

