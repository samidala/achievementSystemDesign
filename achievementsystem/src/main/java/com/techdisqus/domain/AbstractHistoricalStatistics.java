
package com.techdisqus.domain;


/**
 * Abstract holder for historical statistics @{@link PlayerProfile}. the class is referred in @{@link AbstractPlayerStatistics}
 */
public abstract class AbstractHistoricalStatistics extends AbstractStatistics {


    protected final int totalNumberOfGamesPlayed;

    protected final long totalDurationOfGamePlayed;

    protected final long totalNumberOfKills;

    protected final int totalNumberOfWins;

    protected final int totalNumberOfAssists;

    protected AbstractHistoricalStatistics(int totalNumberOfGamesPlayed, long totalDurationOfGamePlayed, long totalNumberOfKills, int totalNumberOfWins, int totalNumberOfAssists) {
        this.totalNumberOfGamesPlayed = totalNumberOfGamesPlayed;
        this.totalDurationOfGamePlayed = totalDurationOfGamePlayed;
        this.totalNumberOfKills = totalNumberOfKills;
        this.totalNumberOfWins = totalNumberOfWins;
        this.totalNumberOfAssists = totalNumberOfAssists;
    }

    public int getTotalNumberOfGamesPlayed() {
        return totalNumberOfGamesPlayed;
    }

    public long getTotalDurationOfGamePlayed() {
        return totalDurationOfGamePlayed;
    }

    public long getTotalNumberOfKills() {
        return totalNumberOfKills;
    }

    public int getTotalNumberOfWins() {
        return totalNumberOfWins;
    }

    public int getTotalNumberOfAssists() {
        return totalNumberOfAssists;
    }
}
