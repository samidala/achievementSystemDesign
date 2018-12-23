package com.techdisqus;

import com.techdisqus.domain.GamePlayerStatistics;
import com.techdisqus.domain.HistoricalStatistics;
import com.techdisqus.domain.PlayerProfile;
import com.techdisqus.domain.PlayerStatistics;

import java.util.Random;

/**
 * abstract test class. Here the convenience methods for creating objects.
 */
public abstract class AbstractTest {

    protected PlayerStatistics.PlayerStatisticsBuilder getPlayerStatisticsBuilder(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = new PlayerStatistics.PlayerStatisticsBuilder(getPlayerProfile());
        playerStatisticsBuilder.setHistoricalStatisticsBuilder(getHistoricalStatisticsBuilder());
        playerStatisticsBuilder.setGamePlayerStatisticsBuilder(getGamePlayerStatisticsBuilder());
        return playerStatisticsBuilder;
    }

    private static final Random RANDOM = new Random(Long.MAX_VALUE);

    protected PlayerProfile getPlayerProfile(){
        long id = RANDOM.nextLong();
        return new PlayerProfile("name-"+id,id);
    }

    protected GamePlayerStatistics.GamePlayerStatisticsBuilder getGamePlayerStatisticsBuilder(){

        GamePlayerStatistics.GamePlayerStatisticsBuilder gamePlayerStatisticsBuilder = new GamePlayerStatistics.GamePlayerStatisticsBuilder();

        return gamePlayerStatisticsBuilder;
    }

    protected HistoricalStatistics.HistoricalStatisticsBuilder getHistoricalStatisticsBuilder(){
        return new HistoricalStatistics.HistoricalStatisticsBuilder();
    }

}
