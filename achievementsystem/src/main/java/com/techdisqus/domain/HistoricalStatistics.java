
package com.techdisqus.domain;


import com.techdisqus.exception.ValidationException;

/**
 * Holder for historical statistics of @{@link PlayerProfile}. the class is referred in @{@link PlayerStatistics}
 * use {@link HistoricalStatisticsBuilder} to build object
 */
public class HistoricalStatistics extends AbstractHistoricalStatistics {


    private HistoricalStatistics(int totalNumberOfGamesPlayed, long totalDurationOfGamePlayed, long totalNumberOfKills, int totalNumberOfWins, int totalNumberOfAssists) {
        super(totalNumberOfGamesPlayed, totalDurationOfGamePlayed, totalNumberOfKills, totalNumberOfWins, totalNumberOfAssists);
    }


    /**
     * @HistoricalStatistics builder for @{@link PlayerProfile}
     */
    public static class HistoricalStatisticsBuilder extends  AbstractStatisticsBuilder{

        private int totalNumberOfGamesPlayed;

        private long totalDurationOfGamePlayed;

        private long totalNumberOfKills;

        private int totalNumberOfWins;

        private int totalNumberOfAssists;

        public HistoricalStatisticsBuilder setTotalNumberOfGamesPlayed(int totalNumberOfGamesPlayed) {
            isValidInput(totalNumberOfGamesPlayed);
            this.totalNumberOfGamesPlayed = totalNumberOfGamesPlayed;
            return this;
        }

        public HistoricalStatisticsBuilder setTotalNumberOfAssists(int totalNumberOfAssists) {
            isValidInput(totalNumberOfAssists);
            this.totalNumberOfAssists = totalNumberOfAssists;
            return this;
        }

        public HistoricalStatisticsBuilder setTotalDurationOfGamePlayed(long totalDurationOfGamePlayed) {
            isValidInput(totalDurationOfGamePlayed);
            this.totalDurationOfGamePlayed = totalDurationOfGamePlayed;
            return this;
        }

        public HistoricalStatisticsBuilder setTotalNumberOfKills(long totalNumberOfKills) {
            isValidInput(totalNumberOfKills);
            this.totalNumberOfKills = totalNumberOfKills;
            return this;
        }

        public HistoricalStatisticsBuilder setTotalNumberOfWins(int totalNumberOfWins) {
            isValidInput(totalNumberOfWins);
            this.totalNumberOfWins = totalNumberOfWins;
            return this;
        }
        public  HistoricalStatistics buildHistoricalStatistics(){
            isValidTotalNumberOfWins();
            return new HistoricalStatistics(totalNumberOfGamesPlayed,totalDurationOfGamePlayed,totalNumberOfKills,totalNumberOfWins,totalNumberOfAssists);
        }

        private  void isValidTotalNumberOfWins(){
            if(totalNumberOfWins > totalNumberOfGamesPlayed){
                throw  new ValidationException("number of wins can not be greater than number games played");
            }
        }

    }


}
