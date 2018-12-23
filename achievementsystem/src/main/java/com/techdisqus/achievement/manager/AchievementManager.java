package com.techdisqus.achievement.manager;


import com.techdisqus.achievement.Achievement;
import com.techdisqus.domain.AbstractPlayerStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The class evaluates the current game player statistics and historical statistics and awards the eligible achievements to {@link com.techdisqus.domain.PlayerProfile}
 */
public class AchievementManager extends AbstractAchievementManager {

    private static final Logger logger = LoggerFactory.getLogger(AchievementManager.class);

    private AchievementManager(){
        super();
    }

    public List<Achievement> checkForPlayerAchievements(AbstractPlayerStatistics playerStatistics) throws RuntimeException{
        List<Achievement> playerAchievements = getAchievementsDefinations().stream()
                    .filter(achievement -> achievement.isEligible(playerStatistics))
                    .collect(Collectors.toList());
        logger.info("playerAchievements {} ",playerAchievements);
        return playerAchievements;
    }

    private static class SingletonHelper{
        private static final AchievementManager INSTANCE = new AchievementManager();
    }

    public static AchievementManager getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
