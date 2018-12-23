package com.techdisqus.game;

public  abstract  class AbstractGame implements FictionGame<Team> {

    protected final Team farTeam;
    protected final Team againstTeam;
    private Team winner;
    private GameState gameState;

    public AbstractGame(Team farTeam,Team againstTeam) {
        isTeamSizeMatch(farTeam, againstTeam);
        this.farTeam = farTeam;
        this.againstTeam = againstTeam;
    }

    public void start() {
        System.out.println("game started");
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    //this is convenience method
    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public Team getWinner(){
        return winner;
    }

    @Override
    public Object getFar() {
        return farTeam;
    }

    @Override
    public Object getAgainst() {
        return againstTeam;
    }

    protected abstract boolean isTeamSizeMatch(Team farTeam, Team againstTeam);
}
