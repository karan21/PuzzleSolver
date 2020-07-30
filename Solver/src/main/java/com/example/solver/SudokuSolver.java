package com.example.solver;

import com.example.datamodels.IGameState;
import com.example.datamodels.SudokuState;

public class SudokuSolver implements IGameState
{
    private SudokuState sudokuSolutionState;

    public SudokuSolver()
    {
        sudokuSolutionState = null;
    }

    /* A Backtracking program in Java to solve Sudoku problem */
    private  boolean isSafeToSetCharacter(SudokuState sudokuState, int row, int col, int boardSize, char character)
    {
        // row has the unique (row-clash)
        for (int d = 0; d < boardSize; d++)
        {
            // if the number we are trying to
            // place is already present in
            // that row, return false;
            if ( sudokuState.GetCellCharacterAt(row , d) == character)
            {
                return false;
            }
        }

        // column has the unique numbers (column-clash)
        for (int r = 0; r < boardSize; r++)
        {
            // if the number we are trying to
            // place is already present in
            // that column, return false;

            if (sudokuState.GetCellCharacterAt(r,col) == character)
            {
                return false;
            }
        }

        // corresponding square has
        // unique number (box-clash)
        int sqrt = (int) Math.sqrt(boardSize);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart; d < boxColStart + sqrt; d++)
            {
                if (sudokuState.GetCellCharacterAt(r,d) == character)
                {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    private boolean solveSudoku(SudokuState sudokuState)
    {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        int boardSize = sudokuState.GetBoardSize();
        char[] characterSet = sudokuState.GetCellCharacterSet();

        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                if (sudokuState.GetCellCharacterAt(i,j) == '0')
                {
                    row = i;
                    col = j;

                    // we still have some remaining missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }

            if (!isEmpty)
            {
                break;
            }
        }

        // no empty space left
        if (isEmpty)
        {
            return true;
        }

        // else for each-row backtrack
        for (char character : characterSet)
        {
            if ( isSafeToSetCharacter(sudokuState, row, col, boardSize, character))
            {
                sudokuState.SetCellCharacterAt(row, col, character);
                if (solveSudoku(sudokuState))
                {
                    // print(board, n);
                    return true;
                }
                else
                {
                    // replace it
                    sudokuState.SetCellCharacterAt(row,col,'0');
                }
            }
        }

        return false;
    }

    public char GetHint(IGameState currentState, int row, int col)
    {
        if(sudokuSolutionState == null)
        {
            if( GetSolution(currentState) == null )
            {
                return '0';
            }
        }
        return sudokuSolutionState.GetCellCharacterAt(row, col);
    }

    public IGameState GetSolution(IGameState currentState)
    {
        if( (currentState instanceof SudokuState) == false)
        {
            // base condition check to prevent this illegal access
            return null;
        }

        SudokuState sudokuState = (SudokuState) currentState;
        if( solveSudoku( sudokuState) )
        {
            sudokuSolutionState = sudokuState;
            return currentState;
        }
        return null;
    }
}
