package cs3_chapter2_2;

/**
 *
 * @author jhg95693
 */
public class MyArrayList
{
    private int capacity;
    private Object[] data;
    private int size; // the number of elements in the array
    
    public MyArrayList(int capacity) 
    {
        data = new Object[capacity];
        this.capacity = capacity;
    }
    
    public void add(Object e) 
    {
        if (capacity == size) {
            enlarge(); // enlarge the array
            data[size++] = e;
        }
    }
    
    public void add(int index, Object e) {
        if (capacity == size) {
            enlarge(); // enlarge the array
            for (int i = size; i >= index; i--) 
            {
                data[i + 1] = data[i];
            }
            data[index] = e;
            size++;
        }
    }
    
    public void set(int index, Object e) {
        data[index] = e;
    }
    
    public int size() {
        return this.size;
    }
    
    public void enlarge() 
    {
        capacity = 2 * capacity;
        Object[] setData = new Object[capacity];
        for (int i = 0; i < capacity; i++)
        {
            setData[i] = data[i];
            data = setData;
        }
    }
}
