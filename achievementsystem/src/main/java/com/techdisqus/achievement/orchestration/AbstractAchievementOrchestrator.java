package com.techdisqus.achievement.orchestration;


import com.techdisqus.achievement.manager.AbstractAchievementManager;
import com.techdisqus.achievement.Achievement;
import com.techdisqus.domain.AbstractPlayerStatistics;
import com.techdisqus.domain.AbstractProfile;
import com.techdisqus.domain.PlayerProfile;

import com.techdisqus.notifier.AchievementNotifier;

import com.techdisqus.persister.AchievementPersister;
import java.util.Collection;

import java.util.List;

/**
 * provides template for achievement orchestration
 *
 */
public abstract class AbstractAchievementOrchestrator implements Cloneable {


    /**
     * implementation of @{@link AchievementNotifier} for notifying achievement events
     */
    private final AchievementNotifier achievementNotifier;

    /**
     * implementation of @{@link AchievementPersister} for persisting achievement events
     */
    private final AchievementPersister achievementPersister;


    /**
     * implementation of {@link AbstractAchievementManager}
     */
    private final AbstractAchievementManager achievementManager;

    /**
     *
     * @param achievementManager implementation of @{@link AbstractAchievementManager}
     * @param achievementNotifier implementation of {@link AchievementNotifier}
     * @param achievementPersister implementation of achievementPersister
     */
    protected AbstractAchievementOrchestrator(AbstractAchievementManager achievementManager,
                                              AchievementNotifier achievementNotifier,
                                              AchievementPersister achievementPersister){
        this.achievementManager = achievementManager;
        this.achievementNotifier = achievementNotifier;
        this.achievementPersister = achievementPersister;
    }


    /**
     * defines the template for orchestration.
     * @param playerStatistics implementation of @{@link AbstractPlayerStatistics}
     * @return
     */
    public final  List<Achievement> orchestrate(AbstractPlayerStatistics playerStatistics){
        List<Achievement> achievements = checkForPlayerAchievements(playerStatistics);
        notifyAchievements(playerStatistics.getPlayerProfile(),achievements);
        persistAchievements(playerStatistics.getPlayerProfile(),achievements);
        return achievements;
    }

    /**
     * Refer implementations of @{@link AbstractAchievementManager#checkForPlayerAchievements(AbstractPlayerStatistics)}
     * @param playerStatistics implementation of @{@link AbstractPlayerStatistics}
     * @return Collection of @{@link Achievement} achieved by player in this current context
     * @throws RuntimeException on any exception
     */
    protected abstract List<Achievement> checkForPlayerAchievements( AbstractPlayerStatistics playerStatistics) throws RuntimeException;

    /**
     * Method for notifying achievements to other systems
     * @param playerProfile @{@link PlayerProfile}
     * @param playerAchievements collection of {@link Achievement} awarded to player in current context.
     */
    protected abstract void notifyAchievements(AbstractProfile playerProfile, Collection<Achievement> playerAchievements);

    /**
     * Method for persisting achievements to a database
     * @param playerProfile @{@link PlayerProfile}
     * @param playerAchievements collection of {@link Achievement} awarded to player in current context.
     */
    protected abstract void persistAchievements(AbstractProfile playerProfile, Collection<Achievement> playerAchievements);

    /**
     *
     * @return implementation of @{@link AchievementNotifier}
     */
    protected AchievementNotifier getAchievementNotifier() {
        return achievementNotifier;
    }

    /**
     *
     * @return implementation of {@link AbstractAchievementManager}
     */
    protected AchievementPersister getAchievementPersister() {
        return achievementPersister;
    }

    /**
     *
     * @return implementation of {@link AbstractAchievementManager}
     */
    public AbstractAchievementManager getAchievementManager() {
        return achievementManager;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw  new CloneNotSupportedException("clone not supported");
    }

}
