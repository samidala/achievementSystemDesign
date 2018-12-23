package com.techdisqus.achievement.orchestration;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AchievementOrchestratorFactoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetAchievementOrchestratorOnValidInput(){
        Assert.assertNotNull(AchievementOrchestratorFactory
                .getAchievementOrchestrator(AchievementOrchestratorType.DEFAULT));
    }

    @Test
    public void testGetAchievementOrchestratorOnInValidInput(){
        //expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("invalid achievement orchestrator type null");
        AchievementOrchestratorFactory.getAchievementOrchestrator(null);
    }


}
