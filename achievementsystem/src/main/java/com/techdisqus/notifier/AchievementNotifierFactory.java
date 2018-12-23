package com.techdisqus.notifier;


import com.techdisqus.Commons;

/**
 * Factory to get implementation of @{@link AchievementNotifier}
 */
public class AchievementNotifierFactory {

    private AchievementNotifierFactory(){}
    /**
     * @param achievementNotifierType @{@link AchievementNotifierType}
     * @return @{@link AchievementNotifier}
     * @throws RuntimeException on invalid type
     */
    public static AchievementNotifier getAchievementNotifier(AchievementNotifierType achievementNotifierType) throws RuntimeException {
        AchievementNotifier achievementNotifier;

        if(Commons.isNull(achievementNotifierType))
            throw new RuntimeException("Invalid achievementNotifierType null");

        switch (achievementNotifierType) {
            case DEFAULT:
                achievementNotifier = new AchievementNotifierImpl();
                break;
            default:
                throw new RuntimeException("invalid type");
        }
        return achievementNotifier;
    }

}
