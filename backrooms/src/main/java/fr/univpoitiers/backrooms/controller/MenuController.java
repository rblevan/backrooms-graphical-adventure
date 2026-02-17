package fr.univpoitiers.backrooms.controller;

import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MenuController {
    private Stage primaryStage;

    public MenuController(Stage stage) {
        this.primaryStage = stage;
    }
    public void setVideoBackground(StackPane root, String videoPath) {
        var resource = getClass().getResource(videoPath);

        if (resource == null) {
            System.err.println("Erreur : Le fichier vidéo est introuvable dans resources !");
            return;
        }
        // 1. Charger la vidéo
        String path = resource.toExternalForm();
        Media media = new Media(path);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        // 2. Paramétrer la vidéo
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);// Boucle infini
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();

        // 3. Ajuster la taille (pour que ça remplisse la fenêtre)
        mediaView.fitWidthProperty().bind(root.widthProperty());
        mediaView.fitHeightProperty().bind(root.heightProperty());
        mediaView.setPreserveRatio(false); // Force le remplissage

        // 4. L'ajouter au début du StackPane (en dessous de tout le reste)
        root.getChildren().add(0,mediaView);
    }
}
