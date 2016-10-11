package mccree;

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
public class McCree {
    
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
        
        // load image of McCree as ImageIcon
        ImageIcon mccree = new ImageIcon(McCree.class.getResource("/media/Mccree.png"));
        
        // convert imageicon to image
        Image im = mccree.getImage();
        
        Random rand = new Random();
        boolean done = false;
        
        class WindowListener implements ActionListener {            
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (windowCount < Integer.MAX_VALUE) {
                    int n = rand.nextInt(6);
                    int windowSize = rand.nextInt(400) + 200;
                    JFrame frame = new JFrame("IT'S HIGH NOON");
                    Image image = im.getScaledInstance(windowSize, windowSize, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon icon2 = new ImageIcon(image);
                    JLabel label = new JLabel(icon2);
                    frame.add(label);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    int x = rand.nextInt(d.width - frame.getWidth());
                    int y = rand.nextInt(d.height - frame.getHeight());
                    frame.setLocation(x, y);
                    frame.setVisible(true);
                    windowCount++;
                }
            }
        }
        
        class MusicListener implements ActionListener {
            
            int musicCount = 0;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (musicCount < 10) {
                    // create a separate thread that plays friendsmidi.mp3
                    String musicpath = McCree.class.getResource("/media/4640.mp3").toString();
                    Media media = new Media(musicpath);
                    MediaPlayer mp = new MediaPlayer(media);
                    mp.play();
                    musicCount++;
                }
            }
        }
        
        WindowListener wListener = new WindowListener();
        MusicListener mListener = new MusicListener();
        Timer wTimer = new Timer(0, wListener);
        Timer mTimer = new Timer(0, mListener);
        wTimer.start();
        mTimer.start();
    }
}