package com.note.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControllerNote {

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> idTableColumn;

    @FXML
    private TableColumn<?, ?> messageTableColumn;

    @FXML
    private TableColumn<?, ?> dateTableColumn;

    @FXML
    private TableColumn<?, ?> doneTableColumn;

    @FXML
    void addNote(ActionEvent event) {

    }

}
