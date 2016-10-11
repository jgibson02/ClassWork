/*
* This program demonstrates the String class and some of its methods
* @author John Gibson
*/
public class StringDemo {
  public static void main(String[] args) {
    System.out.println(5 + 7);
    System.out.println("5 + 7");
    System.out.println("5" + "7");
    System.out.println("5" + 7);
    System.out.println();

    String str = "quokka";
    System.out.println(str);

    String str2 = new String("quokka");
    System.out.println(str2);

    System.out.println(str.toUpperCase());
    System.out.println(str); //quokka

    str = str.toUpperCase();
    System.out.println(str); //QUOKKA
    System.out.println();

    str = "Your powers are weak, old man!";
    System.out.println(str.replace("p", "fl"));

    int k = str.indexOf(",");
    //String s = str.substring(0, k);
    //System.out.println(s);
    System.out.println(str.substring(0,k).toUpperCase());

    // introducing... escape characters
    System.out.println("*\n**\n***");
    System.out.println("A\tB\tC");

    // I want this output: She said, "ATTACK!"
    System.out.println("She said, \"ATTACK!\"");

    // I want this output: This is a backslash: \
    System.out.println("This is a backslash: \\");
  }
}
