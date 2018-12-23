package com.techdisqus.rules;

import com.techdisqus.domain.AbstractHistoricalStatistics;
import com.techdisqus.domain.AbstractPlayerStatistics;


/**
 * Rule definition to check if @{@link com.techdisqus.player.Player} played more than 1000 games.
 * The implementation use @{@link AbstractHistoricalStatistics#getTotalNumberOfGamesPlayed()}
 */

public class VeteranAchievementRule extends AbstractAchievementRule implements AchievementRule {

    private static final int VETERAN_PLAYER_NUMBER_OF_MATCHES_CONDITION = 1000;
    private VeteranAchievementRule(){
        super(String.format("Player played more than %s games",VETERAN_PLAYER_NUMBER_OF_MATCHES_CONDITION));
    }

    public boolean evaluateRule(AbstractPlayerStatistics playerStatistics) {
        boolean isConditionMet = false;
        if(!isNull(playerStatistics)) {
            AbstractHistoricalStatistics abstractHistoricalStatistics = playerStatistics.getHistoricalStatistics();
            int totalNumberOfGamesPlayed = abstractHistoricalStatistics.getTotalNumberOfGamesPlayed();
            if (totalNumberOfGamesPlayed > VETERAN_PLAYER_NUMBER_OF_MATCHES_CONDITION) {
                isConditionMet = true;
            }
        }
        return isConditionMet;
    }


    private static class SingletonHelper{
        private static final AchievementRule INSTANCE = new VeteranAchievementRule();
    }

    public static AchievementRule getAchievementRule(){
        return SingletonHelper.INSTANCE;
    }
}
