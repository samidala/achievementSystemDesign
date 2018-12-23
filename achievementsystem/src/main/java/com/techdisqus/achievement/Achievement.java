package com.techdisqus.achievement;

import com.techdisqus.domain.AbstractPlayerStatistics;
import com.techdisqus.domain.PlayerStatistics;

import java.util.Collection;

/**
 * Defines the rules of the achievement that can be awarded to a player
 */
public interface Achievement {

    /**
     *
     * @return achievement name
     */
    String getName();

    /**
     *
     * @return achievement description
     */
    String getDescription();

    /**
     * This runs through all the achievement rules and returns true if all match
     * @param playerStatistics @{@link PlayerStatistics}
     * @return true if player eligible for achievement
     *
     */
    boolean isEligible(AbstractPlayerStatistics playerStatistics);

    /**
     *
     * @return the rules to be cleared by the @{@link com.techdisqus.domain.PlayerProfile} to obtain the achievement
     */
    Collection<String> getRules();

}
