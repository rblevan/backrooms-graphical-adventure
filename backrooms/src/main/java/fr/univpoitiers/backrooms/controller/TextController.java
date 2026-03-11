package fr.univpoitiers.backrooms.controller;

import fr.univpoitiers.backrooms.model.GameModel;
import fr.univpoitiers.backrooms.model.entity.Hero;
import fr.univpoitiers.backrooms.model.enumeration.commands.Commands;
import fr.univpoitiers.backrooms.view.TextWindow;
import javafx.stage.Stage;
import mvc.Controller;
import mvc.Model;
import mvc.View;

public class TextController extends Controller {
    private Stage primaryStage;
    private Commands commands;

    public TextController(Model model, View view) {
        super(model, view);

        if (this.view instanceof TextWindow) {
            ((TextWindow) this.view).setOnCommandEntered(this::handleCommand);
        }
    }

    public void startTextMode() {
        GameModel gameModel = (GameModel) this.getModel();
        TextWindow window = (TextWindow) this.getView();

        window.show();

        Hero player = gameModel.getHero();
        window.appendText("Welcome " + player.getUsername().toUpperCase() + " to the Backrooms.\n");
        window.appendText("You awaken as " + player.getName() + ", " + player.getDescription() + " " + player.getLocation().getDescription() + ".\n\n");
        window.appendText("Health: " + player.getPV() + "/" + player.getMax_hp() + "HP\n" +
                "Backpack Capacity: " + player.getBackpack().getUsedVolume() + "/" + player.getBackpack().getCapacityMax() + " units\n\n");
    }

    /**
    * Method that handle command input into the game.
    *
    * @param command        The command entered by the user.
    * */

    private void handleCommand(String command) {
        GameModel gameModel = (GameModel) this.getModel();
        TextWindow window = (TextWindow) this.getView();
        Hero player = gameModel.getHero();
        String result = gameModel.getCommands().processCommand(command);

        if ("QUIT_GAME".equals(result)) {
            window.hide();
            return;
        }         if (result != null && !result.trim().isEmpty()) {
                // On affiche le résultat, même si c'est le message de mort
                window.appendText(result.replace("PLAYER_DEAD", "") + "\n");
            }

        // Vérification systématique de l'état du joueur
        if (player.getPV() <= 0) {
            gameoverScreen();
        } else {
            winScreen();
        }
    }

    /**
    * Method that show the textual winning screen.
    * */

    public void winningScreen() {
        GameModel gameModel = (GameModel) this.getModel();
        TextWindow window = (TextWindow) this.getView();
        Hero player = gameModel.getHero();
        window.appendText("----------\n");
        window.appendText("| VICTORY |\n");
        window.appendText("----------\n");
        window.appendText("You have escaped a world where logic and physics do not apply.\n");
        window.appendText("You escaped the madness " + player.getUsername().toUpperCase() + ", yet you feel a strange pull to return. Do you dare answer it?\n");
        window.appendText("The game is finished, you CAN'T go anywhere else.\n");
        window.appendText("You have to type 'quit' to leave.");
    }

    private boolean checkIfPlayerWin() {
        GameModel gameModel = (GameModel) this.getModel();
        Hero player = gameModel.getHero();
        return player.getLocation().getTitle().equals("Real World");
    }

    public void winScreen() {
        if (checkIfPlayerWin()) {
            winningScreen();
        }
    }

    public void gameoverScreen() {
        TextWindow window = (TextWindow) this.getView();
        window.appendText("-----------\n");
        window.appendText("| GAME OVER |\n");
        window.appendText("-----------\n");
        window.appendText("You dead...\n");
        window.appendText("You have to type 'quit' to leave and if you want to retry.. Restart the game..");
    }

}