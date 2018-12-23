package com.techdisqus.player;

import com.techdisqus.domain.PlayerProfile;

public class FictionGamePlayer extends AbstractPlayer {


    public FictionGamePlayer(PlayerProfile playerProfile) {
        super(playerProfile);
    }

    public void attack(Player toPlayer) {
        System.out.println(this.getPlayerId() + " attacking "+ toPlayer.getPlayerId());
    }

    public void escape(Player fromPlayer) {
        System.out.println(this.getPlayerId() + " escped "+ fromPlayer.getPlayerId());
    }


    public void setPlayerState() {
        //logic to derive player state
    }


}
