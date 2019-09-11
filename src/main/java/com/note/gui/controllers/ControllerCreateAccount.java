package com.note.gui.controllers;

import com.note.gui.utilies.MyDialog;
import com.note.models.Boss;
import com.note.models.User;
import com.note.utilies.MainDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ControllerCreateAccount {

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Text usernameError;

    @FXML
    private CheckBox bossCheckBox;

    @FXML
    void createAccount(ActionEvent event) {
        User user = new User(usernameTextField.getText(),passwordTextField.getText());
        if (bossCheckBox.isSelected())
        {
            user = new Boss(usernameTextField.getText(),passwordTextField.getText());
        }
        try {
            MainDao.save(user);
            ControllerLoginPanel.setDefaultScene();
        } catch (Exception e) {
            MyDialog.catchError(e.getMessage());
            usernameError.setVisible(true);
        }
    }

}
