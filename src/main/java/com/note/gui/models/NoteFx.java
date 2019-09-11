package com.note.gui.models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class NoteFx {

    private IntegerProperty idNote = new SimpleIntegerProperty();

    private StringProperty message = new SimpleStringProperty();

    private final ObjectProperty<LocalDate> messageTime = new SimpleObjectProperty<>();

    private BooleanProperty done = new SimpleBooleanProperty();
}
