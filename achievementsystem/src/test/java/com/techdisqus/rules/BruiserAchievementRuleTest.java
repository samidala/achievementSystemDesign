package com.techdisqus.rules;

import com.techdisqus.domain.PlayerStatistics;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BruiserAchievementRuleTest extends AbstractRuleTest {

    private static AchievementRule bruiserAchievementRule = BruiserAchievementRule.getAchievementCondition();

    @Test
    public void testIsEligibleOnNull(){
        boolean result = bruiserAchievementRule.evaluateRule(null);
        assertEquals("the result should be false",false,result);
    }

    @Test
    public void testIsEligibleForTrue(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder().setTotalAmountOfDamageDone(1000);
        boolean result = bruiserAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be true",true,result);
    }



    @Test
    public void testIsEligibleForFalse(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder().setTotalAmountOfDamageDone(200);
        boolean result = bruiserAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be true",false,result);
    }

    @Override
    protected AchievementRule getAchievementRule() {
        return bruiserAchievementRule;
    }
}
