package fr.univpoitiers.backrooms.view;

import fr.univpoitiers.backrooms.controller.WorldController;
import fr.univpoitiers.backrooms.model.enumeration.commands.Commands;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WorldWindow {
    private final Stage stage;
    private final Commands commands;

    public WorldWindow(Stage stage, Commands commands){
        this.stage = stage;
        this.commands = commands;

        WorldController worldController = new WorldController(stage);

        BorderPane root = new BorderPane();

        // Charger l'image pour connaître ses dimensions
        Image mapImage = new Image(getClass().getResource("/images/map_level1.png").toExternalForm());
        ImageView background = new ImageView(mapImage);

        // Le conteneur de jeu doit faire la taille de l'image
        Pane gameLayer = new Pane();
        gameLayer.setPrefSize(mapImage.getWidth(), mapImage.getHeight());
        gameLayer.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

        GridPane gridLayer = new GridPane();

        // --- ALIGNEMENT DES CASES ---
        int nbColonnes = 28;
        int nbLignes = 28;
        int cellSizeX = 50;
        int cellSizeY = 50;
        worldController.createGrid(gridLayer, nbColonnes, nbLignes, cellSizeX);

        // Ajout des calques : le fond d'abord, la grille par-dessus
        gameLayer.getChildren().addAll(background, gridLayer);

        // Ajout d'un item de test
        ImageView sandwich = new ImageView(new Image(getClass().getResource("/images/sandwich.jfif").toExternalForm()));
        sandwich.setFitWidth(cellSizeX);
        sandwich.setFitHeight(cellSizeY);
        sandwich.setPreserveRatio(true);

        // On centre l'item dans sa case
        GridPane.setHalignment(sandwich, HPos.CENTER);
        gridLayer.add(sandwich, 2, 2);

        // Pour que la map reste centrée si on agrandit la fenêtre
        StackPane centerContainer = new StackPane(gameLayer);
        root.setCenter(centerContainer);

        // Scene setup
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Backrooms game - OpenWorld");
        stage.setScene(scene);
        stage.show();
    }}
