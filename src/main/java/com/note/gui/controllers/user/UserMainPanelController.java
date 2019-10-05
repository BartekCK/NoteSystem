package com.note.gui.controllers.user;

import com.note.api.models.User;
import com.note.api.utilies.MainDao;
import com.note.gui.controllers.UserBoss;
import com.note.gui.controllers.login.LoginPanelController;
import com.note.gui.models.NoteFx;
import com.note.gui.models.UserFx;
import com.note.gui.utilies.TimerScheduler;
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

public class UserMainPanelController implements Initializable, UserBoss {

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
    private void doubleClick(MouseEvent event) {
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
        datePicker.valueProperty().addListener((observableValue, oldDate, newDate) -> {
            tableView.setItems(userFx.getNotesFx().filtered(e->e.getMessageTime().isEqual(datePicker.getValue())));
        });
        TimerScheduler timerScheduler = new TimerScheduler(this);
    }

    public static void setNoteTableView(TableView<NoteFx> tableView, UserFx userFx, TableColumn<NoteFx, Number> idTableColumn, TableColumn<NoteFx, String> messageTableColumn, TableColumn<NoteFx, LocalDate> dateTableColumn, TableColumn<NoteFx, Boolean> doneTableColumn) {
        tableView.setItems(userFx.getNotesFx());
        tableView.getSortOrder().add(idTableColumn);
        idTableColumn.setCellValueFactory(cell-> cell.getValue().idNoteProperty());
        messageTableColumn.setCellValueFactory(cell-> cell.getValue().messageProperty());
        dateTableColumn.setCellValueFactory(cell-> cell.getValue().messageTimeProperty());
        doneTableColumn.setCellValueFactory(cellData -> cellData.getValue().doneProperty());
        doneTableColumn.setCellFactory(tc -> new CheckBoxTableCell<>());
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserFx getUserFx() {
        return userFx;
    }


    public void setUserFx(UserFx userFx) {
        this.userFx = userFx;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }

    public TableView<NoteFx> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<NoteFx> tableView) {
        this.tableView = tableView;
    }

    public TableColumn<NoteFx, Number> getIdTableColumn() {
        return idTableColumn;
    }

    public void setIdTableColumn(TableColumn<NoteFx, Number> idTableColumn) {
        this.idTableColumn = idTableColumn;
    }

    public TableColumn<NoteFx, String> getMessageTableColumn() {
        return messageTableColumn;
    }

    public void setMessageTableColumn(TableColumn<NoteFx, String> messageTableColumn) {
        this.messageTableColumn = messageTableColumn;
    }

    public TableColumn<NoteFx, LocalDate> getDateTableColumn() {
        return dateTableColumn;
    }

    public void setDateTableColumn(TableColumn<NoteFx, LocalDate> dateTableColumn) {
        this.dateTableColumn = dateTableColumn;
    }

    public TableColumn<NoteFx, Boolean> getDoneTableColumn() {
        return doneTableColumn;
    }

    public void setDoneTableColumn(TableColumn<NoteFx, Boolean> doneTableColumn) {
        this.doneTableColumn = doneTableColumn;
    }
}
