package casting;

/**
 * A dog that attacks strangers.
 * 
 * @author John Gibson
 */
public class GuardDog extends Dog {

    private final boolean IS_FIERCE;
    
    public GuardDog(boolean isFierce, int num, String name) {
        super(num, name);
        this.IS_FIERCE = isFierce;
    }
    
    /**
     * Creates a fierce guard dog.
     */
    public GuardDog(int num, String name) {
        this(true, num, name);
    }
    
    @Override
    public String toString() {
        if (IS_FIERCE) {
            return super.toString() + "\nI am fierce.";
        }
        return super.toString() + "\nI am rather timid.";
    }
    
    public void attackStranger() {
        // Master is in danger!
    }

}
