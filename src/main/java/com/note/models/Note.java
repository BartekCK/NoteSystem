package com.note.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "NOTE")
public class Note implements Serializable, Comparable<Note> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTE_SEQ")
    @SequenceGenerator(name = "NOTE_SEQ", sequenceName = "NOTE_SEQUENCE", initialValue=0, allocationSize=1)
    private long idNote;

    @Column(nullable = false)
    private String message;

    @Column(name = "message_time",nullable = false)
    private final LocalDate messageTime = LocalDate.now();

    @ManyToOne
    private User user_id;

    @Column(name = "is_done")
    private boolean done;

    public Note(){
    }

    public Note(String message,User user) {
        this.message = message;
        this.user_id = user;
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

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public int compareTo(Note o) {
        return this.messageTime.compareTo(o.getMessageTime());
    }
}
