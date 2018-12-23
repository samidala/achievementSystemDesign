package com.techdisqus.achievement;

import com.techdisqus.achievement.manager.AchievementManager;
import com.techdisqus.rules.VeteranAchievementRule;

import java.util.Arrays;

/**
 * awarded on successful completion of 500 games
 * refer {@link com.techdisqus.rules.VeteranAchievementRule}
 */
public class VeteranAward extends AbstractAchievement {

    private static final String name = "Veteran";
    private static final String description = "awarded on successful completion of 500 games";
    public VeteranAward(){
        super(Arrays.asList(VeteranAchievementRule.getAchievementRule()));
        AchievementManager.getInstance().addAchievement(this);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
