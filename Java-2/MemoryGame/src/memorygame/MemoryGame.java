package memorygame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * Creates a the window for a 4x4 matching game, where there are 8 pairs of 
 * matching images. The user may adjust the frequency with which the game checks to see
 * if they have matched a pair of tiles when creating the memory game. The game also keeps
 * track of how much time has elapsed since they began selecting tiles and reports it to 
 * the user once they've won the game, as well as in real-time.
 * 
 * @author John Gibson
 */
public class MemoryGame extends JFrame {
    private Tile t1;
    private Tile t2;
    private int matchCount = 0;
    private ArrayList<Tile> tiles = new ArrayList<>();
    private Timer tileCheckTimer;
    private Timer elapsedTimeTimer;
    private double elapsedTime = 0;
    private double bestTime;
    private static SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:SS");
    
    public void flipTile(Tile t) {
        if (t1 == null && t2 == null) {
            t1 = t;
            t1.setIcon(t.selectedIcon);
        } else if (t1 != null && t1 != t && t2 == null) {
            t2 = t;
            t2.setIcon(t.selectedIcon);
            tileCheckTimer.start();
            elapsedTimeTimer.start();
            if (isWon()) {
                elapsedTimeTimer.stop();
                
                if (elapsedTime <= bestTime && bestTime != 0) {
                    bestTime = elapsedTime;
                    JOptionPane.showMessageDialog(null, "New best time!" + "\n" + getFormattedTime(bestTime));
                }
                
                JFrame gameWon = new JFrame("You won!");
                
                String labelText = new String("You won!" + 
                        "\nClick restart to start" +
                        "\nYour time was: "
                        + getFormattedTime(elapsedTime));
                JLabel youWonLabel = new JLabel(labelText);
                youWonLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                
                JButton restartButton = new JButton("Restart");
                restartButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        setVisible(false);
                        startNewGame();
                        restartButton.setVisible(false);
                    }
                });
                restartButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
                
                gameWon.setLayout(new BoxLayout(gameWon.getContentPane(), BoxLayout.Y_AXIS));
                gameWon.add(youWonLabel);
                gameWon.add(restartButton);
                gameWon.setVisible(true);
                gameWon.setLocationRelativeTo(null);
                gameWon.setSize(200, 150);
                JOptionPane.showMessageDialog(null, "You've won!");
                String musicpath = MemoryGame.class.getResource("/music/friendsmidi.mp3").toString();
                Media media = new Media(musicpath);
                MediaPlayer mp = new MediaPlayer(media);
                mp.play();
            }
        }
    }
    
    public void compareTiles() {
        if (t1.getID() == t2.getID()) {
            t1.setMatched(true);
            t2.setMatched(true);
            t1.setEnabled(false);
            t2.setEnabled(false);
            matchCount++;
        } else {
            t1.setIcon(new ImageIcon(MemoryGame.class.getResource("/images/FriendsTileDark.jpg")));
            t2.setIcon(new ImageIcon(MemoryGame.class.getResource("/images/FriendsTileDark.jpg")));
        }
        t1 = null;
        t2 = null;
    }
    
    public boolean isWon() {
        return matchCount == 7;
    }
    
    public int getMatches() {
        return this.matchCount;
    }
    
    public double getBestTime() {
        return this.bestTime;
    }
    
    public static String getFormattedTime(double t) {
        return sdf.format(new Date((long)(t*1000)));
    }
    
    public void startNewGame() {
        dispose();
        MemoryGameGUI.main(new String[0]);
    }
    
    public MemoryGame(int TimerFrequency) {
        JFXPanel fxPanel = new JFXPanel();
        
        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
        setVisible(true);
        
        JPanel header = new JPanel();
        JLabel timerLabel = new JLabel("Time elapsed: ");
        JTextArea elapsedTimeArea = new JTextArea("0:00:00");
        elapsedTimeArea.setSize(100, 20);
        header.add(timerLabel);
        header.add(elapsedTimeArea);
        add(header);
        
        JPanel cardGrid = new JPanel();
        cardGrid.setLayout(new GridLayout(4, 4));
        
        //
        elapsedTimeTimer = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                elapsedTime = ((double) (elapsedTime + 0.1));
                String formattedTime = getFormattedTime(elapsedTime);
                elapsedTimeArea.setText(formattedTime);
            }
        });
        
        // create a timer to check whether two tiles are matched every half a second
        tileCheckTimer = new Timer(TimerFrequency, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                compareTiles();
            }
        });
        tileCheckTimer.setRepeats(false);

        // create and shuffle an arraylist comprising of pairs of integer IDs from 0 to 7
        final int numOfPairs = 8;
        ArrayList<Integer> tileIDs = new ArrayList<>();
        for (int i = 0; i < numOfPairs; i++) {
            tileIDs.add(i);
            tileIDs.add(i);
        }
        Collections.shuffle(tileIDs);
        
        // create a tile using each ID in tileIDs, make it perform flipTile() when clicked
        // and add it to an ArrayList of tiles
        for (int id : tileIDs) {
            Tile t = new Tile(id);
            t.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    flipTile(t);
                }
                
            });
            tiles.add(t);
        }
        
        // add each tile to the card grid
        for (Tile t : tiles) {
            cardGrid.add(t);
        }
        
        add(cardGrid);

        pack();
    }
    
}