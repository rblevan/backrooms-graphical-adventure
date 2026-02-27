package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.entity.Hero;
import fr.univpoitiers.backrooms.model.enumeration.commands.Commands;
import fr.univpoitiers.backrooms.model.item.Backpack;
import fr.univpoitiers.backrooms.model.world.Locations;
import fr.univpoitiers.backrooms.model.world.TextBuilder;
import fr.univpoitiers.backrooms.view.TextWindow;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;

public class TextController {
    private Hero player;
    private Stage primaryStage;

    public TextController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void prepareGame() {
        // 1. Initialisation du monde
        Locations startLocation = TextBuilder.buildWorld();

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

    public void startTextMode() {
        prepareGame();
        Commands commandProcessor = new Commands(player, player.getLocation());
        TextWindow gameWindow = new TextWindow(primaryStage, commandProcessor);

        // Affichage initial
        gameWindow.appendText("Welcome " + player.getUsername().toUpperCase() + " to the Backrooms.\n");
        gameWindow.appendText("You awaken as " + player.getName() + ", " + player.getDescription() + player.getLocation().getDescription() + ".\n\n");
        gameWindow.appendText("Health: " + player.getPV() + "/" + player.getMax_hp() + "HP\n" +
                "Backpack Capacity: " + player.getBackpack().getUsedVolume() + "/" + player.getBackpack().getCapacityMax() + " units\n\n");
    }

    public void winningScreen() {
        Commands commandProcessor = new Commands(player, player.getLocation());
        TextWindow gameWindow = new TextWindow(primaryStage, commandProcessor);
        gameWindow.appendText("You have escaped a world where logic and physics do not apply.\n");
        gameWindow.appendText("You escaped the madness " + player.getUsername().toUpperCase() + ", yet you feel a strange pull to return. Do you dare answer it?");
    }

    private boolean checkIfPlayerWin() {
        return player.getLocation().getTitle().equals("Real World");
    }

    public void winScreen() {
        if (checkIfPlayerWin()) {
            winningScreen();
        }
    }
}
