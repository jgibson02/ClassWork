package review;

import java.util.Comparator;

/**
 * 
 * @author jhg95693
 */
public class NewOrdering implements Comparator<Fraction>
{

    @Override
    public int compare(Fraction f1, Fraction f2)
    {
        if (f1.toDecimal()>f2.toDecimal())
            return -1;
        else if (f1.equals(f2))
            return 0;
        else
            return 1;
    }
    
}
