package com.techdisqus.rules;

import com.techdisqus.domain.AbstractGamePlayerStatistics;
import com.techdisqus.domain.AbstractPlayerStatistics;

/**
 * Rule definition to check if @{@link com.techdisqus.player.Player} kills a opponent in less then 60 seconds.
 * The implementation uses @{@link AbstractGamePlayerStatistics#getTimeTakenToKillsOpponent()}
 */
public class QuickKillerAchievementRule extends AbstractAchievementRule implements AchievementRule {

    private static final long TIME_FLAG_FOR_KILLING_OPPONENT_IN_SECONDS = 60l;

    private QuickKillerAchievementRule(){

        super(String.format("Player kills a opponent in less then %s seconds",TIME_FLAG_FOR_KILLING_OPPONENT_IN_SECONDS));
    }

    @Override
    public boolean evaluateRule(AbstractPlayerStatistics playerStatistics) {
        boolean isEligible = false;
        if(!isNull(playerStatistics)) {
            AbstractGamePlayerStatistics abstractGamePlayerStatistics = playerStatistics.getCurrentGamePlayerStatistics();
            long timeTakenToKillOpponent = abstractGamePlayerStatistics.getTimeTakenToKillsOpponent();

            if (timeTakenToKillOpponent <= TIME_FLAG_FOR_KILLING_OPPONENT_IN_SECONDS) {
                isEligible = true;
            }
        }
        return isEligible;
    }

    private static class SingletonHelper{
        private static final AchievementRule INSTANCE = new QuickKillerAchievementRule();
    }

    public static AchievementRule getAchievementRule(){
        return SingletonHelper.INSTANCE;
    }
}
