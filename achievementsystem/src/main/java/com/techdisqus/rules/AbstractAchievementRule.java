package com.techdisqus.rules;

/**
 * abstract implementation of @{@link AchievementRule}
 * provides implementation for @{@link Cloneable} for not to allow cloning the object
 */
public abstract class AbstractAchievementRule implements AchievementRule,Cloneable {

    private final String ruleDescription;

    protected AbstractAchievementRule(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("clone not supported");
    }



    protected static boolean isNull(Object playerStatistics){
        boolean isNull = false;
        if(playerStatistics == null){
            isNull = true;
        }
        return isNull;
    }

    @Override
    public String getRuleDescription() {
        return ruleDescription;
    }
}
