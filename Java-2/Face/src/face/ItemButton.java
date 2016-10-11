package face;

import javax.swing.*;
import java.awt.*;

/**
 * A custom button used to replicate the buttons on the Mii Maker.
 *
 * @author John Gibson, Daniel Kilgallon
 */
public class ItemButton extends JButton {

    private Color backgroundColor;

    /**
     * Default constructor
     */
    public ItemButton() {
        setUI(new ItemButtonUI());
        setContentAreaFilled(false);
        setBackground(Color.LIGHT_GRAY);
    }

    /**
     * adds an Icon to button at initialization
     */
    public ItemButton(ImageIcon ic) {
        setUI(new ItemButtonUI());
        setContentAreaFilled(false);
        setIcon(ic);
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color c) {
        this.backgroundColor = c;
    }
}