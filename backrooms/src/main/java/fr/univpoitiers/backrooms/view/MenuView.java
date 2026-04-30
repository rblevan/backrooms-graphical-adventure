package fr.univpoitiers.backrooms.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import mvc.View;


public class MenuView extends BorderPane implements View {

    private HBox buttonContainerCenter;
    private HBox buttonContainerBottom;
    private VBox titleContainer;
    private MediaPlayer mediaPlayer;

    public MenuView() {
        this.setStyle("-fx-background-color: black;");

        // Initialisation des conteneurs
        buttonContainerCenter = new HBox(30);
        buttonContainerCenter.setAlignment(Pos.CENTER);

        buttonContainerBottom = new HBox(10);
        buttonContainerBottom.setAlignment(Pos.CENTER);
        buttonContainerBottom.setStyle("-fx-padding: 30;");

        titleContainer = new VBox(50);
        titleContainer.setAlignment(Pos.CENTER);

        // Positionnement initial
        this.setCenter(titleContainer);
        this.setBottom(buttonContainerBottom);
    }

    public HBox getButtonContainerCenter() {
        return buttonContainerCenter;
    }

    /**
     * Ajoute un composant dans la HBox centrale.
     */
    public void addComponentHBox(Node node) {
        buttonContainerCenter.getChildren().add(node);
    }

    /**
     * Ajoute un composant dans la VBox centrale (Titre + Boutons).
     */
    public void addComponentCenter(Node node) {
        titleContainer.getChildren().add(node);
    }

    /**
     * Ajoute un composant dans la HBox du bas (ex: Bouton Quitter).
     */
    public void addComponentBottom(Node node) {
        buttonContainerBottom.getChildren().add(node);
    }

    public void setupVideoBackground(String videoPath) {
        try {
            var resource = getClass().getResource(videoPath);
            if (resource == null) return;

            // 1. Charger la vidéo
            Media media = new Media(resource.toExternalForm());
            this.mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            // 2. Paramétrer
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setVolume(0.1); // Réduction du volume de 0.5 à 0.1
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

    public void stopVideo() {
        if (mediaPlayer != null) {
            mediaPlayer.stop(); // Utiliser stop() au lieu de pause() et libérer les ressources si nécessaire
            mediaPlayer.dispose();
        }
    }
}