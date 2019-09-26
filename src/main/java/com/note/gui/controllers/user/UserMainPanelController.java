package com.note.gui.controllers.user;

import com.note.api.models.User;
import com.note.api.utilies.MainDao;
import com.note.gui.controllers.login.LoginPanelController;
import com.note.gui.models.NoteFx;
import com.note.gui.models.UserFx;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UserMainPanelController implements Initializable {

    private User user;
    private UserFx userFx;

    @FXML
    private DatePicker datePicker;

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

    @FXML
    void doubleClick(MouseEvent event) {
        if (event.getClickCount() == 2){
            if (tableView.getSelectionModel().getSelectedItem().isDone())
                tableView.getSelectionModel().getSelectedItem().setDone(false);
            else
                tableView.getSelectionModel().getSelectedItem().setDone(true);
            MainDao.changeNoteStatus(tableView.getSelectionModel().getSelectedItem());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = LoginPanelController.getUser();
        userFx = new UserFx(user);
        setNoteTableView(tableView, userFx, idTableColumn, messageTableColumn, dateTableColumn, doneTableColumn);
        datePicker.setValue(LocalDate.now());
        datePicker.valueProperty().addListener((observableValue, oldDate, newDate) -> {
            System.out.println(newDate.toString());
        });
    }

    public static void setNoteTableView(TableView<NoteFx> tableView, UserFx userFx, TableColumn<NoteFx, Number> idTableColumn, TableColumn<NoteFx, String> messageTableColumn, TableColumn<NoteFx, LocalDate> dateTableColumn, TableColumn<NoteFx, Boolean> doneTableColumn) {
        tableView.setItems(userFx.getNotesFx());
        idTableColumn.setCellValueFactory(cell-> cell.getValue().idNoteProperty());
        messageTableColumn.setCellValueFactory(cell-> cell.getValue().messageProperty());
        dateTableColumn.setCellValueFactory(cell-> cell.getValue().messageTimeProperty());
        doneTableColumn.setCellValueFactory(cellData -> cellData.getValue().doneProperty());
        doneTableColumn.setCellFactory(tc -> new CheckBoxTableCell<>());
    }
}
