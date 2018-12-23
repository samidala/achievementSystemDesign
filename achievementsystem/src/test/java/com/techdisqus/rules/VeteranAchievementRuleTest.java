package com.techdisqus.rules;



import com.techdisqus.domain.PlayerStatistics;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class VeteranAchievementRuleTest extends AbstractRuleTest {

    private static AchievementRule veteranAchievementRule = VeteranAchievementRule.getAchievementRule();

    @Test
    public void testIsEligibleOnNull(){
        boolean result = veteranAchievementRule.evaluateRule(null);
        assertEquals("the result should be false",false,result);
    }

    @Test
    public void testIsEligibleForTrue(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getHistoricalStatisticsBuilder().setTotalNumberOfGamesPlayed(2000);

        boolean result = veteranAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be true",true,result);
    }



    @Test
    public void testIsEligibleForFalse(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getHistoricalStatisticsBuilder().setTotalNumberOfGamesPlayed(400);

        boolean result = veteranAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be false",false,result);
    }

    @Override
    protected AchievementRule getAchievementRule() {
        return veteranAchievementRule;
    }
}
