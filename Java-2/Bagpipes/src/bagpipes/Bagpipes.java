package bagpipes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author John Gibson
 */
public class Bagpipes {

    static int instances = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFXPanel panel = new JFXPanel();

        class MusicListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (instances < 999) {
                    String musicpath = Bagpipes.class.getResource("bagpipes.mp3").toString();
                    Media media = new Media(musicpath);
                    MediaPlayer mp = new MediaPlayer(media);
                    mp.play();
                }
                instances++;
            }

        }
        Timer t = new Timer(750, new MusicListener());
        t.start();

    }

}
