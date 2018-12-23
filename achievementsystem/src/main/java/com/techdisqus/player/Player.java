package com.techdisqus.player;

public interface Player {

    long getPlayerId();
    String getPlayerName();
    void attack(Player toPlayer);
    void escape(Player fromPlayer);
    PlayerState getPlayerState();

}
