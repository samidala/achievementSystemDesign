package com.techdisqus.achievement;

import com.techdisqus.domain.PlayerStatistics;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FastKillerAwardTest extends AbstractAchievementTest {

    private Achievement fastKillerAward = new FastKillerAward();

    @Test
    public void testGetName(){
        String name = fastKillerAward.getName();
        assertEquals("should be Fast Killer", "Fast Killer",name);

    }

    @Test
    public void testGetDescription() {
        String description = fastKillerAward.getDescription();
        assertEquals("should be Killed the opponent within 60 seconds and damage done more than 75%", "Killed the opponent within 60 seconds and damage done more than 75%", description);
    }
    @Test
    public void testEligibleForNull(){
        boolean isEligible = fastKillerAward.isEligible(null);
        assertEquals("expected false as playerStatistics is NULL ",false,isEligible);
    }

    @Test
    public void testEligibleForTrueOnHitPercentageAndDamageDoneMatch(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder()
                               .setNumberOfAttemptedAttacks(12)
                               .setNumberOfHits(10)
                               .setTimeTakenToKillsOpponent(20);

        boolean isEligible = fastKillerAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected true as total amount of damage done above 500 and hit percentage is above 80%",true,isEligible);
    }

    @Test
    public void testEligibleForFalseOnHitPercentageLessThanEighty(){

        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder()
                                .setNumberOfAttemptedAttacks(10)
                                .setNumberOfHits(2)
                                .setTimeTakenToKillsOpponent(30);

        boolean isEligible = fastKillerAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected false as total amount of damage done above 500 but hit percentage is less than 80%",false,isEligible);
    }


    @Test
    public void testEligibleForFalseOnTimeTakenToKillOpponentAboveSixtySeconds(){

        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder()
                                .setNumberOfAttemptedAttacks(10)
                                .setNumberOfHits(2)
                                .setTimeTakenToKillsOpponent(80);

        boolean isEligible = fastKillerAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected false as total amount of damage done above 500 but hit percentage is less than 80%",false,isEligible);
    }

    @Override
    protected Achievement getAchievement() {
        return fastKillerAward;
    }
    protected int getExpectedCount(){
        return 2;
    }
}
