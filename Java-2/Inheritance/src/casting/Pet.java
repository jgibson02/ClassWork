package casting;

/**
 * A pet with a name and an identifying sound.
 * 
 * @author John Gibson
 */
public abstract class Pet {
    protected final String name;
   
    public Pet(String name) {
        this.name = name;
    }
   
    public abstract String speak();
   
    @Override
    public String toString() {
        return "My name is " + name + ".";
    }
}