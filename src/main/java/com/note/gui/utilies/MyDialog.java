package com.note.gui.utilies;

import javafx.scene.control.Alert;

public class MyDialog {

    public static void catchError (String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("ERROR");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
