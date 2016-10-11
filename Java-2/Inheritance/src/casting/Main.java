package casting;

/**
 * 
 * @author John Gibson
 */
public class Main {
    
    public static void main(String[] args) {
        Pet karl = new Dog(54721, "Karl");
        Pet velvet = new Cat(true, "Velvet");
        
        System.out.println(karl);
        System.out.println();
        
        System.out.println(velvet);
        System.out.println();
        
        // This would not compile:
        // karl.fetchStick();
        
        // downcasting
        ((Dog) karl).fetchStick();
        
        // upcasting
        Dog butch = new GuardDog(true, 48372, "Butch");
        System.out.println(butch);
        System.out.println();
        
        Pet aPet = velvet;
        System.out.println(aPet.speak());
        System.out.println();
        
    }
    
}