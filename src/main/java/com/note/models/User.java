package com.note.models;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "USER")
public class User extends Person
{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Note> noteSet = new TreeSet<>();

    @ManyToOne
    private Boss boss_id;

    public User() {
    }

    public User(String nick, String password) {
        super(nick, password);
    }

    public Boss getBoss_id() {
        return boss_id;
    }

    public void setBoss_id(Boss boss_id) {
        this.boss_id = boss_id;
    }

    public Set<Note> getNoteSet() {
        return noteSet;
    }

    public void setNoteSet(Set<Note> noteSet) {
        this.noteSet = noteSet;
    }

}
