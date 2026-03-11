package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.QuitModel;
import fr.univpoitiers.backrooms.view.QuitView;
import mvc.Controller;

public class QuitController extends Controller {

    public static QuitController create(){
        QuitController quitController = new QuitController();
        quitController.init();
        return quitController;
    }

    private QuitController(){
        super(new QuitModel(), new QuitView());
    }

    private void init(){
        QuitView quitView = (QuitView)super.getView();
        QuitModel quitModel = (QuitModel)super.getModel();

        quitView.setOnAction(event -> {
            if (quitView.dialogConfirmExit()){
                quitModel.run();
            }
        });
    }
}
