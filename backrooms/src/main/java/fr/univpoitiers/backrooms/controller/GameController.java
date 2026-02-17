package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.entity.Hero;
import fr.univpoitiers.backrooms.model.enumeration.commands.Commands;
import fr.univpoitiers.backrooms.model.item.Backpack;
import fr.univpoitiers.backrooms.model.world.Locations;
import fr.univpoitiers.backrooms.model.world.WorldBuilder;
import fr.univpoitiers.backrooms.view.GameWindow;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.util.Optional;

public class GameController {
    private Hero player;
    private Stage primaryStage;

    public GameController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void prepareGame() {
        // 1. Initialisation du monde
        Locations startLocation = WorldBuilder.buildWorld();

        // 2. Création du joueur via Dialog
        String playerName = askPlayerName();
        Backpack backpack = new Backpack("Blue backpack", "A standard backpack", 120);
        String playerDesc = "an ordinary person who has lived a quiet, unremarkable life...";

        this.player = new Hero(playerName, 100, playerName, 20, playerDesc, backpack, startLocation);
    }

    private String askPlayerName() {
        TextInputDialog dialog = new TextInputDialog("Anonymous");
        dialog.setTitle("Backrooms - Character Creation");
        dialog.setHeaderText("Welcome to the Backrooms");
        dialog.setContentText("Enter your name:");

        Optional<String> result = dialog.showAndWait();

        if(result.orElse("Anonymous").trim().isEmpty()){
            return "Anonymous";
        }
        return result.get();
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

    public void startTextMode() {
        Commands commandProcessor = new Commands(player, player.getLocation());
        GameWindow gameWindow = new GameWindow(primaryStage, commandProcessor);

        // Affichage initial
        gameWindow.appendText("Welcome " + player.getUsername().toUpperCase() + " to the Backrooms.\n");
        gameWindow.appendText("You awaken as " + player.getName() + ", " + player.getDescription() + player.getLocation().getDescription() + ".\n\n");
        gameWindow.appendText("Health: " + player.getPV() + "/" + player.getMax_hp() + "HP\n" +
                "Backpack Capacity: " + player.getBackpack().getUsedVolume() + "/" + player.getBackpack().getCapacityMax() + " units\n\n");

    }

    public void startWorldMode() {
        // Ici tu lanceras ta future fenêtre OpenWorld
        System.out.println("Mode OpenWorld en cours de développement...");
    }
}
