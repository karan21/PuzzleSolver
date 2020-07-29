package com.example.solver;

import com.example.datamodels.IGameState;

public abstract class GameSolver
{
    // TODO: Create method after writing solid class

    public abstract IGameState GetHint(IGameState currentState);
    public abstract IGameState GetSolution(IGameState currentState);
}
