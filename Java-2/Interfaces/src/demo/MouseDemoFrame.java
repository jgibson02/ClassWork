package demo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author John Gibson
 */
public class MouseDemoFrame extends JFrame {
    private final JComponent c1;
    private final JComponent c2;
    private final JComponent c3;
    private final JComponent c4;
    private final JComponent c5;
    private final JComponent c6;
    private final JComponent c7;
    private final JComponent c8;
    private final JComponent c9;
    
    public MouseDemoFrame() {
        setLayout(new FlowLayout());
        setLayout(new FlowLayout());
        
        c1 = new MouseDemo4();
        c2 = new MouseDemo4();
        c3 = new MouseDemo4();
        c4 = new MouseDemo4();
        c5 = new MouseDemo4();
        c6 = new MouseDemo4();
        c7 = new MouseDemo4();
        c8 = new MouseDemo4();
        c9 = new MouseDemo4();
        
        Dimension dim = new Dimension(400,200);
        c1.setPreferredSize(dim);
        c2.setPreferredSize(dim);
        c3.setPreferredSize(dim);
        c4.setPreferredSize(dim);
        c5.setPreferredSize(dim);
        c6.setPreferredSize(dim);
        c7.setPreferredSize(dim);
        c8.setPreferredSize(dim);
        c9.setPreferredSize(dim);
        
        add(c1);
        add(c2);
        add(c3);
        add(c4);
        add(c5);
        add(c6);
        add(c7);
        add(c8);
        add(c9);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        setAlwaysOnTop(true);
    }
    
    public static void main(String[] args) {
        MouseDemoFrame mdf = new MouseDemoFrame();
    }
    
    @Override
    public void repaint() {
        super.repaint();
        c1.repaint();
        c2.repaint();
        c3.repaint();
        c4.repaint();
        c5.repaint();
        c6.repaint();
        c7.repaint();
        c8.repaint();
        c9.repaint();
    }
}
