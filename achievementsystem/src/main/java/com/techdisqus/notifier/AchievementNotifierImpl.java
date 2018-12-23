package com.techdisqus.notifier;

import com.techdisqus.achievement.Achievement;
import com.techdisqus.domain.AbstractProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * sysout implementation of @{@link AchievementNotifier}
 */
public class AchievementNotifierImpl implements AchievementNotifier{

    private static final Logger logger = LoggerFactory.getLogger(AchievementNotifierImpl.class);

    @Override
    public void notifyAchievement(AbstractProfile playerProfile, Collection<Achievement> achievements) {

        achievements.forEach(achievement -> logger.info("Notifying {}"
                + " achievement {}",playerProfile.getId(),achievement.getName()));
        achievements.forEach(Achievement::getName);
    }
}
