package com.techdisqus.achievement;

import com.techdisqus.domain.PlayerStatistics;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BruiserAwardTest extends AbstractAchievementTest {

    private Achievement bruiserAward = new BruiserAward();

    @Test
    public void testGetName(){
        String name = bruiserAward.getName();
        assertEquals("should be Bruiser", "Bruiser",name);

    }

    @Test
    public void testGetDescription() {
        String description = bruiserAward.getDescription();
        assertEquals("should be Awarded on earning 500 points of damage done in a game", "Awarded on earning 500 points of damage done in a game", description);
    }
    @Test
    public void testEligibleForNull(){
        boolean isEligible = bruiserAward.isEligible(null);
        assertEquals("expected false as playerStatistics is NULL ",false,isEligible);
    }

    @Test
    public void testEligibleForTrue(){

        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder().setNumberOfAttemptedAttacks(11)
                .setNumberOfHits(10)
                .setTotalAmountOfDamageDone(600);

        boolean isEligible = bruiserAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected true as total amount of damage done above 500",true,isEligible);
    }

    @Test
    public void testEligibleForFalse(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder()
                            .setNumberOfAttemptedAttacks(11)
                            .setNumberOfHits(10);

        boolean isEligible = bruiserAward.isEligible(playerStatisticsBuilder.build());
        assertEquals("expected true as total amount of damage done lesser than 500",false,isEligible);
    }

    @Override
    protected Achievement getAchievement() {
        return bruiserAward;
    }
}
