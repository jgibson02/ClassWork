
import javax.swing.JFrame;

/**
 *
 *
 * @author John Gibson
 */
public class MyFrame {

    public static void main(String[] args) {
        JFrame frame;
        frame = new JFrame("Self Portrait");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DiagonalBar());
        frame.setVisible(true);
        
        frame.setResizable(true);
        frame.setAlwaysOnTop(true);
    }

}
