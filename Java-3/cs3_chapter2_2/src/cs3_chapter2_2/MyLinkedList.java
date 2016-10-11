package cs3_chapter2_2;

/**
 *
 * @author jhg95693
 */
public class MyLinkedList
{
    private Node firstOne;
    private Node lastOne;
    private int size; // The number of elements in the list
    
    // constructor
    public MyLinkedList() 
    {
        firstOne = null;
        size = 0;
    }
    
    public void setLink(Object e) {
        
    }
    
    /** appends the given element to the end of the list **/
    public void add(Object e) 
    {
        Node n = new Node(e, null);
        if (firstOne == null) {
            firstOne = n;
        } else {
            lastOne.setLink(n);
        }
        lastOne = n;
        size++;
    }
    
    /**
     * Add the given element to a given position. If the index for the given 
     * position is out of the list, append the element to the end of the list.
     * @return 
     */
    public void add(int index, Object e) 
    {
        if (index >= size) {
            add(e);
        } else {
            // find the node at index--
            Node n = firstOne;
            for (int c = 0; c < index - 1; c++) {
                n = n.getLink();
            }
            if (index == 0) {
                firstOne = new Node(e, firstOne);
            } else {
                n.setLink(new Node(e, n.getLink()));
            }
            size++;
        }
    }
    
    public void set(int index, Object e) {
        if (index >= size) {
            return;
        }
        Node n = firstOne;
        for (int i = 0; i < index; i++) {
            n = n.getLink();
        }
        return n.getData();
    }
    
    public boolean isEmpty() 
    {
        return firstOne == null;
    }
    
    public void remove(int i) 
    {
        Node n = firstOne;
        for (int j = 0; j < i - 1; j++)
        {
            n = n.getLink();
        }
    }
    
    public Object get(int i) 
    {
        Node n = firstOne;
        for (int j = 0; j < i; j++)
        {
            n = n.getLink();
        }
        return n.getData();
    }
    
    public int size() {
        return this.size;
    }
    
    @Override
    public String toString() {
        String s = "[";
        for (Node n = firstOne; n != null; n = n.getLink()) {
            s += n.getData() + ", ";
        }
        return s;
    }
}
