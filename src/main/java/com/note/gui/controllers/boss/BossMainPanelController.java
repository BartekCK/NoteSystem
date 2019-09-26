package com.note.gui.controllers.boss;

import com.note.api.models.Boss;
import com.note.api.models.User;
import com.note.api.utilies.MainDao;
import com.note.gui.controllers.login.LoginPanelController;
import com.note.gui.models.BossFx;
import com.note.gui.models.UserFx;
import com.note.gui.models.services.ServiceUserFx;
import com.note.gui.utilies.FxLoader;
import com.note.gui.utilies.MyDialog;
import com.note.gui.utilies.Path;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class BossMainPanelController implements Initializable {

    private Boss boss;
    private BossFx bossFx;
    private UserFx userFx;

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
        boss = (Boss) LoginPanelController.getUser();
        setTableView();
        mainTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            ServiceUserFx.setUserFx(newValue);
        });
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->userFx = newValue);
    }

    private void setTableView() {
        try {
            boss = (Boss) MainDao.findUser(boss.getNick(),boss.getPassword());
            this.bossFx = new BossFx(boss);
            this.mainTableView.setItems(bossFx.getUsers());
            this.idTableColumn.setCellValueFactory(cellData -> cellData.getValue().personIdProperty());
            this.usernameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nickProperty());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void about(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Demo version");
        alert.setContentText("Hey !\nThis app was made by Bartłomiej Kotarski and this is only demo version.");
        alert.showAndWait();
    }

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void search(ActionEvent event) {
        try {
            ObservableList<UserFx> temp = FXCollections.observableArrayList();
            MainDao.findUser(serchTableView.getText()).forEach(e->temp.add(new UserFx(e)));
            listView.setItems(temp);
        } catch (Exception e) {
            listView.getItems().clear();
            MyDialog.catchError(e.getMessage());
        }
    }

    @FXML
    void openNotes(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setScene(new Scene(Objects.requireNonNull(FxLoader.getParent(Path.PATH_NOTES))));
        stage.show();
    }

    @FXML
    void addEmpolyee(MouseEvent event) {
        if (event.getClickCount() == 2 && userFx!=null){
            MainDao.addEmployee(boss,new User(userFx.getNick(),userFx.getPassword()));
            setTableView();
        }
    }
}
