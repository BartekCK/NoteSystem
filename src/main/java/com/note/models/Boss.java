package com.note.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Boss extends Person implements SaveOrder {

    @OneToMany(mappedBy = "boss_id",cascade = CascadeType.ALL)
    private Set<User> userSet = new HashSet<>();

    public Boss() {}

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
