package com.techdisqus.achievement;

import com.techdisqus.domain.PlayerStatistics;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VeteranAwardTest extends AbstractAchievementTest {

    private Achievement veteranAward = new VeteranAward();

    @Test
    public void testGetName(){
        String name = veteranAward.getName();
        assertEquals("name should be Veteran", "Veteran",name);

    }

    @Test
    public void testGetDescription() {
        String description = veteranAward.getDescription();
        assertEquals("should be awarded on successful completion of 500 games", "awarded on successful completion of 500 games", description);
    }
    @Test
    public void testEligibleForNull(){
        boolean isEligible = veteranAward.isEligible(null);
        assertEquals("expected false as playerStatistics is NULL ",false,isEligible);
    }

    @Test
    public void testEligibleForTrue(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getHistoricalStatisticsBuilder()
                .setTotalNumberOfGamesPlayed(3000);
        boolean isEligible = veteranAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected true as games played greater than 1000 ",true,isEligible);
    }

    @Test
    public void testEligibleForFalse(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getHistoricalStatisticsBuilder().setTotalNumberOfGamesPlayed(200);
        boolean isEligible = veteranAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected true as games played less than 1000 ",false,isEligible);
    }

    @Override
    protected Achievement getAchievement() {
        return veteranAward;
    }
}
