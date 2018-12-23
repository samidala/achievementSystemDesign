package com.techdisqus.achievement;

import com.techdisqus.domain.AbstractPlayerStatistics;
import com.techdisqus.rules.AchievementRule;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * abstract implementation of Achievement and provides implementation for
 * isEligible to check if the player satisfies @{@link Collection} of @{@link AchievementRule},
 * getRules to get list of @{@link AchievementRule#getRuleDescription()},
 * hashCode and equals for defining equality
 */
public abstract class AbstractAchievement implements Achievement {


    /**
     * list of @{@link AchievementRule} that to be evaluated and passed to obtain the achievement by @{@link com.techdisqus.domain.PlayerProfile}
     */
    private final List<AchievementRule> achievementRules;

    public AbstractAchievement(List<AchievementRule> achievementRules){
        this.achievementRules = Collections.unmodifiableList(achievementRules);
    }

    public boolean isEligible(final AbstractPlayerStatistics playerStatistics) {

        return achievementRules.stream()
                            .allMatch(completionCondition -> completionCondition.evaluateRule(playerStatistics));

    }

    @Override
    public Collection<String> getRules() {
        return achievementRules.stream()
                .map(AchievementRule::getRuleDescription)
                .collect(Collectors.toList());
    }


    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }


    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Achievement){
            Achievement achievement = (Achievement) obj;
            return achievement.getName().equals(this.getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return getName();
    }

}
