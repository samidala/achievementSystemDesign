package com.techdisqus.achievement.manager;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AchievementManagerFactoryTest {

    @Rule
   public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void testGetAchievementManagerOnValidAchievementManagerType(){
        Assert.assertNotNull(AchievementManagerFactory.getAchievementManager(AchievementManagerType.DEFAULT));
    }


    @Test
    public void testGetAchievementManagerOnInvalidAchievementManagerType(){
        expectedException.expect(RuntimeException.class);
        AchievementManagerFactory.getAchievementManager(null);
    }

}
