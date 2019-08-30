package com.note.controllers;

import com.note.utilies.FxLoader;
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
        System.out.println("SIGNIN");
    }

    static void setDefaultScene()
    {
        stage.setScene(scene);
    }

}
