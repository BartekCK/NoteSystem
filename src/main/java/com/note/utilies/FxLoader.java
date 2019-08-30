package com.note.utilies;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class FxLoader {

    public static Parent getParent(String path)
    {
        try {
            return FXMLLoader.load(FxLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
