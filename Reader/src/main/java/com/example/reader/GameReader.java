package com.example.reader;

import android.graphics.Bitmap;

import com.example.datamodels.IGameState;

public abstract class GameReader
{
    public static GameReader Create(){
        return new OpenCVSudokuReader();
    }

    public abstract IGameState ReadImage(Bitmap bitmap);
}
