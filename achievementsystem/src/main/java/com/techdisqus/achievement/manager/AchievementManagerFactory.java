package com.techdisqus.achievement.manager;

import com.techdisqus.Commons;

/**
 * Factory class to get @{@link AbstractAchievementManager}
 */
public class AchievementManagerFactory {

    private AchievementManagerFactory(){}

    /**
     *
     * @param achievementManagerType @{@link AchievementManagerType}
     * @return implementation of @{@link AbstractAchievementManager}
     */
    public static AbstractAchievementManager getAchievementManager(AchievementManagerType achievementManagerType){
        AbstractAchievementManager achievementManager;

        if(Commons.isNull(achievementManagerType)){
            throw new RuntimeException("Invalid achievementManagerType null");
        }

        switch (achievementManagerType) {
            case DEFAULT:
                achievementManager =  AchievementManager.getInstance();
                break;
            default:
                throw new RuntimeException("Invalid achievementManagerType");
        }
        return achievementManager;

    }
}
