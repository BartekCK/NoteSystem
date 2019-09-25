package com.note.gui.models;

import com.note.api.models.Note;
import javafx.beans.property.*;

import java.time.LocalDate;

public class NoteFx {

    private LongProperty idNote = new SimpleLongProperty();

    private StringProperty message = new SimpleStringProperty();

    private final ObjectProperty<LocalDate> messageTime = new SimpleObjectProperty<>();

    private BooleanProperty done = new SimpleBooleanProperty();

    public NoteFx(Note note) {
        this.idNote.setValue(note.getIdNote());
        this.message.setValue(note.getMessage());
        this.messageTime.setValue(note.getMessageTime());
        this.done.setValue(note.isDone());
    }

    public long getIdNote() {
        return idNote.get();
    }

    public LongProperty idNoteProperty() {
        return idNote;
    }

    public void setIdNote(long idNote) {
        this.idNote.set(idNote);
    }

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

    public LocalDate getMessageTime() {
        return messageTime.get();
    }

    public ObjectProperty<LocalDate> messageTimeProperty() {
        return messageTime;
    }

    public void setMessageTime(LocalDate messageTime) {
        this.messageTime.set(messageTime);
    }

    public boolean isDone() {
        return done.get();
    }

    public BooleanProperty doneProperty() {
        return done;
    }

    public void setDone(boolean done) {
        this.done.set(done);
    }

}
