package implementingclasses;

/**
 *
 * @author jhg95693
 */
public class MyString {
    
    char[] list;
    int length;
    
    public MyString(int size) {
        list = new char[size];
        length = size;
    }
    
    /**
    public char[] substring(int a, int b) {
        int substringSize = b - a;
        String s;
        for (a < b; a++) {
            s += list[a];
        }
        return s;
    }
    **/
    
    public void add(char c) {
        list[findPosOfFirstNull()] = c;
    }
    
    public void reverse() {
        char[] reversedString = new char[length];
        
        int i = 0;
        for (int j = length - 1; j > 0; j--) {
            reversedString[i] = list[j];
            i++;
        }
        reversedString[0] = list[length - 1];
        
        for (int k = 0; k < reversedString.length; k++) {
            list[k] = reversedString[k];
        }
    }
    
    public void removeLast() {
        list[findPosOfFirstNull() - 1] = '\0';
    }
    
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < list.length; i++) {
            if (list[i] != '\0') {
                string += list[i];
            }
        }
        return string;
    }
    
    private int findPosOfFirstNull() {
        int p = 0;
        for (int i = 0; i < length; i++) {
            if (list[i] == '\0') { 
                p= i; break;
            }
        } return p;
    }
}