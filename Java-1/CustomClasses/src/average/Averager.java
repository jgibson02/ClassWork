package average;

/**
 * This class can be used to compute the average of a given list of numbers.
 * 
 * @author jhg95693
 */
public class Averager {

    private double sum; // sum of all values
    private int count; // number of values
    
    /**
     * Initializes this object to represent an empty list of values.
     */
    public Averager() {
        sum = 0.0;
        count = 0;
    }
    
    /**
     * Adds a value to be used in computing an average.
     * @param valueToAdd 
     */
    public void addValue(double valueToAdd) {
        sum += valueToAdd;
        count++;
    }
    
    /**
     * Computes the average of all values given.
     * @return the average
     */
    public double getAverage() {
        return sum / count;
    }
}