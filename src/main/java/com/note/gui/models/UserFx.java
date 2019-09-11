package com.note.gui.models;

import javafx.beans.property.*;
import javafx.collections.ObservableSet;

public class UserFx {

    private IntegerProperty personId = new SimpleIntegerProperty();
    ;

    private StringProperty nick = new SimpleStringProperty();

    private StringProperty password = new SimpleStringProperty();;

    private SetProperty<NoteFx> noteSet = new SimpleSetProperty<>();

    public int getPersonId() {
        return personId.get();
    }

    public IntegerProperty personIdProperty() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId.set(personId);
    }

    public String getNick() {
        return nick.get();
    }

    public StringProperty nickProperty() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick.set(nick);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public ObservableSet<NoteFx> getNoteSet() {
        return noteSet.get();
    }

    public SetProperty<NoteFx> noteSetProperty() {
        return noteSet;
    }

    public void setNoteSet(ObservableSet<NoteFx> noteSet) {
        this.noteSet.set(noteSet);
    }
}
