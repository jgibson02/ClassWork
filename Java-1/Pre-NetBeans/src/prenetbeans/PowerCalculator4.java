import java.util.Scanner;
import java.math.BigInteger;
import javax.swing.*;

public class PowerCalculator4 {
  public static void main(String[] args) {
    String prompt = "Enter base and exponent.";
    String input = JOptionPane.showInputDialog(prompt);

    Scanner sc = new Scanner(input);

    String baseString = sc.next();
    BigInteger base = new BigInteger(baseString);
    int exponent = sc.nextInt();

    BigInteger result = base.pow(exponent);
    String output = base + "^" + exponent + " = " + result;
    JOptionPane.showMessageDialog(null, result);
  }
}
