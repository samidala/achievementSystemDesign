package com.techdisqus.domain;

import com.techdisqus.exception.ValidationException;


/**
 * represents statistics of @{@link PlayerProfile }in current @{@link com.techdisqus.game.Game}
 * Use {@link GamePlayerStatisticsBuilder} for building the object.
 */
public class GamePlayerStatistics extends  AbstractGamePlayerStatistics {


    public GamePlayerStatistics(int numberOfAttemptedAttacks, int numberOfHits, int totalAmountOfDamageDone,
                                int numberOfKills, int numberOfAssists, int totalNumberOfSpellsCast,
                                int totalSpellDamageDone, long totalNumberOfSecondsPlayed, long timeTakenToKillsOpponent) {
        super(numberOfAttemptedAttacks, numberOfHits, totalAmountOfDamageDone, numberOfKills, numberOfAssists,
                totalNumberOfSpellsCast, totalSpellDamageDone, totalNumberOfSecondsPlayed, timeTakenToKillsOpponent);
    }

    /**
     * builder for {@link GamePlayerStatistics}
     */
    public static class GamePlayerStatisticsBuilder extends AbstractStatisticsBuilder{

        private int numberOfAttemptedAttacks;
        private int numberOfHits;
        private int totalAmountOfDamageDone;
        private int numberOfKills;
        private int numberOfAssists;
        private int totalNumberOfSpellsCast;
        private int totalSpellDamageDone;
        private long totalNumberOfSecondsPlayed;
        private long timeTakenToKillsOpponent;


        public GamePlayerStatisticsBuilder setNumberOfAttemptedAttacks(int numberOfAttemptedAttacks) {
            isValidInput(numberOfAttemptedAttacks);
            this.numberOfAttemptedAttacks = numberOfAttemptedAttacks;
            return this;
        }

        public GamePlayerStatisticsBuilder setNumberOfHits(int numberOfHits) {
            isValidInput(numberOfHits);
            this.numberOfHits = numberOfHits;
            return this;
        }


        public GamePlayerStatisticsBuilder setTotalAmountOfDamageDone(int totalAmountOfDamageDone) {
            isValidInput(totalAmountOfDamageDone);
            this.totalAmountOfDamageDone = totalAmountOfDamageDone;
            return this;
        }

        public GamePlayerStatisticsBuilder setNumberOfKills(int numberOfKills) {
            isValidInput(numberOfKills);
            this.numberOfKills = numberOfKills;
            return this;
        }

        public GamePlayerStatisticsBuilder setNumberOfAssists(int numberOfAssists) {
            isValidInput(numberOfAssists);
            this.numberOfAssists = numberOfAssists;
            return this;
        }

        public GamePlayerStatisticsBuilder setTotalNumberOfSpellsCast(int totalNumberOfSpellsCast) {
            isValidInput(totalNumberOfSpellsCast);
            this.totalNumberOfSpellsCast = totalNumberOfSpellsCast;
            return this;
        }

        public GamePlayerStatisticsBuilder setTotalSpellDamageDone(int totalSpellDamageDone) {
            isValidInput(totalSpellDamageDone);
            this.totalSpellDamageDone = totalSpellDamageDone;
            return this;
        }

        public GamePlayerStatisticsBuilder setTotalNumberOfSecondsPlayed(long totalNumberOfSecondsPlayed) {
            isValidInput(totalNumberOfSecondsPlayed);
            this.totalNumberOfSecondsPlayed = totalNumberOfSecondsPlayed;
            return this;
        }

        public GamePlayerStatisticsBuilder setTimeTakenToKillsOpponent(long timeTakenToKillsOpponent) {
            isValidInput(timeTakenToKillsOpponent);
            this.timeTakenToKillsOpponent = timeTakenToKillsOpponent;
            return this;
        }


        private boolean isNumberOfHitsGreaterThanNumberOfAttemptedAttacks(){
            if(numberOfHits > numberOfAttemptedAttacks){
                throw new ValidationException("the number of hits can not be greater than no of attempts");
            }
            return true;
        }
        private boolean isNumberOfKillsGreaterThanNumberOfKillsAndNumberOfHits(){
            if(numberOfKills > numberOfAttemptedAttacks){
                throw new ValidationException("the number of kills can not be greater than no of attempts");
            }
            if(numberOfKills > numberOfHits){
                throw new ValidationException("the number of kills can not be greater than no of hits");
            }
            return true;
        }

        public GamePlayerStatistics buildGamePlayerStatistics(){
            isNumberOfHitsGreaterThanNumberOfAttemptedAttacks();
            isNumberOfKillsGreaterThanNumberOfKillsAndNumberOfHits();
            return new GamePlayerStatistics(numberOfAttemptedAttacks, numberOfHits, totalAmountOfDamageDone,
                    numberOfKills, numberOfAssists, totalNumberOfSpellsCast,
                    totalSpellDamageDone, totalNumberOfSecondsPlayed, timeTakenToKillsOpponent);
        }

    }

}
