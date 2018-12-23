package com.techdisqus.persister;

import com.techdisqus.achievement.Achievement;
import com.techdisqus.domain.AbstractProfile;
import com.techdisqus.domain.PlayerProfile;

import java.util.Collection;

/**
 * used for persisting player achievements to database.
 */
public interface AchievementPersister {

    /**
     *
     * @param playerProfile: @{@link AbstractProfile}
     * @param achievements list of @{@link Achievement} achieved by this @{@link PlayerProfile} in current game
     */
    void persist(AbstractProfile playerProfile, Collection<Achievement> achievements);
}
