package com.techdisqus.rules;

import com.techdisqus.domain.AbstractGamePlayerStatistics;
import com.techdisqus.domain.AbstractPlayerStatistics;

/**
 * Rule definition to check if @{@link com.techdisqus.player.Player} hit percentage is greater than 75%
 * The implementation uses @{@link AbstractGamePlayerStatistics#getNumberOfHits()} and numberOfAttemptedAttacks
 */
public class SharpShooterAchievementRule extends AbstractAchievementRule implements AchievementRule {

    private static final double SHARP_SHOOTER_PERCENT = 0.75d;

    private SharpShooterAchievementRule(){
        super(String.format("Player hit percentage is greater than %s",SHARP_SHOOTER_PERCENT));
    }

    public boolean evaluateRule(AbstractPlayerStatistics playerStatistics) {

        boolean isConditionMet = false;
        if(!isNull(playerStatistics)) {
            AbstractGamePlayerStatistics abstractGamePlayerStatistics = playerStatistics.getCurrentGamePlayerStatistics();
            int numberOfAttemptedAttacks = abstractGamePlayerStatistics.getNumberOfAttemptedAttacks();
            int numberOfHits = abstractGamePlayerStatistics.getNumberOfHits();
            double hitPercentage = (double) numberOfHits / (double) numberOfAttemptedAttacks;
            if (numberOfAttemptedAttacks > 0 && hitPercentage >= SHARP_SHOOTER_PERCENT) {
                isConditionMet = true;
            }
        }
        return isConditionMet;
    }

    private static class SingletonHelper{
        private static final AchievementRule INSTANCE = new SharpShooterAchievementRule();
    }

    public static AchievementRule getAchievementRule(){
        return SingletonHelper.INSTANCE;
    }


}
