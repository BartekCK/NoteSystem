package com.note.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "USER")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQUENCE",initialValue=0, allocationSize=1)
    private long userId;

    @Column(nullable = false,unique = true)
    private String nick;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user_id",cascade = CascadeType.ALL)
    private Set<Note> listNote = new TreeSet<>();


    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public Set<Note> getListNote() {
        return listNote;
    }

    private void setListNote(Set<Note> listNote) {
        this.listNote = listNote;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
