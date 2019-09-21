package com.note.models;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class User implements SaveOrder
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long personId;

    @Column(name = "nick", nullable = false,unique = true)
    protected String nick;

    @Column(name = "password", nullable = false)
    protected String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    private Set<Note> noteSet = new TreeSet<>();

    protected User() {
    }

    public User(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public long getPersonId() {
        return personId;
    }

    protected void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Note> getNoteSet() {
        return noteSet;
    }

    public void setNoteSet(Set<Note> noteSet) {
        this.noteSet = noteSet;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof User){
            User user = (User) o;
            return personId == user.personId && nick.equals(user.nick);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * password.hashCode() + 37 * nick.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
