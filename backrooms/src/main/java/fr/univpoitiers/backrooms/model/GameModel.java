package fr.univpoitiers.backrooms.model;

import fr.univpoitiers.backrooms.model.entity.Hero;
import fr.univpoitiers.backrooms.model.enumeration.commands.Commands;
import fr.univpoitiers.backrooms.model.item.Backpack;
import fr.univpoitiers.backrooms.model.world.Locations;
import fr.univpoitiers.backrooms.model.world.TextBuilder;
import javafx.scene.control.TextInputDialog;
import mvc.Model;

import java.util.Optional;

public class GameModel implements Model {
    private Hero player;
    private Locations startLocation;
    private Commands commands;

    public GameModel() {
        this.startLocation = TextBuilder.buildWorld();
        String playerName = askPlayerName();
        Backpack backpack = new Backpack("Blue backpack", "A standard backpack", 120);
        String playerDesc = "an ordinary person who has lived a quiet, unremarkable life...";

        this.player = new Hero(playerName, 100, playerName, 20, playerDesc, backpack, startLocation);
        this.commands = new Commands(this.player, startLocation);
    }

    private String askPlayerName() {
        TextInputDialog dialog = new TextInputDialog("Anonymous");
        dialog.setTitle("Backrooms - Character Creation");
        dialog.setHeaderText("Welcome to the Backrooms");
        dialog.setContentText("Enter your name:");

        Optional<String> result = dialog.showAndWait();
        return result.orElse("Anonymous").trim().isEmpty() ? "Anonymous" : result.get();
    }

    @Override
    public void run() {}

    public Hero getHero() { return this.player; }
    public void setPlayer(Hero player) { this.player = player; }
    public Commands getCommands() { return commands; }
    public void setCommands(Commands commands) { this.commands = commands; }
}
