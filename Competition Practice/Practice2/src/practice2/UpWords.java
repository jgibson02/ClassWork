package practice2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jhg95693
 */
public class UpWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int posIndex = 0;
        System.out.print("Size: ");
        int size = sc.nextInt();
        System.out.print("Bound: ");
        char bound = sc.next().charAt(0);
        System.out.print("Index: ");
        int index = sc.nextInt();
        
        

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        str = str.substring(0, size);
        

            while(true) {
                if (str.charAt(size - 1) != bound) {
                    char temp = (char) (1 + str.charAt(size - 1));
                    System.out.println((1 + str.charAt(size - 1)));
                    str = str.substring(0, size - 1);
                    str += temp;
                    posIndex++;
                } else {
                    char temp = (char) (str.charAt(size - 1) + 1);
                    str = str.substring(0, size - 1);
                    str += temp;

                    char temp2 = (char) (str.charAt(size - 1) + 1);
                    char[] doubleTemp = str.toCharArray();
                    doubleTemp[size - 1] = temp2;
                    str = doubleTemp.toString();
                }
                if (posIndex == index) {
                    break;
                }
            }
        
        System.out.println(str);

        /*
         ArrayList<String> upwords = new ArrayList<>();
         for (char i : alpha) {
         String s = "A";
         for (char j : alpha) {
         if (j != bound) {
         if (j > i) {
         s += j;
         }
         }
         }
         if (s.length() == size) {
         upwords.add(s);
         }

         }

         System.out.println("Upword: " + upwords.get(index));
         */
    }

}
