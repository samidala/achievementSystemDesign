package com.techdisqus.rules;

import com.techdisqus.domain.AbstractHistoricalStatistics;
import com.techdisqus.domain.AbstractPlayerStatistics;

/**
 * Rule definition to check if @{@link com.techdisqus.player.Player} have won 200 or more games.
 * implementation uses @{@link AbstractHistoricalStatistics#getTotalNumberOfWins()}
 */
public class BigWinnerAchievementRule extends AbstractAchievementRule implements AchievementRule {

    private static final int BIG_WINNER_NUMBER_MATCHES_WIN_CONDITION = 200;

    private BigWinnerAchievementRule(){
        super(String.format("The player should have won %s or more matches",BIG_WINNER_NUMBER_MATCHES_WIN_CONDITION));
    }

    public boolean evaluateRule(AbstractPlayerStatistics playerStatistics) {

        boolean isConditionMet = false;
        if(!isNull(playerStatistics)){
            AbstractHistoricalStatistics abstractHistoricalStatistics = playerStatistics.getHistoricalStatistics();
            int totalNumberOfWins = abstractHistoricalStatistics.getTotalNumberOfWins();
            if(totalNumberOfWins > BIG_WINNER_NUMBER_MATCHES_WIN_CONDITION){
                isConditionMet = true;
            }
        }
        return isConditionMet;
    }

    private static class SingletonHelper{
        private static final AchievementRule INSTANCE = new BigWinnerAchievementRule();
    }

    public static AchievementRule getAchievementRule(){
        return SingletonHelper.INSTANCE;
    }
}
