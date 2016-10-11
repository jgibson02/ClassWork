/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author John
 */
public class SudokuSolver {
    private int[][] grid;
    private final int[][] streams;
    private final int gridSize;
    
    public SudokuSolver(int size) {
        gridSize = size;
        streams = new int[size][size];
    }
    
    public int[][] solvePuzzle(int[][] input, int[][] streams) {
        int[][] solvedPuzzle = new int[input.length][input.length];
        return solvedPuzzle;
    }
    
}
