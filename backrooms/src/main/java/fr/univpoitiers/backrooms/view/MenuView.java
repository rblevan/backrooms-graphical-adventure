package fr.univpoitiers.backrooms.view;

import fr.univpoitiers.backrooms.controller.MenuController;
import fr.univpoitiers.backrooms.controller.TextController;
import fr.univpoitiers.backrooms.controller.WorldController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import mvc.View;

import java.io.File;
import java.util.Objects;

public class MenuView extends BorderPane implements View {
    private final HBox buttonContainerBottom;
    private MediaPlayer mediaPlayer;

    public MenuView() {
        // 2. Mise en place du conteneur pour les boutons (par-dessus la vidéo)
        buttonContainerBottom = new HBox(15);
        buttonContainerBottom.setAlignment(Pos.BOTTOM_RIGHT);

        // On ajoute la VBox au StackPane (elle sera donc au-dessus de la MediaView)
        this.setBottom(buttonContainerBottom);
    }

    public void setupVideoBackground(String videoPath) {
        try {
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
            mediaView.fitWidthProperty().bind(this.widthProperty());
            mediaView.fitHeightProperty().bind(this.heightProperty());
            mediaView.setPreserveRatio(false); // Force le remplissage

            // 4. L'ajouter au début du StackPane (en dessous de tout le reste)
            this.getChildren().add(0,mediaView);


        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de la vidéo : " + e.getMessage());
        }
    }

    // Le Contrôleur utilisera cette méthode pour ajouter les boutons
    // On les ajoute dans le buttonContainer, PAS directement dans le StackPane
    public void addComponentBottom(Node component) {
        buttonContainerBottom.getChildren().add(component);
    }
}

