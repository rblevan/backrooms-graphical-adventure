package fr.univpoitiers.backrooms.main;

import fr.univpoitiers.backrooms.controller.MenuController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. On crée le contrôleur principal (Menu)
        // La méthode .create() s'occupe de l'init et du modèle/vue
        MenuController menuController = MenuController.create();

        // On doit caster en Pane (ou Parent) pour l'ajouter à la scène
        Pane root = (Pane) menuController.getView();

        // 3. Configuration de la Scène
        Scene scene = new Scene(root, 1280, 720);

        // 4. Configuration du Stage (Fenêtre)
        primaryStage.setTitle("The Backrooms");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // Souvent préférable pour un menu avec vidéo
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}