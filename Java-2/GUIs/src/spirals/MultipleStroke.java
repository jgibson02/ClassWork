package spirals;

import java.awt.Shape;
import java.awt.Stroke;

/**
 * 
 * @author John Gibson
 * @version Apr 6, 2016
 */
public class MultipleStroke implements Stroke {
    private Stroke s1;
    private Stroke s2;
    
    public MultipleStroke(Stroke s1, Stroke s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
    
    @Override
    public Shape createStrokedShape(Shape s) {
        return s2.createStrokedShape(s1.createStrokedShape(s));
    }
}