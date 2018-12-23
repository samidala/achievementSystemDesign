package com.techdisqus.events;

import com.techdisqus.domain.PlayerStatistics;
import java.util.Collection;

/**
 * Implement this interface to publish an event on successful game completion.
 */
public interface GameCompletionEvent {
    /**
     * Trigger event on successful game completion
     * @param playerStatistics: refers to player statistics @{@link PlayerStatistics}
     */
    void onGameCompletion(Collection<PlayerStatistics> playerStatistics) throws Exception;
}
