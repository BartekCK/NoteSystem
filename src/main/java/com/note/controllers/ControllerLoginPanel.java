package com.note.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ControllerLoginPanel {

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Text incorrectData;

    @FXML
    void accountCreate(MouseEvent event) {
        System.out.println("CREATE");
    }

    @FXML
    void signIn(ActionEvent event) {
        System.out.println("SIGNIN");
    }

}
