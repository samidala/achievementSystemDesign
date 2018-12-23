package com.techdisqus.achievement.manager;


import com.techdisqus.achievement.Achievement;
import com.techdisqus.domain.AbstractPlayerStatistics;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Entry point for game application if it has direct reference of implementation of this class.
 */
public abstract class AbstractAchievementManager implements Cloneable {

    /**
     * {@link Collection} of {@link Achievement} that evaluated to award @{@link Achievement} to @{@link com.techdisqus.domain.PlayerProfile}
     */
    private final Collection<Achievement> achievementsDefinations = new HashSet<>();


    /**
     * checks for player achievements, notifies and persists to database.
     * @param playerStatistics @{@link AbstractPlayerStatistics}
     * @return list of achievements achieved by @{@link com.techdisqus.domain.PlayerProfile}
     */
    public abstract List<Achievement> checkForPlayerAchievements( AbstractPlayerStatistics playerStatistics) throws RuntimeException;

    /**
     * Called from @{@link Achievement} implementations to register themself.
     * @param achievement @{@link Achievement}
     */
    public void addAchievement(Achievement achievement){
        achievementsDefinations.add(achievement);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw  new CloneNotSupportedException("clone not supported");
    }

    public Collection<Achievement> getAchievementsDefinations() {
        return achievementsDefinations;
    }
}
