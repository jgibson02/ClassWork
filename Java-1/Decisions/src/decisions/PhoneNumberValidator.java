/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decisions;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * This program prompts the user for a phone number and then checks if the input format
 * is valid. A valid phone number must have one of the following forms:
 * 
 * 570 555-1212
 * 570-555-1212
 * (570) 555-1212
 * 
 * @author John Gibson
 */
public class PhoneNumberValidator {

    public static void main(String[] args) {
        String prompt = "Enter a phone number.";
        String input = JOptionPane.showInputDialog(prompt);
        Scanner sc = new Scanner(input);
        if (isValidPhoneNumber(input)) {
            JOptionPane.showMessageDialog(null, "VALID");
        } else {
            JOptionPane.showMessageDialog(null, "INVALID");
        }
    }

    /**
     * Regular expressions are used to check if a given phone number has the correct form.
     * @param input the phone number to be checked
     * @return true if input has one of the three required forms
     */
    private static boolean isValidPhoneNumber(String input) {
        String areaCode = "\\d\\d\\d";
        String exchange = "\\d\\d\\d";
        String line = "\\d\\d\\d\\d";
        
        // three valid formats
        String s1 = areaCode + " " + exchange + "-" + line;
        String s2 = areaCode + "-" + exchange + "-" + line;
        String s3 = "\\(" + areaCode + "\\)" + " " + exchange + "-" + line;
        
        return input.matches(s1) || input.matches(s2) || input.matches(s3);
    }
    
}
