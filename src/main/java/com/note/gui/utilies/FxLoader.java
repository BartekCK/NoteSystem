package com.note.gui.utilies;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class FxLoader {

    public static Parent getParent(String path)
    {
        try {
            Parent parent = FXMLLoader.load(FxLoader.class.getResource(path));
            parent.getStylesheets().addAll(FxLoader.class.getResource(Path.PATH_CSS).toExternalForm());
            return parent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
