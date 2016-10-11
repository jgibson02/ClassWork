package finalpractice;

/**
 * This method stores and array of characters and provides
 * methods allowing updates to the character sequence.
 * @author Austin Myers
 */
public class MutableString {
    private final char[] list;
    private final char[] list2;
    private int arrayPos = 0;
    
    public MutableString(int a){
        list = new char[a];
        list2 = new char[a];
    }
    
    public void add(char a){
        list[arrayPos] = a;
        list2[arrayPos] = a;
        arrayPos++;
    }
    
    public void reverse() {
        int j = 0;
        for (int i = list.length - 1; i > 0; i--) {
            list2[i] = list[j];
            j++;
        }
        list2[0] = list[list.length - 1];
    }
    
    public void removeLast() {
     list2[list.length - 1] = ' ';   
    }
    
    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < list.length; i++) {
            s += list2[i];
        }
        
        return s;
    }
            
}