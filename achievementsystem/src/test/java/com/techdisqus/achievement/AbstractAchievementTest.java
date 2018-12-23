package com.techdisqus.achievement;

import com.techdisqus.AbstractTest;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;
public abstract class AbstractAchievementTest extends AbstractTest {

    protected abstract Achievement getAchievement();

    protected int getExpectedCount(){
        return 1;
    }

    @Test
    public void testRulesCount(){
        assertThat(getAchievement().getRules().size(), Matchers.is(getExpectedCount()));
    }

}
