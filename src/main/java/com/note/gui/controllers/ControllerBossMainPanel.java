package com.note.gui.controllers;

import com.note.gui.models.BossFx;
import com.note.gui.models.UserFx;
import com.note.models.Boss;
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

    private Boss boss;
    private BossFx bossFx;

    @FXML
    private TableView<UserFx> mainTableView;

    @FXML
    private TableColumn<UserFx, Number> idTableColumn;

    @FXML
    private TableColumn<UserFx, String> usernameTableColumn;

    @FXML
    private TextField serchTableView;

    @FXML
    private ListView<UserFx> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boss = (Boss) ControllerLoginPanel.getUser();
        bossFx = new BossFx(boss);
        mainTableView.setItems(bossFx.getUsers());
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().personIdProperty());
        usernameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nickProperty());
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
