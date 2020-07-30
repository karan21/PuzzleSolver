package com.example.solver;

import com.example.datamodels.SudokuState;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void sudokuSolver_isCorrect()
    {
        SudokuState currentState = new SudokuState(9 , new char[]{'1','2','3','4','5','6','7','8','9'});
        char[][] grid =
                { {'3', '0', '6', '5', '0', '8', '4', '0', '0'},
                {'5', '2', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '8', '7', '0', '0', '0', '0', '3', '1'},
                {'0', '0', '3', '0', '1', '0', '0', '8', '0'},
                {'9', '0', '0', '8', '6', '3', '0', '0', '5'},
                {'0', '5', '0', '0', '9', '0', '6', '0', '0'},
                {'1', '3', '0', '0', '0', '0', '2', '5', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '7', '4'},
                {'0', '0', '5', '2', '0', '6', '3', '0', '0'}};
        currentState.Initialize(grid);
        SudokuSolver solver = new SudokuSolver();
        if(solver.GetSolution(currentState) != null)
        {
            currentState.printBoard();
        }
        else
        {
            System.out.println("Board doesnt have solution");
        }
    }
}