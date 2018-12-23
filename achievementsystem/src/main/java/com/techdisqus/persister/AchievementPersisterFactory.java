package com.techdisqus.persister;

import com.techdisqus.Commons;

/**
 * Factory class to get implementation of @{@link AchievementPersister}
 */
public class AchievementPersisterFactory {

    private AchievementPersisterFactory(){}
    /**
     * @param achievementPersisterType the @{@link AchievementPersisterType} used to choose and return right @{@link AchievementPersister}
     * @return @{@link AchievementPersister}
     * @throws RuntimeException  on invalid type
     */
    public static AchievementPersister getAchievementPersister(AchievementPersisterType achievementPersisterType) throws RuntimeException{
        AchievementPersister achievementPersister;
        if(Commons.isNull(achievementPersisterType)){
            throw new RuntimeException("invalid achievementPersisterType null");
        }
        switch (achievementPersisterType){
            case DEFAULT: achievementPersister = new FileAchievementPersister();
            break;
            default:
                throw new RuntimeException("invalid achievementPersisterType");
        }
        return  achievementPersister;
    }


}
