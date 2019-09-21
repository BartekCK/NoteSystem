package com.note.gui.models;

import com.note.models.User;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserFx {

    private LongProperty personId = new SimpleLongProperty();

    private StringProperty nick = new SimpleStringProperty();

    private StringProperty password = new SimpleStringProperty();;

   private ObservableList<NoteFx> notesFx = FXCollections.observableArrayList();


    public UserFx(User user) {
        this.personId.setValue(user.getPersonId());
        this.nick.setValue(user.getNick());
        this.password.setValue(user.getPassword());
        user.getNoteSet().forEach(e->notesFx.add(new NoteFx(e)));
    }

    public long getPersonId() {
        return personId.get();
    }

    public LongProperty personIdProperty() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId.set(personId);
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

    public ObservableList<NoteFx> getNotesFx() {
        return notesFx;
    }

    public void setNotesFx(ObservableList<NoteFx> notesFx) {
        this.notesFx = notesFx;
    }
}
