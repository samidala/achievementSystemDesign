package com.techdisqus.domain;

import com.techdisqus.AbstractTest;
import com.techdisqus.exception.ValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;




public class HistoricalStatisticsTest extends AbstractTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void testSetTotalNumberOfGamesPlayedOnInvalidValue(){
        expected.expect(ValidationException.class);
        getHistoricalStatisticsBuilder().setTotalNumberOfGamesPlayed(-20);
    }

    @Test
    public void testAllHistoricalStatisticsOnValidValue(){
        HistoricalStatistics historicalStatistics =
                        getHistoricalStatisticsBuilder()
                        .setTotalNumberOfGamesPlayed(65)
                        .setTotalDurationOfGamePlayed(500)
                        .setTotalNumberOfAssists(100)
                        .setTotalNumberOfKills(70)
                        .setTotalNumberOfWins(30)
                        .buildHistoricalStatistics();

        assertEquals(65,historicalStatistics.getTotalNumberOfGamesPlayed());
        assertEquals(500,historicalStatistics.getTotalDurationOfGamePlayed());
        assertEquals(100,historicalStatistics.getTotalNumberOfAssists());
        assertEquals(70,historicalStatistics.getTotalNumberOfKills());
        assertEquals(30,historicalStatistics.getTotalNumberOfWins());
    }

    @Test
    public void testSetTotalNumberOfWinsOnInvalidValue(){
        expected.expect(ValidationException.class);
        getHistoricalStatisticsBuilder().setTotalNumberOfWins(-10);
    }

    @Test
    public void testSetTotalDurationOfGamePlayedOnInvalidValue(){
        expected.expect(ValidationException.class);
        getHistoricalStatisticsBuilder().setTotalDurationOfGamePlayed(-20);
    }


    @Test
    public void testSetTotalNumberOfAssistsOnInvalidValue(){
        expected.expect(ValidationException.class);
        getHistoricalStatisticsBuilder().setTotalNumberOfAssists(-20);
    }

    @Test
    public void testSetTotalNumberOfKillsOnInvalidValue(){
        expected.expect(ValidationException.class);
        getHistoricalStatisticsBuilder().setTotalNumberOfKills(-20);
    }


}
