package com.techdisqus.events;

import com.techdisqus.achievement.orchestration.AbstractAchievementOrchestrator;
import com.techdisqus.achievement.orchestration.AchievementOrchestrator;
import com.techdisqus.achievement.orchestration.AchievementOrchestratorFactory;
import com.techdisqus.achievement.orchestration.AchievementOrchestratorType;
import com.techdisqus.domain.PlayerStatistics;

import java.util.Collection;

/**
 * implementation of @{@link GameCompletionEvent}
 * The implementation uses @{@link AchievementOrchestrator}
 */
public class GameCompletionEventImpl implements GameCompletionEvent {

    private final AbstractAchievementOrchestrator achievementOrchestrator;

    public GameCompletionEventImpl(){
        achievementOrchestrator = AchievementOrchestratorFactory
                .getAchievementOrchestrator(AchievementOrchestratorType.DEFAULT);
    }

    @Override
    public void onGameCompletion(Collection<PlayerStatistics> playerStatistics) {
        playerStatistics.forEach(achievementOrchestrator::orchestrate);
    }

}
