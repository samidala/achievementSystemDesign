package com.techdisqus.rules;

import com.techdisqus.domain.PlayerStatistics;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuickKillerAchievementRuleTest extends AbstractRuleTest {

    private static AchievementRule quickKillerAchievementRule = QuickKillerAchievementRule.getAchievementRule();

    @Test
    public void testIsEligibleOnNull(){
        boolean result = quickKillerAchievementRule.evaluateRule(null);
        assertEquals("the result should be false",false,result);
    }

    @Test
    public void testIsEligibleForTrue(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder().setTimeTakenToKillsOpponent(30);
        boolean result = quickKillerAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be true",true,result);
    }



    @Test
    public void testIsEligibleForFalse(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();
        playerStatisticsBuilder.getGamePlayerStatisticsBuilder().setTimeTakenToKillsOpponent(80);
        boolean result = quickKillerAchievementRule.evaluateRule(playerStatisticsBuilder.build());
        assertEquals("the result should be false",false,result);
    }

    @Override
    protected AchievementRule getAchievementRule() {
        return quickKillerAchievementRule;
    }
}
