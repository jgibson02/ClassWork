package mccree;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

/**
 * Creates...something
 *
 * @author John Gibson and Daniel Kilgallon
 */
public class Fubar {

    private static JFXPanel fxPanel;
    public static int windowCount = 0;
    private static volatile int TIMERTIME = 2000;

    public Fubar() {
        // initalize JFXPanel so JFX works
        fxPanel = new JFXPanel();
    }

    public static void main(String[] args) {
        //checks to make sure you REALLY want to continue
        Fubar f = new Fubar();

        // acquire screen resolution
        Toolkit tk = Toolkit.getDefaultToolkit();
        final Dimension d = tk.getScreenSize();

        final ImageIcon foo = new ImageIcon(Fubar.class.getResource("media"
                + File.separator + "Mercy.png"));
        final Image fooImg = foo.getImage();

        final Random rand = new Random();

        class WindowListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (windowCount < 10000) {
                    int windowSize = rand.nextInt(400) + 200;
                    //Creates frame with an image called QUOKKA
                    JFrame frame = new JFrame("IT'S HIGH NOON");
                    Image im = fooImg.getScaledInstance(windowSize, windowSize,
                            java.awt.Image.SCALE_SMOOTH);
                    ImageIcon icon2 = new ImageIcon(im);
                    JLabel label = new JLabel(icon2);
                    frame.add(label);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    int x = rand.nextInt(d.width - frame.getWidth());
                    int y = rand.nextInt(d.height - frame.getHeight());
                    frame.setLocation(x, y);
                    frame.setVisible(true);
                    windowCount++;
                    
                    // create a separate thread that plays friendsmidi.mp3
                    String musicpath = McCree.class.getResource("/media/Hsn.mp3").toString();
                    Media media = new Media(musicpath);
                    MediaPlayer mp = new MediaPlayer(media);
                    mp.play();
                    Timer temp = (Timer) e.getSource();
                    temp.setDelay(TIMERTIME);
                    TIMERTIME = TIMERTIME - 100;
                    if (TIMERTIME <= 0) {
                        TIMERTIME = 0;
                    }
                }
            }
        }
        
        WindowListener wListener = new WindowListener();
        Timer wTimer = new Timer(TIMERTIME, wListener);
        wTimer.start();
    }
}
