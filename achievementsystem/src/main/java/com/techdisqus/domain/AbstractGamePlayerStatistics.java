package com.techdisqus.domain;

/**
 * Abstract holder for player statistics properties of @{@link PlayerProfile }in current @{@link com.techdisqus.game.Game}
 */
public class AbstractGamePlayerStatistics extends  AbstractStatistics {

    protected final int numberOfAttemptedAttacks;
    protected final int numberOfHits;
    protected final int totalAmountOfDamageDone;
    protected final int numberOfKills;
    protected final int numberOfAssists;
    protected final int totalNumberOfSpellsCast;
    protected final int totalSpellDamageDone;
    protected final long totalNumberOfSecondsPlayed;
    protected final long timeTakenToKillsOpponent;

    public AbstractGamePlayerStatistics(int numberOfAttemptedAttacks, int numberOfHits, int totalAmountOfDamageDone,
                                        int numberOfKills, int numberOfAssists, int totalNumberOfSpellsCast,
                                        int totalSpellDamageDone, long totalNumberOfSecondsPlayed, long timeTakenToKillsOpponent) {
        this.numberOfAttemptedAttacks = numberOfAttemptedAttacks;
        this.numberOfHits = numberOfHits;
        this.totalAmountOfDamageDone = totalAmountOfDamageDone;
        this.numberOfKills = numberOfKills;
        this.numberOfAssists = numberOfAssists;
        this.totalNumberOfSpellsCast = totalNumberOfSpellsCast;
        this.totalSpellDamageDone = totalSpellDamageDone;
        this.totalNumberOfSecondsPlayed = totalNumberOfSecondsPlayed;
        this.timeTakenToKillsOpponent = timeTakenToKillsOpponent;
    }

    public int getNumberOfAttemptedAttacks() {
        return numberOfAttemptedAttacks;
    }

    public int getNumberOfHits() {
        return numberOfHits;
    }

    public int getTotalAmountOfDamageDone() {
        return totalAmountOfDamageDone;
    }

    public int getNumberOfKills() {
        return numberOfKills;
    }

    public int getNumberOfAssists() {
        return numberOfAssists;
    }

    public int getTotalNumberOfSpellsCast() {
        return totalNumberOfSpellsCast;
    }

    public int getTotalSpellDamageDone() {
        return totalSpellDamageDone;
    }

    public long getTotalNumberOfSecondsPlayed() {
        return totalNumberOfSecondsPlayed;
    }

    public long getTimeTakenToKillsOpponent() {
        return timeTakenToKillsOpponent;
    }
}
