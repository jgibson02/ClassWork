/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gwt.geom.strokes;

import static gwt.geom.strokes.CompoundStroke.Operation.SUBTRACT;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Area;

/**
 *
 * @author jhg95693
 */
public class CompoundStroke implements Stroke {
    
    public enum Operation {ADD, SUBTRACT, INTERSECT, DIFFERENCE}
    
    private Operation operation = SUBTRACT;

    private Stroke stroke1;
    private Stroke stroke2;

    public CompoundStroke( Stroke stroke1, Stroke stroke2, Operation operation) {
        this.stroke1 = stroke1;
        this.stroke2 = stroke2;
        this.operation = operation;
    }

    @Override
    public Shape createStrokedShape( Shape shape ) {
        Area area1 = new Area( stroke1.createStrokedShape( shape ) );
        Area area2 = new Area( stroke2.createStrokedShape( shape ) );
        switch (operation) {
        case ADD:
            area1.add( area2 );
            break;
        case SUBTRACT:
            area1.subtract( area2 );
            break;
        case INTERSECT:
            area1.intersect( area2 );
            break;
        case DIFFERENCE:
            area1.exclusiveOr( area2 );
            break;
        }
        return area1;
    }
}
