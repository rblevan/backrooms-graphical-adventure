package fr.univpoitiers.backrooms.view;

import fr.univpoitiers.backrooms.model.enumeration.commands.Commands;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class WorldWindow {
    private final Stage stage;
    private final Commands commands;

    public WorldWindow(Stage stage, Commands commands){
        this.stage = stage;
        this.commands = commands;

        StackPane root = new StackPane();

        Pane mapLayer = new Pane();
        String mapCurrentPath = getClass().getResource("/images/map.png").toExternalForm();
        Image mapImage = new Image(mapCurrentPath, 800, 600, true, true);
        ImageView background = new ImageView(mapImage);
        mapLayer.getChildren().add(background);
        Pane entityLayer = new Pane();

        BorderPane uiLayer = new BorderPane();

        root.getChildren().addAll(
                mapLayer,
                entityLayer,
                uiLayer
        );

        // Scene setup
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Backrooms game - OpenWorld");
        stage.setScene(scene);
        stage.show();
    }}
