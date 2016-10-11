package exam.pkg1;

/**
 * A container class that follows the "first in, first out" policy. Only the 
 * first element (the one in the front) in the Queue can be seen and removed by
 * the user and data can only be inserted to the rear (after the last one) of 
 * the queue.
 * @author John Gibson
 * @param <T>
 */
public class Queue<T>
{

    private Node<T> front;
    private Node<T> rear;
    private int size;

    /**
     * Explicit constructor
     */
    public Queue()
    {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Places obj at the rear of the Queue.
     * @param obj the object being placed in the Queue.
     */
    public void queue(T obj)
    {
        rear = new Node(obj, front);
        if (front == null)
            front = rear;
        size++;
    }

    /**
     * Returns the data at the front of the Queue without removing it or returns
     * null if the Queue is empty.
     * @return the data at the front of the Queue
     */
    public T peek()
    {
        if (size != 0)
            return front.getData();
        else
            return null;
    }

    /**
     * Returns and removes the data in the front of the Queue if the Queue is not 
     * empty. Otherwise it returns null.
     * @return the data in the front of the Queue if the Queue is not empty. 
     * Otherwise it returns null.
     */
    public T deQueue()
    {
        if (size != 0)
        {
            Node<T> oldFront = front;
            front = front.getLink();
            size--;
            return oldFront.getData();
        } else
            return null;
    }

    /**
     * @return the number of pieces of data in the Queue.
     */
    public int size()
    {
        return size;
    }

    /**
     * @param obj the object to be checked if it is in the Queue.
     * @return true if the obj is in the Queue and returns false otherwise.
     */
    public boolean contains(T obj)
    {
        Node<T> currentNode = front;
        while (currentNode.getLink() != null)
        {
            if (currentNode.getData() == obj)
                return true;
        }
        return false;
    }

    /**
     * @return true if the Queue is empty, false otherwise.
     */
    public boolean empty()
    {
        return size == 0;
    }

    /**
     * Empties the Queue.
     */
    public void clear()
    {
        front = null;
        rear = null;
        size = 0;
    }

}
