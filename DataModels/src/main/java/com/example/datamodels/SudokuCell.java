package com.example.datamodels;

public class SudokuCell {
    // The number marked in the cell, 0 for unmarked ones
    int Number;

    // How is the number marked in the cell
    CellSource Source;

    // Order in which the marking is suggested by bot, 0 when not N/A
    int Order;

    public SudokuCell(int number, CellSource source, int order){
        Number = number;
        Source = source;
        Order = order;
    }

    public SudokuCell(int number, CellSource source){
        this(number, source, 0);
    }

    public SudokuCell(int number){
        this(number, CellSource.Initialized, 0);
    }

    public SudokuCell(){
        this(0, CellSource.Initialized, 0);
    }
}
