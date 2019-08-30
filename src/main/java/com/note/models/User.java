package com.note.models;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "USER")
public class User extends Person
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQUENCE",initialValue=0, allocationSize=1)
    private long userId;

    @OneToMany(mappedBy = "user_id",cascade = CascadeType.ALL)
    private Set<Note> noteSet = new TreeSet<>();


    @ManyToOne
    private Boss boss_id;

    public User() {
    }

    public User(String nick, String password) {
        super(nick, password);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
