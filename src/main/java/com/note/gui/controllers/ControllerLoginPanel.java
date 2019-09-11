package com.note.gui.controllers;

import com.note.gui.utilies.MyDialog;
import com.note.models.Boss;
import com.note.models.User;
import com.note.utilies.FxLoader;
import com.note.utilies.MainDao;
import javafx.event.ActionEvent;
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

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Text incorrectData;

    @FXML
    void accountCreate(MouseEvent event) {
        scene = ((Node)event.getSource()).getScene();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(Objects.requireNonNull(FxLoader.getParent("/fxml/CreatePanel.fxml"))));
    }

    @FXML
    void signIn(ActionEvent event) {
        try {
            User user = MainDao.findUser(usernameTextField.getText(),passwordTextField.getText());
            if (user instanceof Boss)
            {

            }
            else {

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

}
