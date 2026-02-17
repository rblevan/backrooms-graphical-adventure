package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.entity.Hero;
import fr.univpoitiers.backrooms.model.enumeration.commands.Commands;
import fr.univpoitiers.backrooms.model.item.Backpack;
import fr.univpoitiers.backrooms.model.world.Locations;
import fr.univpoitiers.backrooms.model.world.WorldBuilder;
import fr.univpoitiers.backrooms.view.WorldWindow;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

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
        String startLevelPath = worldBuilder.getLocations().keySet().stream()
                .filter(path -> path.contains("Map_empty.png")) // exemple
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No start map found"));
        Locations startLocation = worldBuilder.getLocation(startLevelPath);

        // 2. Création du joueur via Dialog
        String playerName = askPlayerName();
        Backpack backpack = new Backpack("Blue backpack", "A standard backpack", 120);
        String playerDesc = "an ordinary person who has lived a quiet, unremarkable life...";

        this.player = new Hero(playerName, 100, playerName, 20, playerDesc, backpack, startLocation);

    }

    public void startWorldMode() {
        Commands commandProcessor = new Commands(player, player.getLocation());
        WorldWindow worldWindow = new WorldWindow(primaryStage,commandProcessor);
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
}
