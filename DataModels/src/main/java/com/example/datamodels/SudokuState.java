package com.example.datamodels;

import java.lang.reflect.Array;

public class SudokuState implements IGameState
{
    int Size;
    int CurrentOrder;
    SudokuCell[][] Cells;
    char[] CharacterSet;

    public SudokuState(int size, char[] characterSet)
    {
        Size = size;
        Cells = new SudokuCell[size][size];
        CurrentOrder = 0;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                Cells[i][j] = new SudokuCell();
            }
        }

        CharacterSet = characterSet.clone();
    }

    public SudokuState Create(int size, char[] characterSet)
    {
        return new SudokuState(size, characterSet);
    }

    // TODO: Handle safety
    public void Initialize(char[][] cellCharacters)
    {
        for (int i=0; i < Size; i++)
        {
            for(int j=0; j < Size; j++)
            {
                Cells[i][j] = new SudokuCell(cellCharacters[i][j]);
            }
        }
    }

    public void printBoard()
    {
        for (int i=0; i < Size; i++)
        {
            for(int j=0; j < Size; j++)
            {
                System.out.print(Cells[i][j].CellCharacter);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    // Assumes only solver calls this method
    public void SetCellCharacterAt(int row, int column, char cellCharacter)
    {
        CurrentOrder++;
        Cells[row][column].CellCharacter = cellCharacter;
        Cells[row][column].Source = CellSource.BotSuggested;
        Cells[row][column].Order = CurrentOrder;
    }

    public char GetCellCharacterAt(int row, int column)
    {
        return Cells[row][column].CellCharacter;
    }

    public int GetBoardSize()
    {
        return Size;
    }

    public char[] GetCellCharacterSet()
    {
        return CharacterSet;
    }

    // Add more if needed
}
