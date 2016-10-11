package god;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author John Gibson
 */
public class God extends Application {
    
    final JFXPanel fxPanel = new JFXPanel();
    
    public static void main(String[] args) throws IOException {
        
        JFrame frame = new JFrame();
        frame.add(new GodComponent());
        frame.setSize(800, 800);
        frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("cage.jpg")))));
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Media media = new Media(Paths.get("meme.mp3").toUri().toString());
        MediaPlayer mp = new MediaPlayer(media);
        mp.play();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.launch();
    }

}