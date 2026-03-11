package fr.univpoitiers.backrooms.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import mvc.View;

import java.util.Optional;

public class QuitView extends Button implements View {
    public QuitView() {
        super("Quit");
    }

    @Override
    public void hide(){
        super.setVisible(false);
    }

    @Override
    public void show(){
        super.setVisible(true);
    }

    public boolean dialogConfirmExit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation dialog");
        alert.setHeaderText("Do you really want to exit?");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            return true;
        }else{
            return false;
        }
    }
}
