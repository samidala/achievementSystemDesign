package com.techdisqus.achievement.orchestration;


import com.techdisqus.achievement.Achievement;
import com.techdisqus.achievement.manager.AchievementManagerFactory;
import com.techdisqus.achievement.manager.AchievementManagerType;
import com.techdisqus.domain.AbstractPlayerStatistics;
import com.techdisqus.domain.AbstractProfile;
import com.techdisqus.notifier.AchievementNotifierFactory;
import com.techdisqus.notifier.AchievementNotifierType;
import com.techdisqus.persister.AchievementPersisterFactory;
import com.techdisqus.persister.AchievementPersisterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;


public class AchievementOrchestrator extends AbstractAchievementOrchestrator {

    private static final Logger  logger = LoggerFactory.getLogger(AchievementOrchestrator.class);

    private AchievementOrchestrator(){
        super(AchievementManagerFactory.getAchievementManager(AchievementManagerType.DEFAULT),
                AchievementNotifierFactory.getAchievementNotifier(AchievementNotifierType.DEFAULT),
              AchievementPersisterFactory.getAchievementPersister(AchievementPersisterType.DEFAULT));
    }

    protected List<Achievement> checkForPlayerAchievements( AbstractPlayerStatistics playerStatistics) throws RuntimeException{
        return getAchievementManager().checkForPlayerAchievements(playerStatistics);
    }

    protected void notifyAchievements(AbstractProfile playerProfile, Collection<Achievement> playerAchievements){
        try {
            getAchievementNotifier().notifyAchievement(playerProfile, playerAchievements);
        }catch (Exception e){
            logger.error("error while notifying ",e);
            throw e;
        }
    }

    protected void persistAchievements(AbstractProfile playerProfile, Collection<Achievement> playerAchievements){
        try {
            getAchievementPersister().persist(playerProfile, playerAchievements);
        }catch (Exception e){
            logger.error("error while persisting",e);
            throw e;
        }
    }

    private static class SingletonHelper{
        private static final AchievementOrchestrator INSTANCE = new AchievementOrchestrator();
    }

    public static AchievementOrchestrator getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
