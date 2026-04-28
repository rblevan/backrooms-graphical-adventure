package fr.univpoitiers.backrooms.model;

import javafx.application.Platform;
import mvc.Model;

public class QuitModel implements Model {
    public QuitModel() { }

    @Override
    public void run(){
        Platform.exit();
    }
}
