package com.techdisqus.game;



public class FictionGameImpl extends AbstractGame{

    public FictionGameImpl(Team farTeam, Team againstTeam){
        super(farTeam,againstTeam);

    }
    protected boolean isTeamSizeMatch(Team farTeam, Team againstTeam){
        if(farTeam.getPlayers().size() != againstTeam.getPlayers().size()){
            throw new RuntimeException("the team size should match");
        }
        return  true;
    }

}
