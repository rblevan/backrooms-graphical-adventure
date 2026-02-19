package fr.univpoitiers.backrooms.view;

import fr.univpoitiers.backrooms.controller.WorldController;
import fr.univpoitiers.backrooms.model.enumeration.commands.Commands;
import fr.univpoitiers.backrooms.model.world.ObstacleMap;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WorldWindow {
    private final Stage stage;
    private final Commands commands;
    private WorldController worldController;

    public WorldWindow(Stage stage, WorldController worldController, Commands commands){
        this.stage = stage;
        this.commands = commands;
        this.worldController = worldController;

        BorderPane root = new BorderPane();

        // Charger l'image pour connaître ses dimensions
        Image mapImage = new Image(getClass().getResource("/images/map_level1.png").toExternalForm());
        ImageView background = new ImageView(mapImage);
        background.setFitHeight(800);
        background.setFitWidth(800);

        // Le conteneur de jeu doit faire la taille de l'image
        Pane gameLayer = new Pane();
        gameLayer.setPrefSize(background.getFitHeight(), background.getFitWidth());
        gameLayer.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);


        // --- ALIGNEMENT DES CASES ---
        int nbColumns = 28;
        int nbRows = 28;
        GridPane gridLayer = createGrid(nbColumns, nbRows, background);

        // Ajout des calques : le fond d'abord, la grille par-dessus
        gameLayer.getChildren().addAll(background, gridLayer);

        //Ajout hero
        ImageView heroView = addImageToLayout(gameLayer,worldController.getPlayer().getImage());

        // Pour que la map reste centrée si on agrandit la fenêtre
        root.setCenter(gameLayer);

        // Scene setup
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Backrooms game - OpenWorld");
        stage.setScene(scene);
        stage.show();

        //gameLayer.requestFocus();
        ObstacleMap obstacleMap = new ObstacleMap(28,28);
    }

    public ImageView addImageToLayout(Pane pane, Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);

        imageView.setTranslateX(worldController.getPlayer().getPosition().getX());
        imageView.setTranslateY(worldController.getPlayer().getPosition().getY());

        pane.getChildren().add(imageView);
        return imageView;
    }

    public GridPane createGrid(int columns, int rows, ImageView imageView) {
        GridPane grid = new GridPane();

        for (int i = 0; i < columns; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / columns);
            grid.getColumnConstraints().add(col);
        }

        for (int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / rows);
            grid.getRowConstraints().add(row);
        }
        grid.setGridLinesVisible(true); // debug
        grid.prefWidthProperty().bind(imageView.fitWidthProperty());
        grid.prefHeightProperty().bind(imageView.fitHeightProperty());
        return grid;
    }

}
