package euclidiangcdcalculator;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import static euclidiangcdcalculator.CalculateGCD.getGCD;

/**
 *
 * @author John Gibson
 */
public class EuclidianGCDCalculator extends JFrame {

    private static JPanel firstIntPanel;
    private static JPanel secondIntPanel;
    private static JPanel gcdPanel;
    private static JTextField firstIntField;
    private static JTextField secondIntField;
    private static JLabel gcdLabel;
    private static final JLabel FIRST_PRIME_LABEL = new JLabel("Integer is prime");
    private static final JLabel SECOND_PRIME_LABEL=  new JLabel("Integer is prime");
    private static final int FIELD_WIDTH = 5;

    class InputListener implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateText();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            updateText();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateText();
        }

        public void updateText() {
            if (!firstIntField.getText().equals("") & !secondIntField.getText().equals("")) {
                try {
                    int m = Integer.parseInt(firstIntField.getText());
                    int n = Integer.parseInt(secondIntField.getText());
                    gcdLabel.setText(Integer.toString(getGCD(m, n)));
                } catch (NumberFormatException nfe) {
                    gcdLabel.setText(" ");
                }
            } else {
                gcdLabel.setText(" ");
            }
        }
    };

    public EuclidianGCDCalculator() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        setTitle("GCD Calculator");
        setLocationRelativeTo(null);
        setResizable(false);
        setMinimumSize(new Dimension(300, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 24);

        // first integer
        firstIntPanel = new JPanel();
        firstIntPanel.setBorder(new TitledBorder(new EtchedBorder(), "First Integer"));
        firstIntField = new JTextField(FIELD_WIDTH);
        firstIntField.setFont(f);
        firstIntPanel.add(firstIntField);

        // second integer
        secondIntPanel = new JPanel();
        secondIntPanel.setBorder(new TitledBorder(new EtchedBorder(), "Second Integer"));
        secondIntField = new JTextField(FIELD_WIDTH);
        secondIntField.setFont(f);
        secondIntPanel.add(secondIntField);

        // gcd
        gcdPanel = new JPanel();
        gcdPanel.setBorder(new TitledBorder(new EtchedBorder(), "GCD", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        gcdLabel = new JLabel(" ");
        gcdLabel.setFont(f);
        gcdPanel.add(gcdLabel);

        InputListener listener = new InputListener();
        firstIntField.getDocument().addDocumentListener(listener);
        secondIntField.getDocument().addDocumentListener(listener);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 1;
        panel.add(firstIntPanel, c);
        panel.add(secondIntPanel, c);
        c.gridwidth = 2;
        c.gridy = 1;
        c.fill = GridBagConstraints.BOTH;
        panel.add(gcdPanel, c);

        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        EuclidianGCDCalculator gcdCalc = new EuclidianGCDCalculator();
    }

}
