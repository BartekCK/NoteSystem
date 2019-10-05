package com.note.gui;

import com.note.gui.utilies.Path;
import com.note.gui.utilies.FxLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Timer;

public class App extends Application {

    private static Timer timer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        primaryStage.setScene(new Scene(Objects.requireNonNull(FxLoader.getParent(Path.PATH_LOGIN_PANEL))));
        primaryStage.show();
        timer = new Timer();

    }

    @Override
    public void stop(){
        timer.cancel();
    }

    public static Timer getTimer() {
        return timer;
    }

    public static void setTimer(Timer timer) {
        App.timer = timer;
    }
}
