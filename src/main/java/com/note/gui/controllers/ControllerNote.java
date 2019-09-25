package com.note.gui.controllers;

import com.note.gui.models.NoteFx;
import com.note.gui.models.UserFx;
import com.note.gui.models.services.ServiceUserFx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerNote implements Initializable {

    private UserFx userFx;

    @FXML
    private TableView<NoteFx> tableView;

    @FXML
    private TableColumn<NoteFx, Number> idTableColumn;

    @FXML
    private TableColumn<NoteFx, String> messageTableColumn;

    @FXML
    private TableColumn<NoteFx, LocalDate> dateTableColumn;

    @FXML
    private TableColumn<NoteFx, Boolean> doneTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.userFx = ServiceUserFx.getUserFx();
        tableView.setItems(userFx.getNotesFx());
        idTableColumn.setCellValueFactory(cellData -> cellData.getValue().idNoteProperty());
        messageTableColumn.setCellValueFactory(cellData -> cellData.getValue().messageProperty());
        dateTableColumn.setCellValueFactory(cellData -> cellData.getValue().messageTimeProperty());
        doneTableColumn.setCellValueFactory(cellData -> cellData.getValue().doneProperty());
        doneTableColumn.setCellFactory(tc -> new CheckBoxTableCell<>());
    }

    @FXML
    void addNote(ActionEvent event) {

    }
}
