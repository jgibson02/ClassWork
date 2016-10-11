package casting;

/**
 * A licensed dog.
 * 
 * @author John Gibson
 */
public class Dog extends Pet {
    
    private final int LICENSE_NUM;

    public Dog(String name) {
        super(name);
        LICENSE_NUM = 0;
    }
    
    public Dog(int num, String name) {
        super(name);
        this.LICENSE_NUM = num;
    }

    @Override
    public String speak() {
        return "Bark!";
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nI am a dog (" + LICENSE_NUM + ").";
    }
    
    public void fetchStick() {
        System.out.println(name + " is fetching a stick.");
    }
    
}
