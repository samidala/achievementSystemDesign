package com.techdisqus.notifier;

import com.techdisqus.achievement.Achievement;
import com.techdisqus.domain.AbstractProfile;
import com.techdisqus.domain.PlayerProfile;

import java.util.Collection;

/**
 * Implement the interface for notifying achievements. Referred in @{@link com.techdisqus.achievement.orchestration.AbstractAchievementOrchestrator}
 * for publishing achievement events
 */
public interface AchievementNotifier {

    /**
     * Notifies achievement
     * @param playerProfile: for which @{@link AbstractProfile}
     * @param achievements: collection of @{@link Achievement} achieved by @{@link PlayerProfile} in current game
     */
    void notifyAchievement(AbstractProfile playerProfile, Collection<Achievement> achievements);

}
