package com.techdisqus.achievement.orchestration;

import com.techdisqus.AbstractTest;
import com.techdisqus.achievement.Achievement;
import com.techdisqus.achievement.BigWinnerAward;
import com.techdisqus.achievement.BruiserAward;
import com.techdisqus.achievement.FastKillerAward;
import com.techdisqus.achievement.SharpShooterAward;
import com.techdisqus.achievement.VeteranAward;
import com.techdisqus.achievement.manager.AchievementManager;
import com.techdisqus.domain.PlayerStatistics;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class AchievementOrchestratorTest extends AbstractTest {
    private AchievementManager achievementManager = AchievementManager.getInstance();

    @BeforeClass
    public static void init(){
        new BigWinnerAward();
        new BruiserAward();
        new FastKillerAward();
        new SharpShooterAward();
        new VeteranAward();
    }

    @Test
    public void testBruiserSharpShooterAndFastKillerAchievements(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();

        playerStatisticsBuilder.getGamePlayerStatisticsBuilder().setTimeTakenToKillsOpponent(30)
                .setNumberOfAttemptedAttacks(10)
                .setTotalAmountOfDamageDone(900)
                .setNumberOfHits(6)
                .setNumberOfHits(9);

        List<Achievement> playerAchievements = achievementManager.checkForPlayerAchievements(playerStatisticsBuilder.build());
        assertEquals(3,playerAchievements.size());
        assertThat(playerAchievements,
                contains(new BruiserAward(),new SharpShooterAward(),new FastKillerAward()) );
    }

    @Test
    public void testSharpShooterAndFastKillerAchievements(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();

        playerStatisticsBuilder.getGamePlayerStatisticsBuilder().setTimeTakenToKillsOpponent(30)
                .setNumberOfAttemptedAttacks(10)
                .setNumberOfHits(6)
                .setNumberOfHits(9);

        List<Achievement> playerAchievements = achievementManager.checkForPlayerAchievements(playerStatisticsBuilder.build());
        assertEquals(2,playerAchievements.size());
        assertThat(playerAchievements,
                contains(new SharpShooterAward(),new FastKillerAward()) );
    }

    @Test
    public void testBigWinnerVeteranAchievements(){
        PlayerStatistics.PlayerStatisticsBuilder playerStatisticsBuilder = getPlayerStatisticsBuilder();

        playerStatisticsBuilder.getHistoricalStatisticsBuilder().setTotalNumberOfWins(300)
                .setTotalNumberOfGamesPlayed(4000);
        List<Achievement> playerAchievements = achievementManager.checkForPlayerAchievements(playerStatisticsBuilder.build());
        assertEquals(2,playerAchievements.size());
        assertThat(playerAchievements,
                containsInAnyOrder(new BigWinnerAward(),new VeteranAward()) );
    }

}


