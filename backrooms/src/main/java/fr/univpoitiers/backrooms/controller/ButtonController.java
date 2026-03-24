package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.ButtonModel;
import fr.univpoitiers.backrooms.view.ButtonView;
import javafx.event.ActionEvent;
import mvc.Controller;

import java.util.Objects;

public class ButtonController extends Controller {

    public static ButtonController create(String name) {
        ButtonController buttonController = new ButtonController(name);
        buttonController.init();
        return buttonController;
    }

    public ButtonController(String name) {
        super(new ButtonModel(name),new ButtonView());
    }

    public void init() {
        ButtonView buttonView = (ButtonView) this.getView();
        ButtonModel buttonModel = (ButtonModel) this.getModel();

        buttonView.setText(buttonModel.getText());
        buttonView.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/button.css")).toExternalForm());
    }
}
