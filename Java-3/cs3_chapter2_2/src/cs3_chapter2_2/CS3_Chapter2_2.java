package cs3_chapter2_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Chapter 2. Container Classes
 *   A container class is a class whose objects are used to store large numbers
 *   of objects.
 * 
 *   Two families of container classes: Collection, Map
 *   Two types of Collection classes: List, Set
 *     A list may have duplicates, a Set cannot.
 *     A list has order so each element can be accessed through its index, a set
 *     does not.
 * 
 *     Classes implementing List<E>: ArrayList<E>, LinkedList<E>, Vector<E>
 *     Classes implementing Set<E>: HashSet<E>, TreeSet<E>
 * 
 *     Methods in Set:
 *       boolean  add(E e)    -- Adds e into this set and returns true if e is not 
 *                               in this set, returns false otherwise.
 *       void     clear()     -- Empties the set.
 *       boolean  contains()  -- Returns true if e is in thisSet, returns false
 *                               otherwise.
 *       int      size()      -- Returns the number of elements in this Set.
 *       boolean  isEmpty()   -- 
 *       boolean  remove(E e) -- 
 *       Object[] toArray()   --
 * 
 *       Example, reads the words from a file, find the total number of distinct 
 *       words and print them out.
 * 
 *     Methods in List:
 *       void     add(int index, E e)    -- Appends e to the end of this list 
 *                                          and increase its size by 1.
 *       void     set(int index, E e)    -- Replaces the element at the position
 *                                          specified by index in this list.
 *       E        get(int index)         -- Returns the element at the position
 *                                          specified by the index in this list.
 *       E        remove(int index)      -- 
 *       
 *       Example, define our own ArrayList class. Because we don't know much 
 *       about generic classes, we will define our class by using Object type.
 * 
 *   Linked list structure:
 *   A linked list is a container that stores a sequence of nodes each of which 
 *   contains an element and a link to the next node.
 * 
 *   An iterator is an object that is used to traverse through a list. Every 
 *   list class in the library has the following method:
 *   ListIterator listIterator() -- returns an iterator that provides access to 
 *                                  the first element of the list.
 *   
 *   Methods in iterator interface:
 *        public boolean hasNext() -- returns true if there is a next element
 *        public E next()          -- returns the element right after the 
 *                                    iterator and advances the iterator to next
 *   Example, define our own linked list class
 * 
 *   Generic Programming
 *     Generic programming is the creation of programming constructs such as 
 *     methods and classes that use type parameters to allow the users to use 
 *     them with different types.
 * 
 *     e.g. ArrayList<String>
 *     e.g. Map<String, Character>
 * 
 *   Generic methods:
 *     1). When you define a generic method, you place a type parameter list 
 *         within angle brackets right before its return type in the header.
 * 
 *     2). When you activate a generic method, it is not different from a 
 *         regular method.
 * 
 *     You may put a constraint by using the phrase 
 *        "extends interface_name/class_name"
 *     after the type parameter.
 * 
 * @author John Gibson
 */
public class CS3_Chapter2_2
{

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("The larger one of this and that is " + larger("this", "that"));
        
        
        
        MyLinkedList l2 = new MyLinkedList();
        l2.add("This");
        l2.add("is");
        l2.add("my");
        l2.add("list");
        
        System.out.println("There are " + l2.size() + " elements in the list!");
        
        LinkedList<String> l = new LinkedList<>();
        l.add("This");
        l.add("is");
        l.add("a");
        l.add("list");
        
        for (String st : l) {
            System.out.print(st + " ");
            System.out.println();
        }
        
        l.add(3, "small");
        
        MyArrayList list = new MyArrayList(10);
        
        list.add("This");
        list.add("is");
        list.add(100);
        
        for (int i = 0; i < list.size(); i++) {
            
        }
        
        Set<String> set = new HashSet();
        StringTokenizer words = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File("input.txt")));
            String line = null;
            while((line = in.readLine()) != null) 
            {
                words = new StringTokenizer(line, " ,.?!\n\t");
                while (words.hasMoreTokens()) {
                    set.add(words.nextToken().toLowerCase());
                }
            }
            System.out.println("In the file input.txt, there are " + set.size()
                               + " distinct words and they are " + set);
        } catch(Exception e) {
            
        }
    }
    
    /** Define a method that finds the larger one of two elements **/
    public static <E extends Comparable> E larger(E e1, E e2) {
        if (e1.compareTo(e2) > 0) return e1;
        return e2;
    }
    
    /** Define a method that returns the index of the maximum element in an array
     * @param <E>
     * @param a
     * @return  **/
    public static <E extends Comparable> int maximumIndex(E[] a) {
        int index = 0;
        E max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(max) == 1) {
                max = a[i];
                index = i;
            }
        }
        return index;
    }
    
}
