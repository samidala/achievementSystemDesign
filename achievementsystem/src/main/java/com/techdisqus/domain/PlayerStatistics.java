package com.techdisqus.domain;

/**
 * Container for @{@link PlayerProfile}, @{@link GamePlayerStatistics } and @{@link HistoricalStatistics}
 * use {@link PlayerStatisticsBuilder} for building object
 */
public class PlayerStatistics extends AbstractPlayerStatistics{

    private final AbstractProfile playerProfile;
    private final AbstractGamePlayerStatistics currentGamePlayerStatistics;
    private static final AbstractHistoricalStatistics HISTORICAL_STATISTICS = new HistoricalStatistics.HistoricalStatisticsBuilder().buildHistoricalStatistics();

    private AbstractHistoricalStatistics historicalStatistics ;

    public PlayerStatistics(AbstractProfile playerProfile, AbstractGamePlayerStatistics gamePlayerStatistics, AbstractHistoricalStatistics historicalStatistics){
        if(playerProfile == null){
            throw new RuntimeException("Player object can not be null");
        }
        if(gamePlayerStatistics == null){
            throw new RuntimeException("gamePlayerStatistics can not be null");
        }
        this.playerProfile = playerProfile;
        this.currentGamePlayerStatistics = gamePlayerStatistics;
        this.historicalStatistics = historicalStatistics;
    }

    public AbstractProfile getPlayerProfile() {
        return playerProfile;
    }

    public AbstractGamePlayerStatistics getCurrentGamePlayerStatistics() {
        return currentGamePlayerStatistics;
    }

    public AbstractHistoricalStatistics getHistoricalStatistics() {
        if(historicalStatistics == null){
            //to avoid NULL checks
            return HISTORICAL_STATISTICS;
        }
        return historicalStatistics;
    }

    /**
     * builder for {@link PlayerStatistics}
     */
    public static class PlayerStatisticsBuilder{

        private final PlayerProfile playerProfile;
        private GamePlayerStatistics.GamePlayerStatisticsBuilder gamePlayerStatisticsBuilder;
        private HistoricalStatistics.HistoricalStatisticsBuilder historicalStatisticsBuilder ;

        public PlayerStatisticsBuilder(PlayerProfile playerProfile){
            this.playerProfile = playerProfile;
        }

        public PlayerStatisticsBuilder setGamePlayerStatisticsBuilder(GamePlayerStatistics.GamePlayerStatisticsBuilder gamePlayerStatisticsBuilder) {
            this.gamePlayerStatisticsBuilder = gamePlayerStatisticsBuilder;
            return this;
        }

        public PlayerStatisticsBuilder setHistoricalStatisticsBuilder(HistoricalStatistics.HistoricalStatisticsBuilder historicalStatisticsBuilder) {
            this.historicalStatisticsBuilder = historicalStatisticsBuilder;
            return this;
        }

        public GamePlayerStatistics.GamePlayerStatisticsBuilder getGamePlayerStatisticsBuilder() {
            return gamePlayerStatisticsBuilder;
        }

        public HistoricalStatistics.HistoricalStatisticsBuilder getHistoricalStatisticsBuilder() {
            return historicalStatisticsBuilder;
        }

        public PlayerStatistics build(){
            return new PlayerStatistics(playerProfile,gamePlayerStatisticsBuilder.buildGamePlayerStatistics(),
                    historicalStatisticsBuilder.buildHistoricalStatistics());
       }

    }

}
