package com.techdisqus.achievement;

import com.techdisqus.achievement.manager.AchievementManager;
import com.techdisqus.rules.QuickKillerAchievementRule;
import com.techdisqus.rules.SharpShooterAchievementRule;

import java.util.Arrays;

/**
 * Killed the opponent within 60 seconds and damage done more than 75%"
 * Refer {@link SharpShooterAchievementRule} and {@link QuickKillerAchievementRule}
 */
public class FastKillerAward extends AbstractAchievement {

    private static final String name = "Fast Killer";
    private static final String description = "Killed the opponent within 60 seconds and damage done more than 75%";

    public FastKillerAward() {
        super(Arrays.asList(SharpShooterAchievementRule.getAchievementRule(),
                QuickKillerAchievementRule.getAchievementRule()) );
        AchievementManager.getInstance().addAchievement(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
