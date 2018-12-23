package com.techdisqus.rules;

import com.techdisqus.domain.PlayerStatistics;
import static org.junit.Assert.assertEquals;
import org.junit.Test;




public class BigWinnerAchievementRuleTest extends AbstractRuleTest {

    private static AchievementRule bigWinnerAchievementRule = BigWinnerAchievementRule.getAchievementRule();

    @Test
    public void testIsEligibleOnNull(){
        boolean result = bigWinnerAchievementRule.evaluateRule(null);
        assertEquals("the result should be false",false,result);
    }

    @Test
    public void testIsEligibleForTrue(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getHistoricalStatisticsBuilder()
                .setTotalNumberOfWins(300)
                .setTotalNumberOfGamesPlayed(500);
        boolean result = bigWinnerAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be true",true,result);
    }



    @Test
    public void testIsEligibleForFalse(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getHistoricalStatisticsBuilder()
                .setTotalNumberOfWins(100)
                .setTotalNumberOfGamesPlayed(300);
        boolean result = bigWinnerAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be false",false,result);
    }

    @Override
    protected AchievementRule getAchievementRule() {
        return bigWinnerAchievementRule;
    }
}
