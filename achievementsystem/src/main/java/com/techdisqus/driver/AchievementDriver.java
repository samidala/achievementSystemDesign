package com.techdisqus.driver;

import com.techdisqus.achievement.BigWinnerAward;
import com.techdisqus.achievement.BruiserAward;
import com.techdisqus.achievement.FastKillerAward;
import com.techdisqus.achievement.SharpShooterAward;
import com.techdisqus.achievement.VeteranAward;
import com.techdisqus.domain.GamePlayerStatistics;
import com.techdisqus.domain.HistoricalStatistics;
import com.techdisqus.domain.PlayerProfile;
import com.techdisqus.domain.PlayerStatistics;
import com.techdisqus.events.GameCompletionEvent;
import com.techdisqus.events.GameCompletionEventImpl;
import com.techdisqus.exception.ValidationException;
import com.techdisqus.game.FictionGameImpl;
import com.techdisqus.player.AbstractPlayer;
import com.techdisqus.player.FictionGamePlayer;
import com.techdisqus.game.Game;
import com.techdisqus.player.Player;
import com.techdisqus.game.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * this can be thought as end class in Fiction game
 */
public class AchievementDriver {

    public static void main(String[] args) throws Exception {

        init();

        Game game = setupGame();

        List<PlayerStatistics> farTeamPlayerStatistics = getIndividualPlayerStatistics((Team) game.getFar());

        List<PlayerStatistics> againstTeamPlayerStatistics = getIndividualPlayerStatistics((Team) game.getAgainst());

        List<PlayerStatistics> currentGamePlayerStatistics = new ArrayList<>(farTeamPlayerStatistics);
        currentGamePlayerStatistics.addAll(againstTeamPlayerStatistics);


        GameCompletionEvent gameCompletionEvent = new GameCompletionEventImpl();
        gameCompletionEvent.onGameCompletion(currentGamePlayerStatistics);


    }

    /**
     *
     * @return @{@link Game}
     */
    private static Game setupGame(){
           return new FictionGameImpl(getTeam(),getTeam());
    }

    /**
     *
     * @return @{@link Team}
     */
    private static Team getTeam(){

        List<Player> teamPlayers = new ArrayList<>();
        teamPlayers.add(getPlayer());
        teamPlayers.add(getPlayer());
        teamPlayers.add(getPlayer());

        return new Team(teamPlayers);

    }

    /**
     *
     * @return @{@link Player}
     */
    protected static Player getPlayer(){
        return new FictionGamePlayer(getPlayerProfile());
    }

    private static final Random RANDOM = new Random(Long.MAX_VALUE);

    /**
     *
     * @return @{@link PlayerProfile}
     */
    protected static PlayerProfile getPlayerProfile(){
        long id = RANDOM.nextLong();
        return new PlayerProfile("name-"+id,id);
    }

    /**
     *
     * @param player
     * @return compiles and return @{@link PlayerStatistics}
     */
    private static PlayerStatistics preparePlayerStatistics(Player player){

        GamePlayerStatistics.GamePlayerStatisticsBuilder gamePlayerStatisticsBuilder =
                new GamePlayerStatistics.GamePlayerStatisticsBuilder();

        gamePlayerStatisticsBuilder.setTimeTakenToKillsOpponent(30)
        .setNumberOfAttemptedAttacks(10)
        .setTotalAmountOfDamageDone(1000)
        .setNumberOfHits(9)
        .setNumberOfKills(6)
        .setTotalNumberOfSecondsPlayed(300);

        PlayerProfile playerProfile = ((AbstractPlayer) player).getPlayerProfile();
        PlayerStatistics playerStatistics =
                new PlayerStatistics(playerProfile, gamePlayerStatisticsBuilder.buildGamePlayerStatistics(),
                        getPlayerHistoricalStatistics(playerProfile));
        return playerStatistics;
    }

    /**
     *
     * @param playerProfile
     * @return compiles and return @{@link HistoricalStatistics}
     */
    private static HistoricalStatistics getPlayerHistoricalStatistics(PlayerProfile playerProfile){
        if(playerProfile == null){
            throw new ValidationException("Invalid player");
        }
        //logic to fetch historical statistics
        return new HistoricalStatistics.HistoricalStatisticsBuilder().buildHistoricalStatistics();
    }

    /**
     *
     * @param team
     * @return @{@link List} of @{@link PlayerStatistics}
     */
    private static List<PlayerStatistics> getIndividualPlayerStatistics(Team team){
        return team
                .getPlayers()
                .stream().map(AchievementDriver::preparePlayerStatistics)
                .collect(Collectors.toList());
    }

    /**
     * init the awards.
     * this is required to register the awards with AchievementManager
     */
    private static void init(){
        new BigWinnerAward();
        new BruiserAward();
        new FastKillerAward();
        new SharpShooterAward();
        new VeteranAward();
    }
}
