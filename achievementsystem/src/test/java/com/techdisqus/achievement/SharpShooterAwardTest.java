package com.techdisqus.achievement;

import com.techdisqus.domain.PlayerStatistics;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SharpShooterAwardTest extends AbstractAchievementTest {

    private Achievement sharpShooterAward = new SharpShooterAward();

    @Test
    public void testGetName(){
        String name = sharpShooterAward.getName();
        assertEquals("should be Sharp shooter", "Sharp shooter",name);

    }

    @Test
    public void testGetDescription() {
        String description = sharpShooterAward.getDescription();
        assertEquals("should be awarded on landing 75% attacks", "awarded on landing 75% attacks", description);
    }
    @Test
    public void testEligibleForNull(){
        boolean isEligible = sharpShooterAward.isEligible(null);
        assertEquals("expected false as playerStatistics is NULL ",false,isEligible);
    }

    @Test
    public void testEligibleForTrue(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder()
                                .setNumberOfAttemptedAttacks(10)
                                .setNumberOfHits(10);

        boolean isEligible = sharpShooterAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected true as number of attempts equals to number of hits",true,isEligible);
    }

    @Test
    public void testEligibleForFalseOnNumberOfHitsAreTwo(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder()
                                .setNumberOfAttemptedAttacks(10)
                                .setNumberOfHits(2);
        boolean isEligible = sharpShooterAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected false as number of hits are 2/10",false,isEligible);
    }

    @Test
    public void testEligibleForFalseOnNumberOfHitsAreEight(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder()
                .setNumberOfAttemptedAttacks(10)
                .setNumberOfHits(8);
        boolean isEligible = sharpShooterAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected true as number of hits are 8/10 ",true,isEligible);
    }

    @Override
    protected Achievement getAchievement() {
        return sharpShooterAward;
    }
}
