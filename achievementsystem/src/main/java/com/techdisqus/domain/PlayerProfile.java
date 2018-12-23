package com.techdisqus.domain;

/**
 * Player profile
 * Referred in @{@link PlayerStatistics}
 */
public class PlayerProfile extends AbstractProfile {

    private final String name;
    public PlayerProfile(String name, long id){
        super(id);
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
