package com.techdisqus.notification;

import com.techdisqus.notifier.AchievementNotifierFactory;
import com.techdisqus.notifier.AchievementNotifierType;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AchievementNotifierFactoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetAchievementNotifierOnValidInput(){
        Assert.assertNotNull(AchievementNotifierFactory.getAchievementNotifier(AchievementNotifierType.DEFAULT));
    }

    @Test
    public void testGetAchievementNotifierOnInvalidInput(){
        expectedException.expect(RuntimeException.class);
        AchievementNotifierFactory.getAchievementNotifier(null);
    }

}
