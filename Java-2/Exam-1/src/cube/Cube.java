package cube;

/**
 * 
 * @author John Gibson
 */
public class Cube implements Comparable {
    int length;
    int width;
    int height;
    int volume;
    
    Cube(int n) {
        this.length = n;
        this.width = n;
        this.height = n;
        this.volume = (int) Math.pow(n, 3);
    }
    
    Cube(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = length * width * height;
    }
    
    public String toString() {
        return "[" + "length=" + length + ", width=" + width + ", height=" + height + 
                ", volume=" + volume + "]";
    }

    @Override
    public int compareTo(Object o) {
        Cube otherCube = (Cube) o;
        if (this.volume < otherCube.volume) {
            return -1;
        }
        if (this.volume == otherCube.volume) {
            if (this.height < otherCube.height) {
                return -1;
            } else {
                return 1;
            }
        }
        if (this.volume > otherCube.volume) {
            return 1;
        }
        return 0;
    }
}