package com.techdisqus.achievement;


import com.techdisqus.achievement.manager.AchievementManager;
import com.techdisqus.rules.SharpShooterAchievementRule;

import java.util.Arrays;

/**
 * awarded on landing 75% attacks
 * Refer @{@link SharpShooterAchievementRule}
 */
public class SharpShooterAward extends AbstractAchievement {
    private static final String name = "Sharp shooter";
    private static final String description = "awarded on landing 75% attacks";

    public SharpShooterAward(){
        super(Arrays.asList(SharpShooterAchievementRule.getAchievementRule()));
        AchievementManager.getInstance().addAchievement(this);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
