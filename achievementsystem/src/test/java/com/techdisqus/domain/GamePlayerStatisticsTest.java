package com.techdisqus.domain;

import com.techdisqus.AbstractTest;
import com.techdisqus.exception.ValidationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class GamePlayerStatisticsTest extends AbstractTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void testSetNumberOfAttemptedAttacksOnInvalidValue(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder().setNumberOfAttemptedAttacks(-20);
    }

    @Test
    public void testSetNumberOfHitsOnInvalidValue(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder().setNumberOfHits(-20);
    }

    @Test
    public void testSetTotalSpellDamageDoneOnInvalidValue(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder().setTotalSpellDamageDone(-20);
    }

    @Test
    public void testSetTotalNumberOfSpellsCastOnInvalidValue(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder().setTotalNumberOfSpellsCast(-20);
    }

    @Test
    public void testSetNumberOfAssistsOnInvalidValue(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder().setNumberOfAssists(-20);
    }


    @Test
    public void testSetNumberOfKillsOnInvalidValue(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder().setNumberOfKills(-20);
    }

    @Test
    public void testSetTotalAmountOfDamageDoneOnInvalidValue(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder().setTotalAmountOfDamageDone(-11);
    }

    @Test
    public void testSetTimeTakenToKillsOpponentOnValidValue(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder().setTimeTakenToKillsOpponent(-20);
    }

    @Test
    public void testSetTotalNumberOfSecondsPlayedOnInvalidValue(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder().setTotalNumberOfSecondsPlayed(-10);
    }

    @Test
    public void testNoOfKillsGreaterThanAttemptedAttacks(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder()
                .setNumberOfAttemptedAttacks(2)
                .setNumberOfKills(10).buildGamePlayerStatistics();
    }

    @Test
    public void testNoOfKillsGreaterThanNoOfHits(){
        expected.expect(ValidationException.class);
        new GamePlayerStatistics.GamePlayerStatisticsBuilder()
                .setNumberOfAttemptedAttacks(10)
                .setNumberOfHits(5)
                .setNumberOfKills(10).buildGamePlayerStatistics();
    }

    @Test
    public void testNoOfHitsGreaterThanNumberOfAttemptedAttacks(){
        expected.expect(ValidationException.class);
        getGamePlayerStatisticsBuilder().setNumberOfAttemptedAttacks(20)
                .setNumberOfHits(50).buildGamePlayerStatistics();
    }




    @Test
    public void testAllSettersForValidValues(){
        GamePlayerStatistics gamePlayerStatistics =
                getGamePlayerStatisticsBuilder()
                .setNumberOfAttemptedAttacks(20)
                .setNumberOfHits(10)
                .setTimeTakenToKillsOpponent(5)
                .setTotalAmountOfDamageDone(500)
                .setTotalNumberOfSecondsPlayed(600)
                .setNumberOfKills(5)
                .setNumberOfAssists(3)
                .setTotalNumberOfSpellsCast(54)
                .setTotalSpellDamageDone(32).buildGamePlayerStatistics();

        assertEquals(20, gamePlayerStatistics.getNumberOfAttemptedAttacks());
        assertEquals(10, gamePlayerStatistics.getNumberOfHits());
        assertEquals(5, gamePlayerStatistics.getTimeTakenToKillsOpponent());
        assertEquals(500, gamePlayerStatistics.getTotalAmountOfDamageDone());
        assertEquals(600, gamePlayerStatistics.getTotalNumberOfSecondsPlayed());
        assertEquals(5, gamePlayerStatistics.getNumberOfKills());
        assertEquals(3, gamePlayerStatistics.getNumberOfAssists());
        assertEquals(54, gamePlayerStatistics.getTotalNumberOfSpellsCast());
        assertEquals(32, gamePlayerStatistics.getTotalSpellDamageDone());
    }

}
