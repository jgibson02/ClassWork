package bill;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * This program will be there for you, when the rain starts to pour, like it's been there before, 
 * cause you're there for it too.
 * 
 * @author John Gibson
 */
public class Bill {
    
    public static int windowCount = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // initalize JFXPanel so JFX stuff works
        JFXPanel fxPanel = new JFXPanel();
        
        // acquire screen resolution
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        
        // load images of each cast member as ImageIcons
        ImageIcon b1 = new ImageIcon(Bill.class.getResource("/images/b1.jpg"));
        ImageIcon b2 = new ImageIcon(Bill.class.getResource("/images/b2.jpg"));
        ImageIcon b3 = new ImageIcon(Bill.class.getResource("/images/b3.jpg"));
        ImageIcon b4 = new ImageIcon(Bill.class.getResource("/images/b4.jpg"));
        ImageIcon b5 = new ImageIcon(Bill.class.getResource("/images/b5.jpg"));
        ImageIcon bowtie = new ImageIcon(Bill.class.getResource("/images/bowtie.jpg"));
        
        // assign the images to 6 slots in an array
        Image[] images = new Image[6];
        images[0] = b1.getImage();
        images[1] = b2.getImage();
        images[2] = b3.getImage();
        images[3] = b4.getImage();
        images[4] = b5.getImage();
        images[5] = bowtie.getImage();
        
        Random rand = new Random();
        boolean done = false;
        
        JFrame frame = new JFrame("BILL");
        ImageIcon bill = new ImageIcon(Bill.class.getResource("/images/b.gif"));
        JLabel label = new JLabel(bill);
        frame.add(label);
        frame.setDefaultCloseOperation(2);
        frame.pack();
        int x = rand.nextInt(d.width - frame.getWidth());
        int y = rand.nextInt(d.height - frame.getHeight());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        windowCount++;
        
        class WindowListener implements ActionListener {
            
            
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (windowCount < 300) {
                    int n = rand.nextInt(6);
                    int windowSize = rand.nextInt(400) + 200;
                    JFrame frame = new JFrame("BILL");
                    Image im = images[n].getScaledInstance(windowSize, windowSize, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon icon2 = new ImageIcon(im);
                    JLabel label = new JLabel(icon2);
                    frame.add(label);
                    frame.setDefaultCloseOperation(2);
                    frame.pack();
                    int x = rand.nextInt(d.width - frame.getWidth());
                    int y = rand.nextInt(d.height - frame.getHeight());
                    frame.setLocation(x, y);
                    frame.setVisible(true);
                    windowCount++;
                }
            }
        }
        
        WindowListener wListener = new WindowListener();
        Timer wTimer = new Timer(500, wListener);
        wTimer.start();
        String musicpath = Bill.class.getResource("/music/bill.mp3").toString();
        Media media = new Media(musicpath);
        MediaPlayer mp = new MediaPlayer(media);
        mp.play();
    }
}
