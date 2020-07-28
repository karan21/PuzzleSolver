package com.example.datamodels;

import java.lang.reflect.Array;

public class SudokuState implements IGameState {
    SudokuCell[][] Cells;
    int CurrentOrder;

    private SudokuState(int size){
        Cells = new SudokuCell[size][size];
        CurrentOrder = 0;
        for (int i=0; i<Cells.length; i++){
            for(int j=0; j<Cells[i].length; j++){
                Cells[i][j] = new SudokuCell();
            }
        }
    }

    public static SudokuState Create(int size){
        return new SudokuState(size);
    }

    // TODO: Handle safety
    public void Initialize(int[][] numbers){
        for (int i=0; i<Cells.length; i++){
            for(int j=0; j<Cells[i].length; j++){
                Cells[i][j] = new SudokuCell(numbers[i][j]);
            }
        }
    }

    // Assumes only solver calls this method
    public void Insert(int row, int column, int number){
        CurrentOrder++;
        Cells[row][column].Number = number;
        Cells[row][column].Source = CellSource.BotSuggested;
        Cells[row][column].Order = CurrentOrder;
    }

    public int GetNumberAt(int row, int column){
        return Cells[row][column].Number;
    }

    // Add more if needed
}
