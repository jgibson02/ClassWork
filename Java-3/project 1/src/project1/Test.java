/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author John Gibson
 */
public class Test
{
    public static void main(String[] args) throws Matrix.dimensionMismatch 
    {
        Matrix m = new Matrix(4, 5);
        Matrix n = new Matrix(4, 5);
        m.setEntry(0, 2, 4);
        n.setEntry(0, 2, 2);
        m.subtract(n);
        m.transpose();
        n.transpose();
        System.out.println(m.compareTo(n));
        System.out.println(m);
        System.out.println(n);
        
        Matrix[] mArray = new Matrix[5];
        mArray[0] = new Matrix(4, 5);
        mArray[1] = new Matrix(3, 2);
        mArray[2] = new Matrix(4, 3);
        mArray[3] = new Matrix(1, 4);
        mArray[4] = new Matrix(5, 2);
        Arrays.sort(mArray);
        Arrays.sort(mArray, Collections.reverseOrder());
    }
}
