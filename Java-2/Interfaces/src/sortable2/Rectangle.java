package sortable2;

/**
 * 
 * @author John Gibson
 */
public class Rectangle extends java.awt.Rectangle implements Sortable {
    
    public Rectangle(int x, int y) {
        super(x, y);
    }
    
    @Override
    public boolean comesBefore(Sortable rectangle) {
        Rectangle r = (Rectangle) rectangle;
        double thisArea = getWidth() * getHeight();
        double rArea = r.getWidth() * r.getHeight();
        return thisArea <= rArea;
    }
    
}
