package com.techdisqus.achievement;

import com.techdisqus.domain.PlayerStatistics;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BigWinnerAwardTest extends AbstractAchievementTest {

    private Achievement bigWinnerAward = new BigWinnerAward();

    @Test
    public void testGetName(){
        String name = bigWinnerAward.getName();
        assertEquals("name should be Big winner", "Big winner",name);

    }

    @Test
    public void testGetDescription() {
        String description = bigWinnerAward.getDescription();
        assertEquals("should be awarded on winning 200 games", "awarded on winning 200 games", description);
    }
    @Test
    public void testEligibleForNull(){
        boolean isEligible = bigWinnerAward.isEligible(null);
        assertEquals("expected false as playerStatistics is NULL ",false,isEligible);
    }

    @Test
    public void testEligibleForTrue(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getHistoricalStatisticsBuilder()
                                .setTotalNumberOfWins(201)
                                .setTotalNumberOfGamesPlayed(300);
        boolean isEligible = bigWinnerAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected true as wins greater than 200 ",true,isEligible);
    }

    @Test
    public void testEligibleForFalse(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getHistoricalStatisticsBuilder()
                                .setTotalNumberOfGamesPlayed(300)
                                .setTotalNumberOfWins(199);
        boolean isEligible = bigWinnerAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected true as wins less than 200 ",false,isEligible);
    }

    @Override
    protected Achievement getAchievement() {
        return bigWinnerAward;
    }
}
