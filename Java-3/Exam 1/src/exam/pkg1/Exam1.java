/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.pkg1;

/**
 * Tests the methods of the Queue class.
 * @author John Gibson
 */
public class Exam1
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Queue<String> q = new Queue();
        System.out.println(q.deQueue());
        q.queue("First");
        q.queue("Second");
        q.queue("Third");
        q.queue("Fourth");
        System.out.println(q.deQueue());
    }

}
