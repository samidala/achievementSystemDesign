package com.techdisqus.game;

public interface Game<T> {

    void start();

    GameState getGameState();

    T getWinner();

    T getFar();

    T getAgainst();
}
