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

public class MenuWindow extends StackPane implements View {
    /*@Override
    public void start(Stage stage) throws Exception {*/
    private final VBox buttonContainer;
    private MediaPlayer mediaPlayer;

    public MenuWindow() {
        // 1. Mise en place de l'arrière-plan vidéo
        setupVideoBackground();

        // 2. Mise en place du conteneur pour les boutons (par-dessus la vidéo)
        buttonContainer = new VBox(15);
        buttonContainer.setAlignment(Pos.CENTER);

        // On ajoute la VBox au StackPane (elle sera donc au-dessus de la MediaView)
        this.getChildren().add(buttonContainer);
    }

    private void setupVideoBackground() {
        try {
            File videoFile = new File("chemin/vers/votre/video.mp4");
            Media media = new Media(videoFile.toURI().toString());

            mediaPlayer = new MediaPlayer(media);

            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

            MediaView mediaView = new MediaView(mediaPlayer);


            mediaView.fitWidthProperty().bind(this.widthProperty());
            mediaView.fitHeightProperty().bind(this.heightProperty());
            mediaView.setPreserveRatio(false); // Mettre à true si vous voulez garder les proportions

            // On ajoute la vidéo en premier, pour qu'elle soit tout au fond du StackPane
            this.getChildren().add(mediaView);

            // On lance la lecture
            mediaPlayer.play();

        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de la vidéo : " + e.getMessage());
        }
    }

    // Le Contrôleur utilisera cette méthode pour ajouter les boutons
    // On les ajoute dans le buttonContainer, PAS directement dans le StackPane
    public void addComponent(Node component) {
        buttonContainer.getChildren().add(component);
    }

    @Override
    public void hide() {
        super.setVisible(false);
        if (mediaPlayer != null) {
            mediaPlayer.pause(); // On met en pause si on cache le menu
        }
    }

    @Override
    public void show() {
        super.setVisible(true);
        if (mediaPlayer != null) {
            mediaPlayer.play(); // On relance quand on affiche le menu
        }
    }
}


/*

        MenuController menuController = new MenuController(stage);

        StackPane menu = new StackPane();

        menuController.setVideoBackground(menu, "/video/menu_backrooms.mp4");

        String imagePath = Objects.requireNonNull(getClass().getResource("/images/title_backrooms.png")).toExternalForm();
        ImageView title = new ImageView(new Image(imagePath));
        title.setFitWidth(400);
        title.setFitHeight(200);
        title.setPreserveRatio(true);

        VBox menuPrincipal = new VBox(100);
        menuPrincipal.setAlignment(Pos.CENTER);

        HBox menuButtons = new HBox(150);
        menuButtons.setAlignment(Pos.BOTTOM_CENTER);

        Button btnText = new Button("Mode Textuel");
        btnText.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/menu.css")).toExternalForm());

        Button btnWorld = new Button("Mode OpenWorld");
        btnWorld.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles/menu.css")).toExternalForm());

        menuButtons.getChildren().addAll(btnText, btnWorld);

        menuPrincipal.getChildren().addAll(title,menuButtons);

        menu.getChildren().add(menuPrincipal);

        TextController textController = new TextController(stage);
        WorldController WorldController = new WorldController(stage);

        btnText.setOnAction(e -> textController.startTextMode());
        btnWorld.setOnAction(e -> WorldController.startWorldMode());

        Scene scene = new Scene(menu, 800, 600);
        stage.setTitle("Starting Menu");
        stage.setScene(scene);
        stage.show();
    }
}*/
