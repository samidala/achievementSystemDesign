package com.techdisqus.persister;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AchievementPersisterFactoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetAchievementPersisterOnValidInput(){
        Assert.assertNotNull(AchievementPersisterFactory.getAchievementPersister(AchievementPersisterType.DEFAULT));
    }

    @Test
    public void testGetAchievementPersisterOnInvalidInput(){
        expectedException.expect(RuntimeException.class);
        AchievementPersisterFactory.getAchievementPersister(null);
    }
}
