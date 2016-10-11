import java.util.Scanner;
import java.math.BigInteger;

public class PowerCalculator2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter base and exponent: ");

    String baseString = sc.next();
    BigInteger base = new BigInteger(baseString);

    int exponent = sc.nextInt();
    BigInteger result = base.pow(exponent);
    // int result = (int) Math.pow (base, exponent);

    //display result
    String output = base + "^" + exponent + " = " + result;
    System.out.println(output);
  }
}
