package com.techdisqus.domain;

/**
 * Container for @{@link PlayerProfile}, @{@link GamePlayerStatistics } and @{@link HistoricalStatistics}
 */
public abstract class AbstractPlayerStatistics {


    public abstract AbstractProfile getPlayerProfile();

    public abstract  AbstractGamePlayerStatistics getCurrentGamePlayerStatistics();

    public abstract AbstractHistoricalStatistics getHistoricalStatistics();



}
