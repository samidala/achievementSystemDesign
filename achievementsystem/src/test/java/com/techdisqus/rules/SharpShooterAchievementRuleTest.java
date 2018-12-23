package com.techdisqus.rules;


import com.techdisqus.domain.PlayerStatistics;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SharpShooterAchievementRuleTest extends AbstractRuleTest {

    private static AchievementRule sharpShooterAchievementRule = SharpShooterAchievementRule.getAchievementRule();

    @Test
    public void testIsEligibleOnNull(){
        boolean result = sharpShooterAchievementRule.evaluateRule(null);
        assertEquals("the result should be false",false,result);
    }

    @Test
    public void testIsEligibleForTrue(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder()
                .setNumberOfAttemptedAttacks(10)
                .setNumberOfHits(10);
        boolean result = sharpShooterAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be true",true,result);
    }



    @Test
    public void testIsEligibleForFalseOnHitCountIsTwo(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder()
                                .setNumberOfAttemptedAttacks(10)
                                .setNumberOfHits(2);
        boolean result = sharpShooterAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be false",false,result);
    }
    @Test
    public void testIsEligibleForTrueOnHitCountIsEight(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder()
                               .setNumberOfAttemptedAttacks(10)
                               .setNumberOfHits(8);
        boolean result = sharpShooterAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be true",true,result);
    }

    @Override
    protected AchievementRule getAchievementRule() {
        return sharpShooterAchievementRule;
    }
}
