package com.note.api.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Boss extends User implements SaveOrder {

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "boss_user")
    private Set<User> userSet = new HashSet<>();

    private Boss() {}

    public Boss(String nick, String password) {
        super(nick, password);
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

}
