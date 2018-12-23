package com.techdisqus.persister;

import com.techdisqus.achievement.Achievement;
import com.techdisqus.domain.AbstractProfile;


import java.util.Collection;

/**
 * file write implementation of @{@link AchievementPersister}
 */
public class FileAchievementPersister implements AchievementPersister{

    @Override
    public void persist(AbstractProfile playerProfile, Collection<Achievement> achievements) {
        //Would try multiple time before error is thrown.
        achievements.forEach(achievement -> System.out.println(playerProfile.getId() + " and achievement "+
                achievement.getName() + " persisted to database"));

    }
}
