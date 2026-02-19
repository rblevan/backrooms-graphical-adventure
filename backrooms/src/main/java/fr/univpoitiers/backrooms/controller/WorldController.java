package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.entity.Hero;
import fr.univpoitiers.backrooms.model.enumeration.commands.Commands;
import fr.univpoitiers.backrooms.model.item.Backpack;
import fr.univpoitiers.backrooms.model.world.Locations;
import fr.univpoitiers.backrooms.model.world.ObstacleMap;
import fr.univpoitiers.backrooms.model.world.Position;
import fr.univpoitiers.backrooms.model.world.WorldBuilder;
import fr.univpoitiers.backrooms.view.WorldWindow;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Optional;

public class WorldController {
    private Hero player;
    private Stage primaryStage;

    public WorldController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void prepareWorld() {
        // 1. Initialisation du monde
        WorldBuilder worldBuilder = new WorldBuilder();

        //a revoir
        String startLevelPath = worldBuilder.getLocations().keySet().stream()
                .filter(path -> path.contains("Map_empty.png"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No start map found"));
        Locations startLocation = worldBuilder.getLocation(startLevelPath);

        // 2. Création du joueur via Dialog
        String playerName = askPlayerName();
        Backpack backpack = new Backpack("Blue backpack", "A standard backpack", 120);
        String playerDesc = "an ordinary person who has lived a quiet, unremarkable life...";

        //l'image du hero
        String pathImage = Objects.requireNonNull(getClass().getResource("/images/downHero.png")).toExternalForm();
        Image imageHero = new Image(pathImage);
        this.player = new Hero(playerName, 100, playerName, 20, playerDesc, backpack, startLocation, imageHero, new Position(100,100));
    }



    public void startWorldMode() {
        prepareWorld();
        Commands commandProcessor = new Commands(player, player.getLocation());
        WorldWindow worldWindow = new WorldWindow(primaryStage, this,commandProcessor);
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

    public Hero getPlayer() {
        return this.player;
    }
}
