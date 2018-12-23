package com.techdisqus.rules;

import com.techdisqus.domain.AbstractPlayerStatistics;

/**
 *  Define rule that to be satisfied by a @{@link com.techdisqus.domain.PlayerProfile} to receive @{@link com.techdisqus.achievement.Achievement}
 *  The @{@link com.techdisqus.achievement.Achievement} might define multiple rules. These rules executed @{@link com.techdisqus.achievement.AbstractAchievement#isEligible(AbstractPlayerStatistics)}
 */
public interface AchievementRule {

    /**
     * executed in @{@link com.techdisqus.achievement.AbstractAchievement#isEligible(AbstractPlayerStatistics)}
     * @param playerStatistics @{@link AbstractPlayerStatistics}
     * @return true if evaluated rule is success and false if not.
     */
    boolean evaluateRule(AbstractPlayerStatistics playerStatistics);

    /**
     *
     * @return rule description used in @{@link com.techdisqus.achievement.Achievement#getRules} to list out the rules to be satisfied by @{@link com.techdisqus.domain.PlayerProfile}
     * to receive @{@link com.techdisqus.achievement.Achievement}
     */
    String getRuleDescription();

}
