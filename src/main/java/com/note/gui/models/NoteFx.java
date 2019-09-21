package com.note.gui.models;

import com.note.models.Note;
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

}
