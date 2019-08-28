package com.note;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, URISyntaxException {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/LoginPanel.fxml"));
            primaryStage.setScene(new Scene(parent));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
