package com.techdisqus.rules;

import com.techdisqus.domain.AbstractGamePlayerStatistics;
import com.techdisqus.domain.AbstractPlayerStatistics;

/**
 * Rule definition to check @{@link com.techdisqus.player.Player} has done 500 or more amount of damage done in current game
 * The implementation use @{@link AbstractGamePlayerStatistics#getTotalAmountOfDamageDone()}
 */
public class BruiserAchievementRule extends AbstractAchievementRule implements AchievementRule {

    private static int BRUISER_CONDITION_POINTS = 500;


    private BruiserAchievementRule(){
        super(String.format("Player done %s or more amount of damage done in current game",BRUISER_CONDITION_POINTS));
    }

    public boolean evaluateRule(AbstractPlayerStatistics playerStatistics) {
        boolean isConditionMet = false;
        if(!isNull(playerStatistics)) {
            AbstractGamePlayerStatistics abstractGamePlayerStatistics = playerStatistics.getCurrentGamePlayerStatistics();
            int totalAmountOfDamageDone = abstractGamePlayerStatistics.getTotalAmountOfDamageDone();

            if (totalAmountOfDamageDone >= BRUISER_CONDITION_POINTS) {
                isConditionMet = true;
            }
        }
        return isConditionMet;
    }

    private static class SingletonHelper{
        private static final AchievementRule INSTANCE = new BruiserAchievementRule();
    }

    public static AchievementRule getAchievementCondition(){
        return SingletonHelper.INSTANCE;
    }
}
