package com.example.datamodels;

public class SudokuCell
{
    // The number marked in the cell, 0 for unmarked ones
    char CellCharacter;

    // How is the number marked in the cell
    CellSource Source;

    // Order in which the marking is suggested by bot, 0 when not N/A
    int Order;

    public SudokuCell(char cellCharacter, CellSource source, int order)
    {
        CellCharacter = cellCharacter;
        Source = source;
        Order = order;
    }

    public SudokuCell(char cellCharacter, CellSource source)
    {
        this(cellCharacter, source, 0);
    }

    public SudokuCell(char cellCharacter)
    {
        this(cellCharacter, CellSource.Initialized, 0);
    }

    public SudokuCell()
    {
        this('0', CellSource.Initialized, 0);
    }
}
