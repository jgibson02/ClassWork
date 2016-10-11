/*
 * Review for classes
 * What is a class?
 *   A class is a programming structure that defines a group of instances by 
 *   specifying their fields/attributes, consructors, and methods.
 *
 * An attribute/field is a variable for storing the values of an object.
 * An object is an instance of a class.
 * The format for declaring an attribute:
 *    access specifier, static or instance, type, variable name.
 *
 * A static attribute is also called a class-wide attribute which has the same 
 * value in all objects of the class in the same program.
 * Example, define a Fraction class
 * 
 * A constructor is a special method that is used to create objects of the 
 * class. The format for defining a constructor:
 *    access specifier (public), the name of the class, parameter list within 
 *    parentheses, body within braces
 * 
 * Two kinds of constructors:
 *   If you don't define a constructor for your class, it gives you a 
 *   free/default one automatically. This default constructor intializes the 
 *   attributes to their default values.
 *   If you
 * 
 * What are the differences between constructors and regular methods?
 *    A method has to have a return type, but a constructor does not.
 *    A constructor's name has to be exactly the class name, but a method's name can be 
 *    any word as long as it satisfies the three rules for naming identifiers:
 *       1. can contain only letters, digits, and/or underscore
 *       2. cannot start with digit
 *       3. cannot be exactly a reserved word
 * 
 * The differences between a static method and an instance method:
 *    1. A static method has the static keyword between the access specifier and
 *       its return type, and an instance method does not.
 *    2. An instance method must be activated/called by an object of the class, and a 
 *       static method may be activated/called by its class name.
 *    The toString() method: formats this object to a string and returns it
 * 
 * The differences between a value-returning method and a non-value returning method
 *    1. A non-value returning method has void as its return type, a value-returning 
 *       method must have an actual data type as its return type.
 *    2. A value-returning method must have a return statement in its body that returns 
 *       a value that matches the type of the return type; a non-value returning method 
 *       may not have a return statement.
 *    3. When a value-returning method is used, you need to catch the value returned; 
 *       when a non-value returning method is used, the method call can be an independent
 *       statement.
 * 
 * If an instance method modifies the values of the object activating it, the method is 
 * called a mutator. (e.g. Fraction.simplify())
 * If an instance method accesses the values of the object activating it without 
 * modifying them, it is called an accessor. (e.g. Fraction.add())
 * 
 * Reference types vs. primitive types
 * A reference type is a type defined by a class.
 * A reference type variable stores the address of the object assigned to it.
 * A primitive type is a type built in the language such as int, double, and boolean.
 * A primitive type variable stores the value assigned to it.
 * 
 * == compares the values of the operands
 * 
 * To compare two objects of a class, you need to override the Object.equals() method.
 * 
 * Arrays and Collections class, Comparable and Comparator Interfaces
 * 
 * Natural ordering is an ordering defined by the Comparable Interface which is a generic interface
 * with one method:
 *     public int compareTo(T obj) -- returns  1 if this object > object given
 *                                 -- returns  0 if this object = object given
 *                                 -- returns -1 if this object < object given
 * 
 */
package review;

import java.util.Random;

/**
 * 
 * @author jhg95693
 */
public class Review
{
    
    public static void main(String[] args) 
    {        
        int x = 10, y = 10;
        if (x == y) System.out.println("I am very excited!");
        
        Fraction f = new Fraction();
        System.out.println("My fraction is " + f);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = new Fraction(1, 2);
        if (f2 == f3) {
            System.out.println("I am very disappointed!");
        } else {
            System.out.println("I am happy now!");
        }
        
        System.out.println("My fraction is " + f2);
        System.out.println("My fraction is " + f3);
        System.out.println("f2 + f3 = " + f2.add(f3));
        Review r = new Review();
        System.out.println("The gcd of 20 and 15 is: " + f2.gcd(20, 15));
        
        Fraction[] fa = new Fraction[100];
        Random ran = new Random();
        for (int i = 0; i < 100; i++) {
            fa[i] = new Fraction(ran.nextInt(100), ran.nextInt(99) + 1);
        }
        for (int i = 0; i < 100; i++) {
            System.out.print(fa[i] + ", ");
            System.out.println("\n\n");
        }
    }
    
}