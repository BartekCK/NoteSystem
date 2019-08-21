package com.note.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "NOTE")
public class Note implements Serializable, Comparable<Note> {

    @Id
    private long idNote;

    @Column(nullable = false)
    private String message;

    @Column(name = "message_time",nullable = false)
    private LocalDate messageTime;

    @ManyToOne
    private User user_id;


    public Note() {
    }

    public long getIdNote() {
        return idNote;
    }

    public void setIdNote(long idNote) {
        this.idNote = idNote;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(LocalDate messageTime) {
        this.messageTime = messageTime;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public int compareTo(Note o) {
        return this.messageTime.compareTo(o.getMessageTime());
    }
}
