package com.note.gui.controllers.boss;

import com.note.api.utilies.MainDao;
import com.note.gui.controllers.user.UserMainPanelController;
import com.note.gui.models.NoteFx;
import com.note.gui.models.UserFx;
import com.note.gui.models.services.ServiceUserFx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NoteController implements Initializable {

    private UserFx userFx;

    @FXML
    private TableView<NoteFx> tableView;

    @FXML
    private TableColumn<NoteFx, String> messageTableColumn;

    @FXML
    private TableColumn<NoteFx, LocalDate> dateTableColumn;

    @FXML
    private TableColumn<NoteFx, Boolean> doneTableColumn;

    @FXML
    private TextField textField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.userFx = ServiceUserFx.getUserFx();
        setUserFx();

    }

    @FXML
    void addNote(ActionEvent event) {
        MainDao.addNote(this.userFx,textField.getText());
        setUserFx();
    }

    private void setUserFx(){
        try {
            this.userFx = new UserFx(MainDao.findUser(userFx.getNick(),userFx.getPassword()));
            UserMainPanelController.setNoteTableView(tableView, userFx, messageTableColumn, dateTableColumn, doneTableColumn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
