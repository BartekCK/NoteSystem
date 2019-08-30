package com.note.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Boss extends Person implements SaveOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOSS_SEQ")
    @SequenceGenerator(name = "BOSS_SEQ", sequenceName = "BOSS_SEQUENCE",initialValue=0, allocationSize=1)
    private long bossId;

    @OneToMany(mappedBy = "boss_id",cascade = CascadeType.ALL)
    private Set<User> userSet = new HashSet<>();

    public Boss() {
    }

    public Boss(String nick, String password) {
        super(nick, password);
    }

    public long getBossId() {
        return bossId;
    }

    public void setBossId(long bossId) {
        this.bossId = bossId;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }


}
