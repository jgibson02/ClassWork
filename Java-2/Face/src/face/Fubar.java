package face;

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

    private static MediaPlayer mp;
    private static JFXPanel fxPanel;
    public static int windowCount = 0;

    public Fubar() {
        // initalize JFXPanel so JFX works
        fxPanel = new JFXPanel();
        //starts playing bar2.mp3
        mp = new MediaPlayer(new Media(this.getClass().getResource("audio"
                + File.separator + "bar2.mp3").toString()));
        mp.play();
    }

    public static void main(String[] args) {
        //checks to make sure you REALLY want to continue
        int n = 1;
        n = JOptionPane.showConfirmDialog(null, "This will spam your computer! "
                + "Stop the program now if you don't \nwant 100 popups of Quokkas. "
                + "You have been warned.", "DR. COLES DON'T PUSH THIS.", JOptionPane.ERROR_MESSAGE);
        if (!(Math.abs(n) == 1)) {
            Fubar f = new Fubar();

            // acquire screen resolution
            Toolkit tk = Toolkit.getDefaultToolkit();
            final Dimension d = tk.getScreenSize();

            final ImageIcon foo = new ImageIcon(Fubar.class.getResource("images"
                    + File.separator + "fubar.jpg"));
            final Image fooImg = foo.getImage();

            final ImageIcon bar = new ImageIcon(Fubar.class.getResource("images"
                    + File.separator + "bar.gif"));

            final Random rand = new Random();

            JFrame barFrame = new JFrame("GANDALF");
            barFrame.setSize(700, 350);
            barFrame.setAlwaysOnTop(true);
            JLabel barLabel = new JLabel(bar);
            barFrame.add(barLabel);
            barFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            barFrame.pack();
            barFrame.setLocationRelativeTo(null);
            barFrame.setVisible(true);
            barFrame.setAlwaysOnTop(true);
            windowCount++;

            class WindowListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (windowCount < 100) {
                        int windowSize = rand.nextInt(400) + 200;
                        //Creates frame with an image called QUOKKA
                        JFrame frame = new JFrame("QUOKKA");
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
                    }
                }
            }
            WindowListener wListener = new WindowListener();
            Timer wTimer = new Timer(0, wListener);
            wTimer.start();
        }
    }
}
