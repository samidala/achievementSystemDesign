package com.techdisqus.rules;

import com.techdisqus.AbstractTest;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public  abstract class AbstractRuleTest extends AbstractTest {

    protected abstract AchievementRule getAchievementRule();

    @Test
    public void testGetRuleDescription(){
        assertThat(getAchievementRule().getRuleDescription(), CoreMatchers.not(Matchers.isEmptyOrNullString()));
    }


}
