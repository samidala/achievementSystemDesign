package com.techdisqus.game;

import com.techdisqus.player.Player;

import java.util.Collections;
import java.util.List;

public class Team {

    private  final List<Player> players ;

    public Team(final List<Player> players){
        if(players == null || players.size() == 0){
            throw  new RuntimeException("Invalid number of players");
        }
        if(players.size() < 3 || players.size() > 5){
            throw  new RuntimeException("players count should be between 3 and 5");
        }
        this.players = players;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

}
