package com.note.gui;

import com.note.utilies.FxLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        primaryStage.setScene(new Scene(Objects.requireNonNull(FxLoader.getParent("/fxml/LoginPanel.fxml"))));
        primaryStage.show();

    }
}
