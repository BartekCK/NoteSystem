package com.note.models;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;

    @Column(nullable = false,unique = true)
    private String nick;

    @Column(nullable = false)
    private String password;

    public Person() {
    }

    public Person(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
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

    @Override
    public boolean equals(Object o) {
        return this.personId == ((Person) o).personId && this.nick.equals(((Person) o).nick);
    }

    @Override
    public int hashCode() {
        return (int) personId * nick.hashCode();
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
