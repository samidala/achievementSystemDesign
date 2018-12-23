package com.techdisqus.domain;

import com.techdisqus.AbstractTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PlayerStatisticsTest extends AbstractTest {

    private PlayerProfile playerProfile = getPlayerProfile();
    private GamePlayerStatistics gamePlayerStatistics = new GamePlayerStatistics.GamePlayerStatisticsBuilder().buildGamePlayerStatistics();
    private HistoricalStatistics historicalStatistics = new HistoricalStatistics.HistoricalStatisticsBuilder().buildHistoricalStatistics();

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void testPlayerStatisticsCreationOnNullPlayer(){
        expected.expect(RuntimeException.class);
        new PlayerStatistics(null,gamePlayerStatistics,null);
    }
    @Test
    public void testPlayerStatisticsCreationOnNullGamePlayerStatistics(){
        expected.expect(RuntimeException.class);
        new PlayerStatistics(getPlayerProfile(),null,null);
    }

    @Test
    public void testPlayerStatisticsOnValidObject(){

        PlayerStatistics playerStatistics = new PlayerStatistics(playerProfile,gamePlayerStatistics,historicalStatistics);
        assertEquals(playerProfile,playerStatistics.getPlayerProfile());
        assertEquals(gamePlayerStatistics,playerStatistics.getCurrentGamePlayerStatistics());
        assertEquals(historicalStatistics,playerStatistics.getHistoricalStatistics());

    }
}
