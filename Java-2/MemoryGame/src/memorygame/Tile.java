package memorygame;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 
 * @author John
 */

public class Tile extends JButton {
        public int id;
        public boolean isMatched = false;
        public ImageIcon unselectedIcon;
        public ImageIcon selectedIcon;
        
        public void setMatched(boolean b) {
            this.isMatched = b;
        }
        
        public ImageIcon getTileImage() {
            if (id == 0) {
                return new ImageIcon(MemoryGame.class.getResource("/images/ross.png"));
            } else if (id == 1) {
                return new ImageIcon(MemoryGame.class.getResource("/images/monica.png"));
            } else if (id == 2) {
                return new ImageIcon(MemoryGame.class.getResource("/images/rachel.png"));
            } else if (id == 3) {
                return new ImageIcon(MemoryGame.class.getResource("/images/joey.png"));
            } else if (id == 4) {
                return new ImageIcon(MemoryGame.class.getResource("/images/phoebe.png"));
            } else if (id == 5) {
                return new ImageIcon(MemoryGame.class.getResource("/images/chandler.png"));
            } else if (id == 6) {
                return new ImageIcon(MemoryGame.class.getResource("/images/janice.png"));
            } else if (id == 7) {
                return new ImageIcon(MemoryGame.class.getResource("/images/couch.png"));
            }
            return null;
        }
        
        public Tile(int id) {
            this.id = id;
            selectedIcon = getTileImage();
            setIcon(new ImageIcon(
                    MemoryGame.class.getResource("/images/FriendsTileDark.jpg")));
        }
        
        public int getID() {
            return this.id;
        }
        
    }