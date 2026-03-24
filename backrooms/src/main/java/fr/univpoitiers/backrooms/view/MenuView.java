package fr.univpoitiers.backrooms.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import mvc.View;

import java.util.Objects;

public class MenuView extends BorderPane implements View {
    private final VBox affichagePrincipal;
    private final HBox buttonContainerCenter;
    private final HBox buttonContainerBottom;
    private MediaPlayer mediaPlayer;

    public MenuView() {
        // 2. Mise en place du conteneur pour les boutons (par-dessus la vidéo)
        affichagePrincipal = new VBox(100);
        affichagePrincipal.setAlignment(Pos.CENTER);

        buttonContainerBottom = new HBox(15);
        buttonContainerBottom.setAlignment(Pos.BOTTOM_RIGHT);

        buttonContainerCenter = new HBox(150);
        buttonContainerCenter.setAlignment(Pos.BOTTOM_CENTER);

        // On ajoute la VBox au StackPane (elle sera donc au-dessus de la MediaView)
        this.setBottom(buttonContainerBottom);
        this.setCenter(affichagePrincipal);
    }

    // Le Contrôleur utilisera cette méthode pour ajouter les boutons
    // On les ajoute dans le buttonContainer, PAS directement dans le StackPane
    public void addComponentBottom(Node component) {
        buttonContainerBottom.getChildren().add(component);
    }

    public void addComponentCenter(Node component) {
        affichagePrincipal.getChildren().add(component);
    }

    public void addComponentHBox(Node component) {
        buttonContainerCenter.getChildren().add(component);
    }

    public void setupVideoBackground(String videoPath) {
        try {
            var resource = getClass().getResource(videoPath);
            if (resource == null) return;

            // 1. Charger la vidéo
            Media media = new Media(resource.toExternalForm());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            // 2. Paramétrer
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setVolume(0.5);
            mediaPlayer.play();

            // 3. Ajuster la taille
            // "this" remplace "menuView" car nous sommes dans la classe de la vue
            mediaView.fitWidthProperty().bind(this.widthProperty());
            mediaView.fitHeightProperty().bind(this.heightProperty());
            mediaView.setPreserveRatio(false);

            // 4. Ajouter en arrière-plan (index 0)
            this.getChildren().add(0, mediaView);

        } catch (Exception e) {
            System.err.println("Erreur vidéo : " + e.getMessage());
        }
    }



    public HBox getButtonContainerCenter() {
        return buttonContainerCenter;
    }
}

