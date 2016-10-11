package casting;

/**
 * A cat that may or may not catch mice, but certainly ignores its owner.
 * 
 * @author John Gibson
 */
public class Cat extends Pet {
    
    private final boolean IS_MOUSER;
    
    public Cat(String name) {
        super(name);
        this.IS_MOUSER = false;
    }
    
    public Cat(boolean isMouser, String name) {
        super(name);
        this.IS_MOUSER = isMouser;
    }
    
    @Override
    public String speak() {
        return "Meow.";
    }
    
    @Override
    public String toString() {
        if (IS_MOUSER) {
            return super.toString() + "\nI am a mouser cat.";
        }
        return super.toString() + "\nI am a cat.";
    }
    
}