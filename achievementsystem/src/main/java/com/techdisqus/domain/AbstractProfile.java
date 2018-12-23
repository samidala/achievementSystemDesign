package com.techdisqus.domain;

/**
 * Abstract definition of profile
 */
public abstract class AbstractProfile {

    protected final long id;

    protected AbstractProfile(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return (int) (31 * id);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null){
            if(obj instanceof PlayerProfile){
                PlayerProfile that = (PlayerProfile) obj;
                return this.getId() == that.getId();
            }
        }
        return false;
    }
}
