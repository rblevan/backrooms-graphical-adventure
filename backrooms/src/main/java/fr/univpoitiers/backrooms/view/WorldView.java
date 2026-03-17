package fr.univpoitiers.backrooms.view;

import fr.univpoitiers.backrooms.controller.WorldController;
import fr.univpoitiers.backrooms.model.enumeration.commands.Commands;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import mvc.View;

public class WorldView extends BorderPane implements View {

    public WorldView(){
        // Charger l'image pour connaître ses dimensions
        //MyImageView myImageView = new MyImageView();

        Image mapImage = new Image(getClass().getResource("/images/levels/level1.png").toExternalForm());
        ImageView background = new ImageView(mapImage);
        background.setFitHeight(800);
        background.setFitWidth(800);

        // Le conteneur de jeu doit faire la taille de l'image
        Pane gameLayer = new Pane();
     // gameLayer.setPrefSize(background.getFitHeight(), background.getFitWidth());
        gameLayer.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);


        // --- ALIGNEMENT DES CASES ---
        int nbColumns = 28;
        int nbRows = 28;
    //    GridPane gridLayer = createGrid(nbColumns, nbRows, background);

        // Ajout des calques : le fond d'abord, la grille par-dessus
    //    gameLayer.getChildren().addAll(background, gridLayer);

        //Ajout hero
        //MyImageView myImageView = new MyImageView();
        //ImageView heroView = myImageView.addImageToLayout(gameLayer,worldController.getPlayer().getImage());


        // Pour que la map reste centrée si on agrandit la fenêtre
        this.setCenter(gameLayer);

    /*    // Scene setup
        Scene scene = new Scene(this, 1400, 1400);

        movePlayerKeyBoard(heroView,scene);
        animationTimer.start();

        stage.setTitle("Backrooms game - OpenWorld");
        stage.setScene(scene);
        stage.show();

        //gameLayer.requestFocus();
        ObstacleMap obstacleMap = new ObstacleMap(28,28);     */
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
