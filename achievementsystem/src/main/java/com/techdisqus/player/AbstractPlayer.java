package com.techdisqus.player;

import com.techdisqus.domain.PlayerProfile;
import com.techdisqus.game.AbstractGame;
import com.techdisqus.game.Game;


public abstract class AbstractPlayer implements  Player, PlayerGameAction {

    protected Game game;
    protected PlayerState playerState;
    protected final PlayerProfile playerProfile;

    public AbstractPlayer(PlayerProfile playerProfile){
        this.playerProfile = playerProfile;
    }


    public long getPlayerId() {
        return playerProfile.getId();
    }

    @Override
    public String getPlayerName() {
        return playerProfile.getName();
    }

    public void start() {
        System.out.println(this +" player is in game");
        game.start();
    }

    public void pause() {
        System.out.println(this + " player paused game");
    }

    public void setGame(AbstractGame game) {
        this.game = game;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }
}
