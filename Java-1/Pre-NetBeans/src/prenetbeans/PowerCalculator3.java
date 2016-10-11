import java.util.Scanner;
import java.math.BigInteger;
import javax.swing.*;

public class PowerCalculator3 {
  public static void main(String[] args) {
    String baseString = JOptionPane.showInputDialog("Enter base.");
    BigInteger base = new BigInteger(baseString);

    String expString = JOptionPane.showInputDialog("Enter exponent.");
    int exponent = Integer.parseInt(expString);

    BigInteger result = base.pow(exponent);
    String output = base + "^" + exponent + " = " + result;
    JOptionPane.showMessageDialog(null, result);
  }
}
