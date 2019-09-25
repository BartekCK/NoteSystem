package com.note.gui.models;

import com.note.api.models.Boss;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BossFx {

    private ObservableList<UserFx> users = FXCollections.observableArrayList();

    public BossFx(Boss boss){
        boss.getUserSet().forEach(e-> users.add(new UserFx(e)));
    }

    public ObservableList<UserFx> getUsers() {
        return users;
    }

    public void setUsers(ObservableList<UserFx> users) {
        this.users = users;
    }
}
