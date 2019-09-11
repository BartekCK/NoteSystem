package com.note.gui.controllers;

import com.note.gui.models.UserFx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerBossMainPanel implements Initializable {

    @FXML
    private TableView<UserFx> mainTableView;

    @FXML
    private TableColumn<UserFx, Long> idTableColumn;

    @FXML
    private TableColumn<UserFx, String> usernameTableColumn;

    @FXML
    private TextField serchTableView;

    @FXML
    private ListView<UserFx> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void about(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }


}
