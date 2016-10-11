package finalpractice;

/**
 * This program tests the Mutable String class.
 * @author Austin Myers
 */

public class Stringthing { 

    public static void main(String[] args) { 
        MutableString list = new MutableString(10); 
        list.add('A');    // {A} 
        list.add('B');    // {A, B} 
        list.add('C');    // {A, B, C} 
        list.add('D');    // {A, B, C, D} 
        System.out.println(list); 
        list.reverse();   // {D, C, B, A} 
        list.removeLast();// {D, C, B} 
        list.add('X');    // {D, C, B, X} 
        list.add('Y');    // {D, C, B, X, Y} 
        System.out.println(list); 
    }
}