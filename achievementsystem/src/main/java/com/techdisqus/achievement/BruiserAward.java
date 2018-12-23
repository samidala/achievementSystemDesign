package com.techdisqus.achievement;

import com.techdisqus.achievement.manager.AchievementManager;
import com.techdisqus.rules.BruiserAchievementRule;

import java.util.Arrays;

/**
 * Awarded on earning 500 points of damage done in a game.
 * Refer {@link BruiserAchievementRule}
 */
public class BruiserAward extends AbstractAchievement {

    private static final String name = "Bruiser";
    private static final String description = "Awarded on earning 500 points of damage done in a game";
    public BruiserAward(){
        super(Arrays.asList(BruiserAchievementRule.getAchievementCondition()));
        AchievementManager.getInstance().addAchievement(this);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
