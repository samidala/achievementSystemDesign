package com.techdisqus.achievement.orchestration;

import com.techdisqus.Commons;

/**
 * Factory class to obtain {@link AbstractAchievementOrchestrator} implementations
 */
public class AchievementOrchestratorFactory {

    private AchievementOrchestratorFactory(){}

    /**
     *
     * @param achievementOrchestratorType reference of {@link AchievementOrchestratorType}
     * @return implementation of @{@link AbstractAchievementOrchestrator}
     */
    public static AbstractAchievementOrchestrator getAchievementOrchestrator(AchievementOrchestratorType achievementOrchestratorType){
        AbstractAchievementOrchestrator achievementOrchestrator;

        if(Commons.isNull(achievementOrchestratorType)){
            throw  new RuntimeException("invalid achievement orchestrator type null");
        }

        switch (achievementOrchestratorType){
            case DEFAULT:
                achievementOrchestrator = AchievementOrchestrator.getInstance();
                break;
            default:
                throw new RuntimeException("invalid achievement orchestrator type");
        }
        return achievementOrchestrator;
    }
}
