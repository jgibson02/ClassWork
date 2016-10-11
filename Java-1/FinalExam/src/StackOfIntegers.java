
import java.util.Random;

/**
 * @author John Gibson
 */
public class StackOfIntegers {

    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers(10);
        stack.add(2);
        stack.add(3);
        stack.add(5);
        System.out.println(stack);
        
        stack.reverse();
        stack.remove();
        stack.add(8);
        stack.add(9);
        System.out.println(stack);
        
        stack.fillRandom(100);
        System.out.println(stack);
        
        stack.remove();
        System.out.println(stack);
    }
    
    public int[] stack;
    public int length;
    
    public StackOfIntegers(int n) {
        stack = new int[n];
        length = n;
    }
    
    public void add(int n) {
        stack[findFirstZero()] = n;
    }
    
    public void reverse() {
        int[] temp = new int[length];
        int j = findFirstZero() - 1;
        for (int i = 0; i < findFirstZero() - 1; i++) {
            if (stack[j] != 0) {
                temp[i] = stack[j];
            }
            j--;
        }
        System.arraycopy(temp, 0, stack, 0, length);
    }
    
    public void remove() {
        if (findFirstZero() == 0) {
            stack[length - 1] = 0;
        } else {
           stack[findFirstZero()] = 0; 
        }
    }
    
    private int findFirstZero() {
        int p = 0;
        for (int i = 0; i < length; i++) {
            if (stack[i] == 0) { 
                p= i; break;
            }
        } return p;
    }
    
    
    public void fillRandom(int n) {
        Random rand = new Random();
        for (int i = findFirstZero(); i < length; i++) {
            stack[i] = rand.nextInt(n);
        }
    }
    
    @Override
    public String toString() {
        String s = "";
        s += "{";
        for (int i = 0; i < length - 1; i++) {
            if (stack[i] != 0) {
                s += stack[i] + ", ";
            }
        }
        s += stack[length - 1];
        s += "}";
        return s;
    }
}
