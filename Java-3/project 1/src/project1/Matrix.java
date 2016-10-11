package project1;

/**
 * A Matrix represents a 2-dimensional matrix defined with having an 
 * integer number of rows and columns, each having a positive or negative double
 * value. Matrices may be added, subtracted, multiplied, divided, and compared
 * in other ways.
 * @author John Gibson
 */
public class Matrix implements Comparable<Matrix> {
    
    private final int ROWS;
    private final int COLS;
    private final double[][] MATRIX;
    
    public Matrix(int rows, int cols) {
        this.ROWS = rows;
        this.COLS = cols;
        MATRIX = new double[rows][cols];
        for (int r = 0; r < rows; r++) 
        {
            for (int c = 0; c < cols; c++) 
            {
                MATRIX[r][c] = 0;
            }
        }
    }
    
    public void setEntry(int row, int col, double entry) 
    {
        MATRIX[row][col] = entry;
    }
    
    /**
     * Adds each value of m.MATRIX to the corresponding value in this.MATRIX
     * @param m the Matrix being added to this
     * @throws project1.Matrix.dimensionMismatch 
     */
    public void add(Matrix m) throws dimensionMismatch 
    {
        if (this.MATRIX.length != m.MATRIX.length || this.MATRIX[0].length != m.MATRIX[0].length) {
            throw new dimensionMismatch(this, m);
        } else {
            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    this.MATRIX[r][c] = this.MATRIX[r][c] + m.MATRIX[r][c];
                }
            }
        }
    }
    
    /**
     * Subtracts each value of m.MATRIX from the corresponding value in this.MATRIX
     * @param m the Matrix being subtracted from this
     * @throws project1.Matrix.dimensionMismatch 
     */
    public void subtract(Matrix m) throws dimensionMismatch 
    {
        if (this.MATRIX.length != m.MATRIX.length || this.MATRIX[0].length != m.MATRIX[0].length) {
            throw new dimensionMismatch(this, m);
        } else {
            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    this.MATRIX[r][c] = this.MATRIX[r][c] - m.MATRIX[r][c];
                }
            }
        }
    }
    
    /**
     * Multiplies each value of m.MATRIX with the corresponding value in this.MATRIX
     * @param m the Matrix being multiplied with this
     * @throws project1.Matrix.dimensionMismatch 
     */
    public void multiply(Matrix m) throws dimensionMismatch 
    {
        if (this.MATRIX.length != m.MATRIX.length || this.MATRIX[0].length != m.MATRIX[0].length) 
        {
            throw new dimensionMismatch(this, m);
        } else 
        {
            for (int r = 0; r < ROWS; r++) 
            {
                for (int c = 0; c < COLS; c++) 
                {
                    this.MATRIX[r][c] = this.MATRIX[r][c] * m.MATRIX[r][c];
                }
            }
        }
    }
    
    /**
     * Divides each value of this.MATRIX by the corresponding value in m.MATRIX
     * @param m the Matrix being multiplied to this
     * @throws project1.Matrix.dimensionMismatch 
     */
    public void divide(Matrix m) throws dimensionMismatch 
    {
        if (this.MATRIX.length != m.MATRIX.length || this.MATRIX[0].length != m.MATRIX[0].length) {
            throw new dimensionMismatch(this, m);
        } else {
            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    this.MATRIX[r][c] = this.MATRIX[r][c] / m.MATRIX[r][c];
                }
            }
        }
    }
    
    /**
     * Returns a boolean value representing whether this is "equal" to m by 
     * checking to see that every value is equal to the value in each 
     * corresponding "slot" in the matrices.
     * @param m the Matrix this is being compared to
     * @return whether the two matrices are equal
     */
    public boolean equals(Matrix m) 
    {
        for (int r = 0; r < ROWS; r++) 
        {
            for (int c = 0; c < COLS; c++) 
            {
                if (this.MATRIX[r][c] != m.MATRIX[r][c])
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Transposes this Matrix by creating and returning a new Matrix with
     * the alternate respective numbers of rows and columns, with the original 
     * value being in (i, j) now being addressed to (j, i) in the new Matrix.
     * @return the new, transposed Matrix
     */
    public Matrix transpose() 
    {
        Matrix m = new Matrix(this.COLS, this.ROWS);
        for (int r = 0; r < ROWS; r++) 
        {
            for (int c = 0; c < COLS; c++) 
            {
                m.setEntry(c, r, this.MATRIX[r][c]);
            }
        }
        return m;
    }

    /**
     * Returns an integer value of -1, 0, or 1, stating whether this Matrix
     * is less than, equal to, or greater than the other Matrix, respectively.
     * @param m the Matrix being compared to
     * @return an integer value of -1, 0, or 1
     */
    @Override
    public int compareTo(Matrix m)
    {        
        int thisSum = 0;
        int mSum = 0;
        
        for (int r = 0; r < this.ROWS; r++) 
        {
            for (int c = 0; c < this.COLS; c++) 
            {
                thisSum += Math.abs(this.MATRIX[r][c]);
            }
        }
        
        for (int r = 0; r < m.ROWS; r++) 
        {
            for (int c = 0; c < m.COLS; c++) 
            {
                mSum += Math.abs(m.MATRIX[r][c]);
            }
        }
        
        if (thisSum > mSum) {
            return 1;
        } else if (thisSum == mSum) {
            return 0;
        } else {
            return -1;
        }
    }
    
    /**
     * Throws an exception if two Matrices being operated on are not of equal
     * dimensions.
     */
    class dimensionMismatch extends Exception 
    {
        public dimensionMismatch(Matrix t, Matrix m) 
        {
            System.out.println("Dimensions of matrices do not match.\n"
                    + "This matrix: " + t.MATRIX.length  + "x" + 
                    t.MATRIX[0].length + "\nOther matrix: " + m.MATRIX.length + 
                    "x" + m.MATRIX[0].length);
        }
    }
    
}