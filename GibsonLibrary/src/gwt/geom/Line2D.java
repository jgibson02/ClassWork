package gwt.geom;

import java.awt.geom.Point2D;

/**
 * 
 * @author John
 */
public class Line2D {
    public class Double extends java.awt.geom.Line2D.Double {
        public Point2D.Double getIntersect(Line2D.Double line1, Line2D.Double line2) {
            if (! line1.intersectsLine(line2)) {
                return null;
            }
            double px = line1.getX1(),
                py = line1.getY1(),
                rx = line1.getX2() - px,
                ry = line1.getY2() - py;
            double qx = line2.getX1(),
                qy = line2.getY1(),
                sx = line2.getX2() - qx,
                sy = line2.getY2() - qy;

            double det = sx*ry - sy*rx;
            if (det == 0) {
                return null;
            } else {
                double z = (sx * (qy - py) + sy * (px - qx)) / det;
                if (z==0 ||  z==1) {
                    return null;
                }
            // intersection at end point!
            return new Point2D.Double((float) (px + z * rx), (float) (py + z * ry));
            }
        }
    }
}
