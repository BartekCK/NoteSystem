package com.note.gui.controllers.login;

import com.note.gui.utilies.MyDialog;
import com.note.gui.utilies.Path;
import com.note.api.models.Boss;
import com.note.api.models.User;
import com.note.gui.utilies.FxLoader;
import com.note.api.utilies.MainDao;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class ControllerLoginPanel {

    private static Scene scene;
    private static Stage stage;
    private static User user;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Text incorrectData;

    @FXML
    void accountCreate(MouseEvent event) {
        setNextScene(event,Path.PATH_CREATE_PANEL);
    }

    @FXML
    void signIn(ActionEvent event) {
        try {
            user = MainDao.findUser(usernameTextField.getText(),passwordTextField.getText());

            if (user instanceof Boss)
            {
                setNextScene(event,Path.PATH_BOSS_MAIN_PANEL);
            }
            else {
                System.out.println("TEST");
            }
        } catch (Exception e) {
            MyDialog.catchError(e.getMessage());
            incorrectData.setVisible(true);
        }
    }

    static void setDefaultScene()
    {
        stage.setScene(scene);
    }

    private void setNextScene(Event event, String path)
    {
        scene = ((Node)event.getSource()).getScene();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(Objects.requireNonNull(FxLoader.getParent(path))));
    }

    public static User getUser() {
        return user;
    }
}
