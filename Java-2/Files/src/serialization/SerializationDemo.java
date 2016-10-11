package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author John Gibson
 * @version Apr 27, 2016
 */
public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final String FILE_NAME = "myfile";
        MyClass m1 = new MyClass();
        MyClass m2 = new MyClass();
        System.out.println(m1);
        System.out.println(m2);
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(m1);
            out.writeObject(m2);
        }
        
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
        MyClass x = (MyClass) in.readObject();
        MyClass y = (MyClass) in.readObject();
        System.out.println(x);
        System.out.println(y);
    }
}

class MyClass implements Serializable {
    private final double MY_DOUBLE;
    private final String MY_STRING;
    
    public MyClass() {
        MY_DOUBLE = Math.random();
        MY_STRING = super.toString();        
    }
    
    @Override
    public String toString() {
        return MY_DOUBLE + " " + MY_STRING;
    }
}