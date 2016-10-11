/**
* Prompts the user to enter two numbers, and then computes the first number raised to the power of the second.
*
* @author John Gibson
*
*/

import java.util.Scanner;

public class PowerCalculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter base and press ENTER: ");
		int base = in.nextInt();

		System.out.print("Enter exponent and press ENTER: ");
		int exponent = in.nextInt();

		//compute result
		int result = (int) Math.pow(base, exponent);

		//display result
		String output = base + "^" + exponent + " = " + result;
		System.out.println(output);
	}
}
