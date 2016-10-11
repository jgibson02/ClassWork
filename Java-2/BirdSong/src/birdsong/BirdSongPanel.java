package birdsong;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 * Displays a bird selected from a list and plays the song of that bird on the click of a button.
 * Demonstrates how to package resources in a JAR file.
 *
 * @author Drue Coles
 */
public class BirdSongPanel extends JPanel {

    private final String[] birds = {
        "Western Meadowlark",
        "Northern Cardinal",
        "White Throated Sparrow",
        "Wood Thrush",
        "Canyon Wren"
    };

    private final ImageIcon[] birdImage = new ImageIcon[birds.length];
    private final Clip[] birdSongClip = new Clip[birds.length];

    public BirdSongPanel()  {

        // load bird images        
        for (int i = 0; i < birdImage.length; i++) {
            String imagePath = "images/"  + birds[i].toLowerCase().replace(" ", "_") + ".jpg";
            InputStream stream = getClass().getResourceAsStream(imagePath);
            try {
                birdImage[i] = new ImageIcon(ImageIO.read(stream));
            } catch (IOException ex) {
                Logger.getLogger(BirdSongPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // load audio clips of bird songs
        for (int i = 0; i < birdSongClip.length; i++) {
            String fileName = "audio/" + birds[i].toLowerCase().replace(" ", "_") + ".wav";
            InputStream stream = getClass().getResourceAsStream(fileName);
            BufferedInputStream bin = new BufferedInputStream(stream);
            try {                
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(bin);
                AudioFormat format = audioStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                birdSongClip[i] = (Clip) AudioSystem.getLine(info);
                birdSongClip[i].loop(1);
                birdSongClip[i].open(audioStream);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
                System.exit(0);
            }
        }

        // Set up the GUI
        final JLabel label = new JLabel(); // holds image of selected bird
        label.setBorder(new MatteBorder(3, 3, 3, 3, Color.DARK_GRAY));
        label.setIcon(birdImage[0]);
        final JComboBox birdList = new JComboBox(birds); // to select a bird
        JButton button = new JButton("Play"); // to play a clip of selected bird's song
        add(label);
        add(birdList);
        add(button);

        // after selecting a new bird, update the image and stop the currently playing clip
        birdList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = birdList.getSelectedIndex();
                label.setIcon(birdImage[i]);
            }
        });       

        // after clicking button, play clip of selected bird's song
        button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                for (int j = 0; j < 5; j++) { // first stop currently playing clip
                    birdSongClip[j].stop();
                }
                int i = birdList.getSelectedIndex();
                birdSongClip[i].start();
            } catch (Exception ex) {
                Logger.getLogger(BirdSongPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
           } 
        });
    }

    public static void main(String[] args)  {
        JFrame frame = new JFrame("Bird Song");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BirdSongPanel());
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }
}
