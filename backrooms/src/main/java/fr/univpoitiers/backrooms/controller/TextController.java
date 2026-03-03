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
    private TextWindow gameWindow;
    private Commands commands;
    public TextController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void prepareGame() {
        Locations startLocation = TextBuilder.buildWorld();
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
        return result.orElse("Anonymous").trim().isEmpty() ? "Anonymous" : result.get();
    }

    public void startTextMode() {
        prepareGame();
        this.commands = new Commands(player, player.getLocation());
        this.gameWindow = new TextWindow(primaryStage);
        this.gameWindow.setOnCommandEntered(this::handleCommand);

        gameWindow.appendText("Welcome " + player.getUsername().toUpperCase() + " to the Backrooms.\n");
        gameWindow.appendText("You awaken as " + player.getName() + ", " + player.getDescription() + " " + player.getLocation().getDescription() + ".\n\n");
        gameWindow.appendText("Health: " + player.getPV() + "/" + player.getMax_hp() + "HP\n" +
                "Backpack Capacity: " + player.getBackpack().getUsedVolume() + "/" + player.getBackpack().getCapacityMax() + " units\n\n");
    }

    /**
    * Method that handle command input into the game.
    *
    * @param command        The command entered by the user.
    * */

    private void handleCommand(String command) {
        String result = commands.processCommand(command);
        if ("QUIT_GAME".equals(result)) {
            primaryStage.close();
            return;
        }
        if (result != null && !result.trim().isEmpty()) {
            gameWindow.appendText(result + "\n");
        }
        winScreen();
    }

    /**
    * Method that show the textual winning screen.
    * */

    public void winningScreen() {
        gameWindow.appendText("----------\n");
        gameWindow.appendText("| VICTORY |\n");
        gameWindow.appendText("----------\n");
        gameWindow.appendText("You have escaped a world where logic and physics do not apply.\n");
        gameWindow.appendText("You escaped the madness " + player.getUsername().toUpperCase() + ", yet you feel a strange pull to return. Do you dare answer it?\n");
        gameWindow.appendText("The game is finished, you CAN'T go anywhere else.\n");
        gameWindow.appendText("You have to type 'quit' to leave.");
    }

    private boolean checkIfPlayerWin() {
        return player.getLocation().getTitle().equals("Real World");
    }

    public void winScreen() {
        if (checkIfPlayerWin()) {
            winningScreen();
        }
    }

    public void gameoverScreen() {
        gameWindow.appendText("-----------\n");
        gameWindow.appendText("| GAME OVER |\n");
        gameWindow.appendText("-----------\n");
        gameWindow.appendText("You dead...\n");
        gameWindow.appendText("You have to type 'quit' to leave and if you want to retry.. Restart the game..");
    }

    public void gameOver() {
        if (player.getPV() <= 0) {
            gameoverScreen();
        }
    }
}