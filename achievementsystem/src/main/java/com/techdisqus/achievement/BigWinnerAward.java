package com.techdisqus.achievement;

import com.techdisqus.achievement.manager.AchievementManager;
import com.techdisqus.rules.BigWinnerAchievementRule;

import java.util.Arrays;

/**
 * Big winner @{@link Achievement} is awarded when the player has won more than 200 games including.
 * Refer @{@link BigWinnerAchievementRule}
 */
public class BigWinnerAward extends AbstractAchievement {

    private static final String name = "Big winner";
    private static final String description = "awarded on winning 200 games";
    public BigWinnerAward(){
        super(Arrays.asList(BigWinnerAchievementRule.getAchievementRule()));
        AchievementManager.getInstance().addAchievement(this);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
